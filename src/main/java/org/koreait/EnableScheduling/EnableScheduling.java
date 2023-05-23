package org.koreait.EnableScheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EnableScheduling {

    @Scheduled(cron = "0/5 * * * * *")
    public void cronJobSch() {
        System.out.println("스케줄러 사용만해봐요");
    }
}
