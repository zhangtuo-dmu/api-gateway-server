package edu.dlmu.sei.core.service.call.ribbon;

import edu.dlmu.sei.core.service.call.CallContext;
import edu.dlmu.sei.core.service.call.Invoker;
import edu.dlmu.sei.core.service.call.Response;
import org.springframework.stereotype.Component;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Component
public class RibbonServiceInvoker implements Invoker {
    @Override
    public void invoke(CallContext context, Response response) {

    }
}
