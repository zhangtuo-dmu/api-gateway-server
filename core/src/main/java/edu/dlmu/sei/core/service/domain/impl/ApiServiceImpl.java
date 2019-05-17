package edu.dlmu.sei.core.service.domain.impl;

import edu.dlmu.sei.core.service.domain.ApiService;
import edu.dlmu.sei.repository.meta.ApiInfo;
import org.springframework.stereotype.Service;

/**
 * Created by zhangtuo on 2019-05-16.
 */
@Service
public class ApiServiceImpl implements ApiService {
    @Override
    public ApiInfo findApiByApiName(String apiName) {
        if (apiName.equals("dlmu.api.created")) {
            return ApiInfo.builder()
                    .id(1)
                    .apiName(apiName)
                    .protocol("rpc")
                    .frontUrl("/api/gateway")
                    .backendUrl("com.netease.superplayer.api.GenericRemoteApi@execute2")
                    .build();
        }
        return null;
    }
}
