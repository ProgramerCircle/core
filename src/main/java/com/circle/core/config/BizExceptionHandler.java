package com.circle.core.config;

import com.circle.core.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BizExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public ResponseEntity<BizException> handleBizException(BizException e){
        return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

}
