package com.kangda.demo.user.encryption.entity.enums;

import com.kangda.demo.user.encryption.constant.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 具体错误响应参考
 *

 */
@Getter
@AllArgsConstructor
public enum ErrorResultEnum {

    /**
     * 通用400参数错误 请求错误，传入了不正确的地址，参数或值 一般是参数类型、格式、以及不传任何参数
     */
    BAD_REQUEST("BAD_REQUEST", "请求参数错误【请检查参数、参数类型、请求方式、未传请求体等】"),

    /**
     * 参数校验错误 如参数非空、参数长度、手机号校验等非业务校验 请自定义错误消息
     */
    BAD_PARAMS_REQUEST("BAD_PARAMS_REQUEST", ""),

    /**
     * 业务校验错误 请自定义错误消息 一般用于对内请求 无需扩展编码 请自定义错误消息
     */
    BAD_BIZ_REQUEST("BAD_BIZ_REQUEST", ""),

    /**
     * (token可能存在过期、无效、空值)
     */
    UNAUTHORIZED("UNAUTHORIZED", "用户未认证"),

    /**
     * 权限不足 禁止访问
     */
    FORBIDDEN("FORBIDDEN", "权限不足"),

    /**
     * 有对应的请求地址,但请求方式错误
     */
    METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED", "请求方式不允许"),

    /**
     * 服务器异常 未处理到的异常 均抛出未知异常 防止代码数据的可能泄露
     */
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "未知异常"),

    ;

    public static ErrorResult convertToErrorResult(ErrorResultEnum errorResultEnum) {
        return new ErrorResult().setErrorCode(errorResultEnum.getErrorCode())
            .setErrorMessage(errorResultEnum.getErrorMessage());
    }

    /**
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误消息
     */
    private final String errorMessage;

}
