package edu.dlmu.sei.repository.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppClient implements Serializable {

    private long id;

    /**
     * 调用client的名
     */
    private String appClientName;

    /**
     * 调用appKey
     */
    private String appKey;

    /**
     * 调用appSecret
     */
    private String appSecret;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 生成随机20位密码
     *
     * @return
     */
    public AppClient generateSecret() {
        this.appSecret = RandomStringUtils.randomAlphabetic(20);
        return this;
    }

    /**
     * 8位随机key
     * @return
     */
    public AppClient generateKey() {
        this.appKey = (int) ((Math.random() * 9 + 1) * 10000000) + "";
        return this;
    }

}
