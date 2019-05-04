package com.circle.core.exception;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class BizException extends RuntimeException {

    private String code;

    private String message;

    public BizException(String message){
        this.message = message;
    }

    public BizException(String code,String message){
        this.code = code;
        this.message = message;
    }
}
