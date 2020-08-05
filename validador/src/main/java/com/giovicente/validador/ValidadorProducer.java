package com.giovicente.validador;

import com.giovicente.cadastroproducer.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ValidadorProducer {

    @Autowired
    private KafkaTemplate<String, Cadastro> producer;

    public void enviarAoKafka(Cadastro cadastro) { producer.send("spec3-giovanni-vicente-3", cadastro); }

}
