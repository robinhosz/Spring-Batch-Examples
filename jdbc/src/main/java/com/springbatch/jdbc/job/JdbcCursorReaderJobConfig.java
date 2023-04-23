package com.springbatch.jdbc.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class JdbcCursorReaderJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

   @Bean
    public Job jdbcCursorReaderJob(Step jdbcCursorReaderStep) {
        return jobBuilderFactory
                .get("jdbcCursorReaderJob")
                .start(jdbcCursorReaderStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
