package edu.dlmu.sei.core.service.call;

import javax.annotation.Resource;

/**
 * Created by zhangtuo on 2019-05-15.
 */
public class CallServiceImpl implements CallService {

    @Override
    public void invoke(CallContext context, Response response) {

        Invoker invoker = InvokerFactory.getInstance("");
        invoker.invoke(context, response);
    }
}
