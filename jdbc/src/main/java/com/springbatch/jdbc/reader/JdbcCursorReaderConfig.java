package com.springbatch.jdbc.reader;

import ch.qos.logback.core.net.server.Client;
import com.springbatch.jdbc.dominio.Cliente;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class JdbcCursorReaderConfig {

    @Bean
    public JdbcCursorItemReader<Cliente> jdbcCursorReader(@Qualifier("appDataSource") DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Cliente>()
                .name("jdbcCursorReader")
                .dataSource(dataSource)
                .sql("select * from cliente")
               // .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class)) rowMapper padrão
                .rowMapper(rowMapper())// rowMapper customizado com tratativa de exceptions
                .build();
    }

    private RowMapper<Cliente> rowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                if (rs.getRow() <= 16)
                    throw new SQLException(String.format("Encerrando a execução - Cliente inválido %s", rs.getString("email")));
                else return clienteRowMapper(rs);
            }

            private Cliente clienteRowMapper(ResultSet rs) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setIdade(rs.getString("idade"));
                cliente.setEmail(rs.getString("email"));
                return cliente;

            }
        };
    }
}
