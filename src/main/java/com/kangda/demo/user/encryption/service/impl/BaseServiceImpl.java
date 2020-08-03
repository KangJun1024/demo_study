package com.kangda.demo.user.encryption.service.impl;

import com.kangda.demo.user.encryption.entity.vo.EncryptionSalt;
import com.kangda.demo.user.encryption.exception.RSAException;
import com.kangda.demo.user.encryption.service.IBaseService;
import com.kangda.demo.utils.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class BaseServiceImpl implements IBaseService {

    @Autowired
    private RedisTemplate redisTemplate;

    //秘钥过期时间
    private static final Integer EXPIRED_TIME = 2;
    //固定加密盐暂时用不到
    public static final String USER_SALT = "kangd.salt.secret";


    /**
     *  非对称加密
     *   0. 获取公钥 私钥
     *   1. 公钥 私钥存储到redis
     *   2. 前端公钥加密 后台用私钥解密
     * @return
     */
    @Override
    public EncryptionSalt getEncryptionSalt() {
        //随机盐 公钥
        String salt = "";
        Map<String,String> saltMap = null;
        try {
            saltMap = RSAUtils.genKeyPair();
            salt = saltMap.get(RSAUtils.PUBLIC_KEY);
        } catch (Exception e) {
            log.error("生成RSA密钥对错误:{}", e.getMessage());
            throw new RSAException("生成加密用盐异常" + e.getMessage());
        }
        //存储
        try {
            //私钥放入redis中，用于之后的解密，其对应的key是公钥，即公钥(key)-私钥(value)键值对
            redisTemplate.opsForValue().set(salt, saltMap.get(RSAUtils.PRIVATE_KEY), EXPIRED_TIME, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error("医生登录获取加密随机盐异常： {}", e);
            throw new RSAException("保存加密盐-私钥异常" + e.getMessage());
        }

        return new EncryptionSalt(USER_SALT,salt);
    }
}
