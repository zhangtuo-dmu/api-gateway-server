package edu.dlmu.sei.core.service.api;

import edu.dlmu.sei.repository.meta.ApiInfo;

/**
 * Created by zhangtuo on 2019-05-15.
 */
public interface ApiService {

    ApiInfo findApiByApiName(String apiName);
}
