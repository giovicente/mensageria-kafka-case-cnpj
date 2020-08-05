package com.giovicente.cadastroproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CadastroProducer {

    @Autowired
    private KafkaTemplate<String, Cadastro> producer;

    public void enviarAoKafka(Cadastro cadastro) { producer.send("spec3-giovanni-vicente-2", cadastro); }

}
