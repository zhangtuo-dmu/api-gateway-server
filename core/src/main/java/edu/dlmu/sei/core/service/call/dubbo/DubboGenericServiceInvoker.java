package edu.dlmu.sei.core.service.call.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import edu.dlmu.sei.common.enums.ResponseCodeEnum;
import edu.dlmu.sei.core.service.call.CallContext;
import edu.dlmu.sei.core.service.call.Invoker;
import edu.dlmu.sei.core.service.call.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Component
@Slf4j
public class DubboGenericServiceInvoker implements Invoker {

    private ConcurrentHashMap<String, ReferenceConfig<GenericService>> referenceConfigCache = new ConcurrentHashMap<>();

    @Resource
    private ApplicationConfig application;

    @Resource
    private RegistryConfig registryConfig;

    private List<RegistryConfig> registries = Lists.newArrayList(registryConfig);

    @Override
    public void invoke(CallContext context, Response response) {
        RpcContext rpcContext = (RpcContext) context;
        try {
            String referenceCacheKey = new StringBuilder()
                    .append(rpcContext.getClassName()).append("-")
                    .append(rpcContext.getServiceVersion()).toString();
            ReferenceConfig<GenericService> reference = referenceConfigCache.get(referenceCacheKey);
            if (reference == null) {
                reference = new ReferenceConfig<>();
            }
            reference.setApplication(application);
            reference.setRegistries(registries);
            reference.setGeneric(true);
            reference.setInterface(rpcContext.getClassName());
            reference.setRetries(0);
            Long s = System.currentTimeMillis();
            //获取泛化service
            GenericService genericService = reference.get();
            Long t = System.currentTimeMillis() - s;

            log.info("reference.get() success ,spend time=" + t + "ms"+","+rpcContext);
            if (genericService == null) {

            } else {
                referenceConfigCache.put(referenceCacheKey, reference);
                ObjectMapper objectMapper = new ObjectMapper();
                List<?> parameters = objectMapper.readValue(rpcContext
                        .getRequest().getParameters(), ArrayList.class);
                //泛化调用
                Object result = genericService.$invoke(rpcContext.getMethodName(), null, parameters.toArray());
                response.success(result);
            }
        } catch (Exception e) {
            log.error("{}", rpcContext);
            log.error("{}", e);
            String messageString = e.getMessage();
            if (messageString != null && messageString.contains("ConstraintViolation")) {
                response.setWithRpcResultCodeEnum(ResponseCodeEnum.VALIDATION_ERROR);
//                Map<String, String> vaidationResultMap = buildValidationResult(messageString);
               // response.setData(vaidationResultMap);
            } else {
                response.setWithRpcResultCodeEnum(ResponseCodeEnum.METHOD_INVOKE_ERROR);
            }
        }
    }
}

