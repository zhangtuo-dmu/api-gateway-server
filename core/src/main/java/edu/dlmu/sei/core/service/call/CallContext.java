package edu.dlmu.sei.core.service.call;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CallContext {
    /**
     * 协议
     */
    private String protocol;
    /**
     * request
     */
    private Request request;
    /**
     * 路由地址
     */
    private String backendUrl;
}
