package edu.dlmu.sei.repository.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppServer implements Serializable {

    private static final long serialVersionUID = -7419228217219983700L;

    private long id;
    /**
     * 业务服务名，唯一标识
     */
    private String appServerName;
    /**
     * 服务描述
     */
    private String description;
    /**
     * 状态，是否禁用，禁用0 默认启用1
     */
    private long status;

    /**
     * 后端服务地址，支持集群(1.1.1.1:8888,1.1.1.2:88888,1.1.1.3:8888), dubbo 则无
     */
    private String address;

    private Timestamp createTime;

    private Timestamp updateTime;
}

