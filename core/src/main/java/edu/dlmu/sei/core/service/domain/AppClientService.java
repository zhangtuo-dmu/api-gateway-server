package edu.dlmu.sei.core.service.domain;

import edu.dlmu.sei.repository.meta.AppClient;

/**
 * Created by zhangtuo on 2019-05-15.
 */
public interface AppClientService {

    AppClient findAppClientByAppKey(String appKey);
}
