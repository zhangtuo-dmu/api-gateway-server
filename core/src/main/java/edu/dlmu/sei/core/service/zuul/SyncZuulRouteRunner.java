package edu.dlmu.sei.core.service.zuul;

import edu.dlmu.sei.core.service.domain.ApiService;
import edu.dlmu.sei.repository.meta.ApiInfo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 启动后加载路由runner
 * Created by zhangtuo on 2019-05-14.
 */
@Component
public class SyncZuulRouteRunner implements ApplicationRunner {

    @Resource
    private DiscoveryClientRouteLocator discoveryClientRouteLocator;

    @Resource
    private ZuulProperties zuulProperties;

    @Resource
    private ApiService apiService;


    @Override
    public void run(ApplicationArguments args) {
        ApiInfo apiInfo = apiService.findApiByApiName("dlmu.api.create3");
        Map<String, ZuulProperties.ZuulRoute> routes = this.zuulProperties.getRoutes();
        ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
        zuulRoute.setId(apiInfo.getApiName());
        zuulRoute.setPath(apiInfo.getFrontUrl());
        zuulRoute.setLocation(apiInfo.getBackendUrl());

        routes.put(apiInfo.getApiName(), zuulRoute);
        this.zuulProperties.setRoutes(routes);
        this.discoveryClientRouteLocator.refresh();

    }
}
