package edu.dlmu.sei.core.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import edu.dlmu.sei.core.service.aop.BizExceptionInteceptor;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public abstract class BaseFilter extends ZuulFilter {

    @Override
    @BizExceptionInteceptor
    public Object run() throws ZuulException {
        return execute();
    }

    protected abstract Object execute();
}


