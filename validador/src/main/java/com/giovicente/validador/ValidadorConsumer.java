package com.giovicente.validador;

import com.giovicente.cadastroproducer.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsumer {

    @Autowired
    private ValidadorService validadorService;

    @KafkaListener(topics = "spec3-giovanni-vicente-2", groupId = "giovanni-2")
    public void receber(@Payload Cadastro cadastro) {
        System.out.println("Recebi uma requisição!");

        Cnpj cnpjObjeto = validadorService.verificarCnpj(cadastro);

        if (validadorService.validarCapital(cnpjObjeto.getCapitalSocial())) {
            cadastro.setCadastroAprovado(true);
        } else {
            cadastro.setCadastroAprovado(false);
        }

        validadorService.enviarAoKafka(cadastro);
    }

}
