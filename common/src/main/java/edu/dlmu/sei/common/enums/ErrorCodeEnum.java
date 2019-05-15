package edu.dlmu.sei.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    NO_ROUTE_FOUND(1000, "No route found for uri: %s"),

    APP_KEY_OR_ACCESS_TOKEN_IS_NULL(1001, "AppKey or AccessToken isNull!"),

    UNAUTHORIZED(1002, "Unauthorized Client!"),

    TOKEN_ERROR(1003, "AccessToken is error! Please check token."),

    TOKEN_EXPIRED(1004, "AccessToken is expired! Please use new accessToken!");

    int code;

    String msg;
}

