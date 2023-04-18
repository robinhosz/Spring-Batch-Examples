package com.springbatch.arquivomultiplos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoMultiplosFormatosJob(Step arquivoMultiplosFormatosStep) {
        return jobBuilderFactory
                .get("arquivoMultiplosFormatosJob")
                .start(arquivoMultiplosFormatosStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
