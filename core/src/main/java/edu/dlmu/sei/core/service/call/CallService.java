package edu.dlmu.sei.core.service.call;

/**
 * Created by zhangtuo on 2019-05-15.
 */
public interface CallService {

    void invoke(CallContext context, Response response);
}
