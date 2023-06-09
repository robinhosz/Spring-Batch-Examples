package com.info.projectbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableBatchProcessing
@Configuration
public class ImprimeOlaJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job imprimeOlaJob(Step imprimeOlaStep) {
        return jobBuilderFactory
                .get("imprimeOlaJob")
                .start(imprimeOlaStep)
                .incrementer(new RunIdIncrementer()) //Executa o job e adiciona um id ao run id do job, e permite que o job execute mais de uma vez.
                .build();
    }

    @Bean
    public Job imprimeParImparJob(Step imprimeParImparStep) {
        return jobBuilderFactory.get("imprimeParImparJob")
                .start(imprimeParImparStep)
                .incrementer(new RunIdIncrementer()) //Executa o job e adiciona um id ao run id do job, e permite que o job execute mais de uma vez.
                .build();
    }
}
