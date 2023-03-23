package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class RouteBuilderHistorialPagos extends RouteBuilder {

    DataFormat bindyCsvDataFormat = new BindyCsvDataFormat(org.apache.camel.learn.HistorialPagos.class);

    @Override
    public void configure() throws Exception {
        from("sftp:127.0.0.1:22/upload/?noop=true&username=foo&password=pass")
            .startupOrder(1)
            .to("file:src/data/historialPagos/?noop=true&fileName=cardsclients.csv")
            .to("log:Obteniendo Archivo desde SFTP a Repositorio Local")
            .end();
        from("file:src/data/historialPagos?noop=true&fileName=cardsclients.csv")
                .startupOrder(2)
                .unmarshal(bindyCsvDataFormat)
                .process(new ProcessorHistorialPagos())
                .to("log:ProcesarHistorialPagos");
    }

}
