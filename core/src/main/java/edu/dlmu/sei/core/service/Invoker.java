package edu.dlmu.sei.core.service;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public interface Invoker {

    Response invoke(Request rpcRequest) throws Exception;
}
