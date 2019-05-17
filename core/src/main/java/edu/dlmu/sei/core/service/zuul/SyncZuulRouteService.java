package edu.dlmu.sei.core.service.zuul;

import edu.dlmu.sei.core.service.domain.ApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 同步路由表
 * Created by zhangtuo on 2019-05-14.
 */
@Service
public class SyncZuulRouteService {

    @Resource
    private ApiService apiService;


}
