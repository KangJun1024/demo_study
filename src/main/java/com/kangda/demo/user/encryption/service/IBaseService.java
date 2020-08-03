package com.kangda.demo.user.encryption.service;

import com.kangda.demo.user.encryption.entity.vo.EncryptionSalt;

public interface IBaseService {

    EncryptionSalt getEncryptionSalt();
}
