package com.kangda.demo.user.encryption.controller;

import com.kangda.demo.user.encryption.entity.vo.EncryptionSalt;
import com.kangda.demo.user.encryption.service.IBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangjun
 * @since  2020-08-03
 * <p>
 * 获取加密用随机盐等基础服务
 */
@Slf4j
@RestController
@Api(tags = "基础服务")
public class BaseController {

    @Autowired
    private IBaseService baseService;

    @GetMapping("/salt")
    @ApiOperation("获取加密用盐")
    public EncryptionSalt getEncryptionSalt() {
        return baseService.getEncryptionSalt();
    }

}