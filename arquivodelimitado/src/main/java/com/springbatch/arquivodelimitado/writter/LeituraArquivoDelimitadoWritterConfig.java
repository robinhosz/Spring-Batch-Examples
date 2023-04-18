package com.springbatch.arquivodelimitado.writter;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.springbatch.second.dominio.Cliente;
@Configuration
public class LeituraArquivoDelimitadoWritterConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoDelimitadoWritter() {
        return itens -> itens.forEach(System.out::println);
    }
}
