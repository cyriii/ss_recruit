package com.cyriii.exception.controller;

import cn.dev33.satoken.exception.NotLoginException;
import com.cyriii.common.R;
import com.cyriii.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    /**
     * 字段校验异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidException(MethodArgumentNotValidException e){
        return R.fail(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler({BusinessException.class})
    public R businessException(BusinessException e) {
        return R.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({NotLoginException.class})
    public R loginException(NotLoginException e) {
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R commonException(Exception e) {
        log.error(e.getMessage(), e);
        return R.fail("系统异常，请联系管理员解决");
    }
}
