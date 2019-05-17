package edu.dlmu.sei.core.filter.route;

import com.netflix.zuul.context.RequestContext;
import edu.dlmu.sei.common.ContextConstants;
import edu.dlmu.sei.core.filter.BaseFilter;
import edu.dlmu.sei.core.service.call.*;
import edu.dlmu.sei.repository.meta.ApiInfo;
import edu.dlmu.sei.repository.meta.AppServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Component
@Slf4j
public class RouteFilter extends BaseFilter {

    @Resource
    private CallService callService;

    @Override
    protected Object execute() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //从上下文中获取数据
        ApiInfo apiInfo = (ApiInfo) ctx.get(ContextConstants.API_INFO);
        String parameters = (String) ctx.get(ContextConstants.PARAMETERS);
        Request request = Request.builder()
                .parameters(parameters)
                .requestId((String) ctx.get(ContextConstants.REQUEST_ID))
                .build();
        //根据协议构造context
        CallContext callContext = InvokerFactory.CallContextFactory.getInstance(apiInfo.getProtocol());
        callContext.setProtocol(apiInfo.getProtocol());
        callContext.setBackendUrl(apiInfo.getBackendUrl());
        callContext.setRequest(request);
        //构造空response
        Response response = new Response();
        //调用
        callService.invoke(callContext, response);
        return null;
    }

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
