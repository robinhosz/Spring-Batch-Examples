package com.springbatch.jdbc.step;

import ch.qos.logback.core.net.server.Client;
import com.springbatch.jdbc.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step jdbcCursorReaderStep(ItemReader<Cliente> jdbcCursorReader, ItemWriter<Cliente> jdbcCursorWriter) {

        return stepBuilderFactory
                .get("jdbcCursorReaderStep")
                .<Cliente, Cliente> chunk(1)
                .reader(jdbcCursorReader)
                .writer(jdbcCursorWriter)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(2)
                .build();

    }

}
