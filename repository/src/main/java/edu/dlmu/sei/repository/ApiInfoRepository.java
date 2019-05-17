package edu.dlmu.sei.repository;

import edu.dlmu.sei.repository.meta.ApiInfo;

/**
 * Created by zhangtuo on 2019-05-15.
 */
public interface ApiInfoRepository {

    ApiInfo findApiByApiName(String apiName);
}
