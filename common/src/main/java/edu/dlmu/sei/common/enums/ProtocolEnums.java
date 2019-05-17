package edu.dlmu.sei.common.enums;

import edu.dlmu.sei.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhangtuo on 2019-05-16.
 */
@Getter
@AllArgsConstructor
public enum ProtocolEnums {
    RPC("rpc"), HTTP("http");
    String protocol;

    public static ProtocolEnums nameOf(String protocol) {
        for (ProtocolEnums e : ProtocolEnums.values()) {
            if (e.getProtocol().equals(protocol)) {
                return e;
            }
        }
        throw new BusinessException("Protocol error");
    }
}
