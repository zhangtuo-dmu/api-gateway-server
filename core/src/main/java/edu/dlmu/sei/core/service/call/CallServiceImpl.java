package edu.dlmu.sei.core.service.call;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@Service
public class CallServiceImpl implements CallService {

    @Resource
    InvokerFactory invokerFactory;

    @Override
    public void invoke(CallContext context, Response response) {
        //实例化invoker和构建context
        Invoker invoker = invokerFactory.getInstance(context.getProtocol());
        invokerFactory.buildContext(context);
        invoker.invoke(context, response);
    }
}
