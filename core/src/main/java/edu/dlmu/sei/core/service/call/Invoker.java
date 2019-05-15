package edu.dlmu.sei.core.service.call;

import edu.dlmu.sei.core.service.call.CallContext;
import edu.dlmu.sei.core.service.call.Response;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public interface Invoker {

    void invoke(CallContext context, Response response);

}
