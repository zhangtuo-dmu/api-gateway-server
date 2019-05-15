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
public class ApiInfo implements Serializable {

    private static final long serialVersionUID = 5536079162207944999L;
    // id
    private long id;
    // appName
    private String apiName;
    // appServerId
    private long appServerId;
    //描述
    private String description;
    //版本
    private String version;
    //前端接口地址
    private String frontUrl;
    // 后端地址
    private String backendUrl;
    // 后端超时
    private long backendTimeout;
    // http 1 dubbo 2
    private int protocal;
    // 是否开启auth
    private boolean isAuth;

    private Timestamp createTime;

    private Timestamp upateTime;

}

