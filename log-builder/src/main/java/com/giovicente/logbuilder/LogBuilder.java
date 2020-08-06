package com.giovicente.logbuilder;

import com.giovicente.cadastroproducer.Cadastro;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class LogBuilder {

    @KafkaListener(topics = "spec3-giovanni-vicente-3", groupId = "giovanni-3")
    public void receive(@Payload Cadastro cadastro) {
        System.out.println("Mensagem Recebida!");
    }

    public void gerarLog(Cadastro cadastro) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        String cadastroAprovado = String.valueOf(cadastro.isCadastroAprovado());

        CadastroCsv cadastroCsv = new CadastroCsv(cadastro.getCnpj(), cadastroAprovado);

        Writer writer = Files.newBufferedWriter(Paths.get("log-cadastro.csv"));
        StatefulBeanToCsv<CadastroCsv> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(cadastroCsv);

        writer.flush();
        writer.close();
    }

}
