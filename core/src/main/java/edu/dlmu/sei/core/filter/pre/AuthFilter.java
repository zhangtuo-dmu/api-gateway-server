package edu.dlmu.sei.core.filter.pre;

import edu.dlmu.sei.core.filter.BaseFilter;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public class AuthFilter extends BaseFilter {
    @Override
    protected Object execute() {
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
