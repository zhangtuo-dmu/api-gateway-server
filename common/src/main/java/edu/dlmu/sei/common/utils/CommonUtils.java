package edu.dlmu.sei.common.utils;

import java.util.UUID;

/**
 * Created by zhangtuo on 2019-05-14.
 */
public class CommonUtils {
    /** @return uuid v4 random uuid */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

}
