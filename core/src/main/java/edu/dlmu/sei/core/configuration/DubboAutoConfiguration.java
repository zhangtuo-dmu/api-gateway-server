package edu.dlmu.sei.core.configuration;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@Configuration
public class DubboAutoConfiguration {

    /**
     * APPLICATION
     */

    /**
     * 泛化接口引用
     */
    @Bean("genericServiceReferenceConfig")
    public ReferenceConfig<GenericService> genericServiceReferenceConfig() {
        return new ReferenceConfig<>();
    }
}
