package com.springbatch.arquivodelimitado.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class LeituraArquivoDelimitadoJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    public Job leituraArquivoDelimitadoJob(Step leituraArquivoDelimitadoStep) {
        return jobBuilderFactory
                .get("leituraArquivoDelimitadoJob")
                .start(leituraArquivoDelimitadoStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
