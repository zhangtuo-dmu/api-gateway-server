package edu.dlmu.sei.core.service.dubbo;

import edu.dlmu.sei.core.service.Invoker;
import edu.dlmu.sei.core.service.Request;
import edu.dlmu.sei.core.service.Response;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public class DubboGenericServiceInvoker implements Invoker {

    @Override
    public Response invoke(Request rpcRequest) throws Exception {
        RpcContext context = (RpcContext) rpcRequest;

        return null;
    }
}
