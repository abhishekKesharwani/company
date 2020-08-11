package com.bedbath.springbatchexercise2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableScheduling

public class SpringBatchExercise2Application {

    @Value("sample-data.csv")
    private FileSystemResource inputCsv;

    private static int counter = 0;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        SpringApplication.run(SpringBatchExercise2Application.class, args);
//		System.exit(SpringApplication.exit(SpringApplication.run(SpringBatchExercise2Application.class, args)));
    }

    @Scheduled(cron = "0 */1 * * * ?")
    @Retryable(value = {TimeoutException.class}, maxAttempts = 3, backoff = @Backoff(delay = 3000))
    public void perform() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, TimeoutException {

        if (!inputCsv.exists()) {
            System.out.println("Finding file Counter ::" + ++counter);
            throw new TimeoutException("Finally Time out");
        }
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }
}
