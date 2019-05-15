package edu.dlmu.sei.core.service.ratelimiter;

import com.google.common.collect.Maps;
import edu.dlmu.sei.common.enums.RateLimiterCommandEnums;
import edu.dlmu.sei.core.service.ratelimiter.command.RateLimiterCommand;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Component
public class RateLimiterInvoker implements ApplicationContextAware {

    private Map<RateLimiterCommandEnums, RateLimiterCommand> commands = Maps.newHashMap();

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {

    }

    public boolean execute(String commandName, RateContext rateCtx) {
        RateLimiterCommandEnums commandEnums = RateLimiterCommandEnums.nameOf(commandName);
        RateLimiterCommand command = commands.get(commandEnums);
        return command.execute(rateCtx);
    }
}
