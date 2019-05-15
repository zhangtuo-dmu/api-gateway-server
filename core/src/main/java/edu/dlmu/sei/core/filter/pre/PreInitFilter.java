package edu.dlmu.sei.core.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.util.HTTPRequestUtils;
import edu.dlmu.sei.common.exception.BusinessException;
import edu.dlmu.sei.core.filter.BaseFilter;
import edu.dlmu.sei.core.service.api.ApiService;
import edu.dlmu.sei.core.service.appclient.AppClientService;
import edu.dlmu.sei.repository.meta.ApiInfo;
import edu.dlmu.sei.repository.meta.AppClient;
import edu.dlmu.sei.repository.meta.CallStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Optional;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Component
@Slf4j
public class PreInitFilter extends BaseFilter {

    @Resource
    private ApiService apiService;

    @Resource
    private AppClientService appClientService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    protected Object execute() {
        RequestContext ctx = RequestContext.getCurrentContext();
        /**
         * 从上下文获取route的唯一key，在PreDecorationFilter里put进去
         */
        String apiName = Optional.ofNullable((String) ctx.get(FilterConstants.PROXY_KEY))
                .orElseThrow(() -> new BusinessException(""));

        ApiInfo apiInfo = Optional.ofNullable(this.apiService.findApiByApiName(apiName))
                .orElseThrow(() -> new BusinessException(""));
        ctx.set("apiInfo", apiInfo);

        /**
         * 构造统计数据
         */
        CallStatistics callStatistics = CallStatistics.builder()
                .apiId(apiInfo.getId())
                .callTime(new Timestamp(System.currentTimeMillis()))
                .build();
        /**
         * 获取key，查询client数据
         */
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        String appKey = httpServletRequest.getHeader("appKey");
        if (!StringUtils.isEmpty(appKey)) {
            AppClient appClient = appClientService.findAppClientByAppKey(appKey);
            if (appClient == null) {
                log.warn("AppClient is null, appKey = {}", appKey);
            } else {
                ctx.set("appClient", appClient);
                callStatistics.setAppClientId(appClient.getId());
            }
        }
        callStatistics.setClientAddress(HTTPRequestUtils.getInstance().getClientIP(httpServletRequest));
        /**
         * 统计数据放入上下文
         */
        ctx.set("callStatistics", callStatistics);
        return null;
    }
}
