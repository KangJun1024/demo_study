package com.kangda.demo.user.encryption.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="加密用盐", description="")
public class EncryptionSalt {

    @ApiModelProperty(value = "固定盐")
    private String fixed;

    @ApiModelProperty(value = "随机盐")
    private String salt;

    public EncryptionSalt(){

    }

    public EncryptionSalt(String fixed, String salt) {
        this.fixed=fixed;
        this.salt=salt;
    }
}
