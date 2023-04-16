package com.info.projectbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeOlaStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimeOlaStep(Tasklet imprimeOlaTasklet) {
        return stepBuilderFactory
                .get("imprimeOlaStep")
                .tasklet(imprimeOlaTasklet)
                .build();
    }

    @Bean
    public Step imprimeParImparStep(IteratorItemReader<Integer> contaAteDezReader,
                                    FunctionItemProcessor<Integer, String> parOuImparProcessor,
                                    ItemWriter<String> imprimeWriter) {

        return stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String>chunk(1) /* Ele vai ler um inteiro e escrever uma string, Em relação o tamanho do chunk, tem que ser preciso estudar o ambiente para colocar o número corretamente, pois vai ter a questão de perfomance e memoria do banco*/
                .reader(contaAteDezReader)
                .processor(parOuImparProcessor)
                .writer(imprimeWriter)
                .build();
    }

}
