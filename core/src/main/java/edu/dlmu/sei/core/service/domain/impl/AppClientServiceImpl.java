package edu.dlmu.sei.core.service.domain.impl;

import edu.dlmu.sei.core.service.domain.AppClientService;
import edu.dlmu.sei.repository.meta.AppClient;
import org.springframework.stereotype.Service;

/**
 * Created by zhangtuo on 2019-05-16.
 */
@Service
public class AppClientServiceImpl implements AppClientService {
    @Override
    public AppClient findAppClientByAppKey(String appKey) {
        return null;
    }
}
