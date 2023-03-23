package org.apache.camel.learn;

import java.util.List;
import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessorHistorialPagos implements Processor {

    private final Logger LOGGER = LoggerFactory.getLogger(ProcessorHistorialPagos.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        DataSource dataSource = dataSource(url);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO historico_pagos\n" +
"(id, limitbal, sex, education, marriage, age, pay0, pay2, pay3, pay4, pay5, pay6, bill1, bill2, bill3, bill4, bill5, bill6, paycurrent1, paycurrent2, paycurrent3, paycurrent4, paycurrent5, paycurrent6, defaultpaymentnextmonth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int valido = 0;
        int errores = 0;
        List<HistorialPagos> clientes = exchange.getIn().getBody(List.class);
        if (clientes != null && !clientes.isEmpty()) {
            for (HistorialPagos cliente : clientes) {
                if (cliente.validarMontoHistorialPagos()) {
                    jdbcTemplate.update(sql, cliente.getId(),
                                             cliente.getLimitBal(), 
                                             cliente.getSex(), 
                                             cliente.getEducation(), 
                                             cliente.getMarriage(), 
                                             cliente.getAge(), 
                                             cliente.getPay0(), 
                                             cliente.getPay2(),
                                             cliente.getPay3(),
                                             cliente.getPay4(),
                                             cliente.getPay5(),
                                             cliente.getPay6(),
                                             cliente.getBill1(),
                                             cliente.getBill2(),
                                             cliente.getBill3(),
                                             cliente.getBill4(),
                                             cliente.getBill5(),
                                             cliente.getBill6(),
                                             cliente.getPayCurrent1(),
                                             cliente.getPayCurrent2(),
                                             cliente.getPayCurrent3(),
                                             cliente.getPayCurrent4(),
                                             cliente.getPayCurrent5(),
                                             cliente.getPayCurrent6(),
                                             cliente.getDefaultPaymentNextMonth()                                             
                                             );
                    valido++;
                } else {
                    errores++;
                }
            }
            generarResumenHistorialPagos(valido, errores, clientes, exchange);
        } else {
            LOGGER.info("NO EXISTE REGISTROS PARA PROCESAR ");
        }
    }

    private void generarResumenHistorialPagos(int valido, int errores, List<HistorialPagos> clientes, Exchange exchange) {
        ResumenHistorialPagosDTO resumenHistorialPagosDTO = new ResumenHistorialPagosDTO(valido, errores, clientes.size());
        LOGGER.info("TOTAL REGISTRO ARCHIVO: " + resumenHistorialPagosDTO.getTotalRegistroArchivo());
        LOGGER.info("TOTAL REGISTRO VALIDO: " + resumenHistorialPagosDTO.getRegistroValido());
        LOGGER.info("TOTAL REGISTRO ERROR VALIDACION: " + resumenHistorialPagosDTO.getRegistroConError());
        exchange.getIn().setBody(resumenHistorialPagosDTO);
    }

    private static DataSource dataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername("postgres");
        ds.setPassword("secret");
        ds.setUrl(connectURI);
        return ds;
    }

}
