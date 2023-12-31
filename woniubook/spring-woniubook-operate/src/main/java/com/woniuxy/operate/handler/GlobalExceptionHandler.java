package com.woniuxy.operate.handler;

import com.woniuxy.operate.pojos.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: GlobalExceptionHandler
 * @Author Phil
 * @Date 2023/8/7 18:59
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 表示该方法只处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult handler(BusinessException e){
        return ResponseResult.fail(e.getErrorCode());
    }

    /**
     * 表示该方法只处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handler2(Exception e){
        return ResponseResult.fail(null);
    }
}
