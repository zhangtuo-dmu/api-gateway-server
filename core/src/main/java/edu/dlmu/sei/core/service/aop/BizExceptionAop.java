package edu.dlmu.sei.core.service.aop;

import com.netflix.zuul.exception.ZuulException;
import edu.dlmu.sei.common.exception.BusinessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@Component
@Aspect
public class BizExceptionAop {

    @Around("@annotation(ri)")
    public Object monitor(ProceedingJoinPoint pjp, BizExceptionInteceptor ri) throws Throwable {
        try {
            pjp.proceed();
        } catch (BusinessException e) {
            throw new ZuulException(e.getMessage(), e.getCode(), "");
        }
        return null;
    }
}
