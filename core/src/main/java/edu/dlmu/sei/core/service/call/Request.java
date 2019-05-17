package edu.dlmu.sei.core.service.call;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangtuo on 2019-05-16.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Request {
    //请求参数，json串
    private String parameters;
    //请求的唯一id标识
    private String requestId;
}
