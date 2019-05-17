package edu.dlmu.sei.core.service.call;

import edu.dlmu.sei.common.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * Created by zhangtuo on 2019-05-15.
 */
public class Response implements Serializable {

    private static final long serialVersionUID = -2940045837162445419L;

    private int code;
    private String message;
    private Object data;


    public Response() {
        super();

    }

    public Response(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == ResponseCodeEnum.SUCCESS.getCode();
    }

    public boolean isValid() {
        return this.code != ResponseCodeEnum.VALIDATION_ERROR.getCode();
    }
    @Override
    public String toString() {
        return "RpcResult [code=" + code + ", message=" + message + ", data="
                + data + "]";
    }

    public void success(Object data) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.data = data;
    }

    public void setWithRpcResultCodeEnum(ResponseCodeEnum error) {
        this.setCode(error.getCode());
        this.setMessage(error.getMessage());
    }

}
