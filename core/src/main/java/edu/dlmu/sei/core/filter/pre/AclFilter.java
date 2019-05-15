package edu.dlmu.sei.core.filter.pre;

import com.netflix.zuul.exception.ZuulException;
import edu.dlmu.sei.core.filter.BaseFilter;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public class AclFilter extends BaseFilter {
    @Override
    protected Object execute() throws ZuulException {
        return null;
    }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }
}
