package edu.dlmu.sei.core.service.call;


import edu.dlmu.sei.common.enums.ProtocolEnums;
import edu.dlmu.sei.common.enums.ResponseCodeEnum;
import edu.dlmu.sei.common.exception.BusinessException;
import edu.dlmu.sei.core.service.call.dubbo.DubboGenericServiceInvoker;
import edu.dlmu.sei.core.service.call.dubbo.RpcContext;
import edu.dlmu.sei.core.service.call.ribbon.HttpContext;
import edu.dlmu.sei.core.service.call.ribbon.RibbonServiceInvoker;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@Component
public class InvokerFactory implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public Invoker getInstance(String protocol) {
        if (protocol.equals(ProtocolEnums.RPC.getProtocol())) {
            return (Invoker) ctx.getBeansOfType(DubboGenericServiceInvoker.class);
        }
        if (protocol.equals(ProtocolEnums.HTTP.getProtocol())) {
            return (Invoker) ctx.getBeansOfType(RibbonServiceInvoker.class);
        }
        return null;
    }

    public void buildContext(CallContext context) {
        String backendUrl = context.getBackendUrl();
        if (StringUtils.isEmpty(backendUrl)) {
            throw new BusinessException("backend url is empty!");
        }
        String[] urlArr = backendUrl.split("@");
        if (context instanceof RpcContext) {
            if (urlArr.length < 2 || urlArr.length > 3) {
                throw new BusinessException(
                        ResponseCodeEnum.METHOD_ENDPOINT_ERROR.getCode(), ResponseCodeEnum.METHOD_ENDPOINT_ERROR.getMessage());
            }
            ((RpcContext) context).setClassName(urlArr[0]);
            ((RpcContext) context).setMethodName(urlArr[1]);
            if (urlArr.length == 3) {
                ((RpcContext) context).setServiceVersion(urlArr[2]);
            }
        }
        if (context instanceof HttpContext) {
            ((HttpContext) context).setHttpMethod(urlArr[0]);
            ((HttpContext) context).setHttpUrl(urlArr[1]);
        }
    }

    public static class CallContextFactory {
        public static CallContext getInstance(String protocol) {
            ProtocolEnums protocolEnums = ProtocolEnums.nameOf(protocol);
            if (protocolEnums == ProtocolEnums.RPC) {
                return new RpcContext();
            }
            if (protocolEnums == ProtocolEnums.HTTP) {
                return new HttpContext();
            }
            return new CallContext();
        }
    }
}
