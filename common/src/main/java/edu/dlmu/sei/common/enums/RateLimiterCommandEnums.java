package edu.dlmu.sei.common.enums;

import edu.dlmu.sei.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@AllArgsConstructor
@Getter
public enum RateLimiterCommandEnums {

    LIMIT("","");

    private String beanName;

    private String commandName;

    public static RateLimiterCommandEnums nameOf(String commandName) {
        for (RateLimiterCommandEnums e: RateLimiterCommandEnums.values()) {
            if (e.getCommandName().equals(commandName)) {
                return e;
            }
        }
        throw new BusinessException("Ratelimit command error!");
    }
}
