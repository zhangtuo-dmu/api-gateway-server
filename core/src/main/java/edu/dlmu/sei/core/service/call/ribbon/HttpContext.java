package edu.dlmu.sei.core.service.call.ribbon;

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
public class HttpContext extends CallContext {

    private String httpMethod;

    private String httpUrl;
}
