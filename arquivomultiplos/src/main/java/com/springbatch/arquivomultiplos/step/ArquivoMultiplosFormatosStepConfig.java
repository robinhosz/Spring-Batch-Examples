package com.springbatch.arquivomultiplos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step arquivoMultiplosFormatosStep(FlatFileItemReader arquivosMultiplosFormatosReader,
                                                   ItemWriter arquivosMultiplosFormatosWritter) {
        return stepBuilderFactory
                .get("arquivoMultiplosFormatosStep")
                .chunk(1)
                .reader(arquivosMultiplosFormatosReader)
                .writer(arquivosMultiplosFormatosWritter)
                .build();

    }
}
