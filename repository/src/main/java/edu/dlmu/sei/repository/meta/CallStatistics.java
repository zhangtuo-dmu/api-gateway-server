package edu.dlmu.sei.repository.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CallStatistics implements Serializable {

    private long id;

    /**
     *  路由API
     */
    private long apiId;

    /**
     * 调用appClient
     */
    private long appClientId;

    /**
     * 失败原因
     */
    private String failCause;

    /**
     * 调用地址
     */
    private String clientAddress;

    /**
     * 调用响应时长
     */
    private long responseTime;

    /**
     * 响应报文, 大文本
     */
    private String response;

    /**
     * 响应状态（200，500，符合HTTP响应标准状态码或者自定义错误码）
     */
    private int status;

    /**
     *
     */
    private Timestamp callTime;

}
