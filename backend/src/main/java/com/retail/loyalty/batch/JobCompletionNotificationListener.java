package com.retail.loyalty.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // Code to execute before the job starts
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        // Code to execute after the job completes
    }
}