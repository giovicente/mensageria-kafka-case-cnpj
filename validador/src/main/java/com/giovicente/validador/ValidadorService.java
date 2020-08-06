package com.giovicente.validador;

import com.giovicente.cadastroproducer.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ValidadorService {

    @Autowired
    private CnpjClient cnpjClient;

    @Autowired
    private KafkaTemplate<String, Cadastro> producer;

    private final double CAPITAL_MINIMO_DE_CADASTRO = 1000000.00;

    public Cnpj verificarCnpj(Cadastro cadastro) {
        Cnpj cnpjObjeto = cnpjClient.getByCnpj(cadastro.getCnpj());
        return cnpjObjeto;
    }

    public boolean validarCapital(double capitalSocial) {
        if (capitalSocial > CAPITAL_MINIMO_DE_CADASTRO) {
            return true;
        }

        return false;
    }

    public void enviarAoKafka(Cadastro cadastro) { producer.send("spec3-giovanni-vicente-3", cadastro); }

}