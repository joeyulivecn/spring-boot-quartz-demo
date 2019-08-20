package com.joeyu.taskservice;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printTimeJobDetail() {
        return JobBuilder.newJob(PrintTimeJob.class)
                .withIdentity("PrintTimeJob")
                .usingJobData("msg", "data from msg")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger(){
        CronScheduleBuilder schedule = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())
                .withIdentity("quartzTimeService")
                .withSchedule(schedule)
                .build();
    }
}
