package edu.dlmu.sei.repository.meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhangtuo on 2019-05-15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAuthorization implements Serializable {
    /**
     * id
     */
    private long id;
    /**
     * 路由api的id
     */
    private long RouteId;
    /**
     * 调用者id
     */
    private long appClientId;
}

