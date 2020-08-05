package com.giovicente.validador;

import com.giovicente.cadastroproducer.Cadastro;
import com.giovicente.clients.Cnpj;
import com.giovicente.clients.CnpjClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ValidadorConsumer {

    @Autowired
    private CnpjClient cnpjClient;

    @Autowired
    private ValidadorProducer validadorProducer;

    @KafkaListener(topics = "spec3-giovanni-vicente-2", groupId = "giovanni-2")
    public void receber(@Payload Cadastro cadastro) {
        Cnpj cnpjObjeto = cnpjClient.getByCnpj(cadastro.getCnpj());

        if (cnpjObjeto.validarCapital(cnpjObjeto.getCapitalSocial())) {
            cadastro.setCadastroAprovado(true);
        } else {
            cadastro.setCadastroAprovado(false);
        }

        validadorProducer.enviarAoKafka(cadastro);
    }

}
