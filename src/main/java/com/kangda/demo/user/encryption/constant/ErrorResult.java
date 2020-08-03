package com.kangda.demo.user.encryption.constant;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 错误响应体
 */
@Data
@Accessors(chain = true)
public class ErrorResult {

    //    @JsonProperty("error_code")
    private String errorCode;

    //    @JsonProperty("error_message")
    private String errorMessage;

}
