package com.taishou.console.MQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/1-17:53
 * @Version:
 */
@Service
@Slf4j
public class SomeHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable throwable) {
        log.error("Error in listener",throwable);
    }
}
