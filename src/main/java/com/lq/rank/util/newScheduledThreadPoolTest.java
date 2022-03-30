package com.lq.rank.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author LQ
 * @date 2021/03/17 17:21
 */
public class newScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        System.out.println("开始时间..."+ LocalTime.now());
        pool.scheduleAtFixedRate(() -> System.out.println("执行"+LocalTime.now()), 5,60, TimeUnit.SECONDS);

    }
}
