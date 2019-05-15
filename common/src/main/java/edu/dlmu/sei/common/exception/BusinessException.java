package edu.dlmu.sei.common.exception;

import edu.dlmu.sei.common.enums.ErrorCodeEnum;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public class BusinessException extends RuntimeException {
    /**
     * 业务错误码
     */
    protected int code;

    public BusinessException() {
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        this(errorCodeEnum.getCode(), errorCodeEnum.getMsg());
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String msg) {
        this(errorCodeEnum.getCode(), errorCodeEnum.getMsg() + ":" + msg);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

