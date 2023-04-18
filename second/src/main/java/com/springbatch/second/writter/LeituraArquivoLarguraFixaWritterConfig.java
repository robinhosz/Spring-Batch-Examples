package com.springbatch.second.writter;

import com.springbatch.second.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWritterConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaWritter(){
        return itens -> itens.forEach(System.out::println);
    }
}
