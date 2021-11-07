package com.example.heima.spring.event;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/9
 */
@Getter
public class JavaStackEvent extends ApplicationEvent {
    public JavaStackEvent(Object source) {
        super(source);
    }
}