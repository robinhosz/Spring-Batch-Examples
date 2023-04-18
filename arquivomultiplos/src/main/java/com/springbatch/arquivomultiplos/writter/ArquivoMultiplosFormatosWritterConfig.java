package com.springbatch.arquivomultiplos.writter;

import com.springbatch.arquivomultiplos.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosWritterConfig {

    @Bean
    public ItemWriter arquivoMultiplosFormatosWritter() {
        return itens -> itens.forEach(System.out::println);
    }
}
