package edu.dlmu.sei.core.filter.route;

import edu.dlmu.sei.core.filter.BaseFilter;
import edu.dlmu.sei.core.service.call.CallService;
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
        callService.invoke(null, null);
        return null;
    }

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
