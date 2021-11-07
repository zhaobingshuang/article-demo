package com.example.heima.spring.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Async;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/9
 */
@Slf4j
@RequiredArgsConstructor
public class ReaderListener implements ApplicationListener<JavaStackEvent> {

    @NonNull
    private String name;

    private String article;

    @Async
    @Override
    public void onApplicationEvent(JavaStackEvent event) {
        // 更新文章
        updateArticle(event);
    }

    private void updateArticle(JavaStackEvent event) {
        this.article = (String) event.getSource();
        log.info("我是读者：{}，文章已更新为：{}\n", this.name, this.article);
    }
}
