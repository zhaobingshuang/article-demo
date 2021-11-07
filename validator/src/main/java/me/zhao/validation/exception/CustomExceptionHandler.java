package me.zhao.validation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object onMethodArgumentNotValidException (MethodArgumentNotValidException e) {
        // 处理
        log.error("MethodArgumentNotValidException 异常", e);
        return null;
    }
}