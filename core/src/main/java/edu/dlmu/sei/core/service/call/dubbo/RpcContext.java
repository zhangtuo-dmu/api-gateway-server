package edu.dlmu.sei.core.service.call.dubbo;

import edu.dlmu.sei.core.service.call.CallContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangtuo on 2019-05-16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcContext extends CallContext {

    private String className;

    private String serviceVersion;

    private String methodName;

}
