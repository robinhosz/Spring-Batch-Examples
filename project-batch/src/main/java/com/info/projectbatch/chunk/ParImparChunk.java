package com.info.projectbatch.chunk;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ParImparChunk {

    @Bean
    public IteratorItemReader<Integer> contaAteDezReader() {
        List<Integer> numeroDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(numeroDeUmAteDez.iterator());
    }

    @Bean
    public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0 ? String.format("Item %s é par", item)
                : String.format("Item %s é Impar", item));
    }

    @Bean
    public ItemWriter<String> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }
}
