package com.joeyu.taskservice;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

public class PrintTimeJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String msg = (String) context.getJobDetail().getJobDataMap().get("msg");
        System.out.println(LocalDateTime.now() + ":" + msg);
    }
}
