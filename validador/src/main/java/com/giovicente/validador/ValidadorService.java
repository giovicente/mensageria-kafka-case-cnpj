package com.giovicente.validador;

import com.giovicente.cadastroproducer.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ValidadorService {

    @Autowired
    private CnpjClient cnpjClient;

    @Autowired
    private KafkaTemplate<String, Cadastro> producer;

    private final double CAPITAL_MINIMO_DE_CADASTRO = 1000000.00;

    public Cnpj verificarCnpj(Cadastro cadastro) {
        Optional<Cnpj> cnpjOptional = cnpjClient.getByCnpj(cadastro.getCnpj());

        if (cnpjOptional.isPresent()) {
            return cnpjOptional.get();
        }

        throw new RuntimeException("Empresa não encontrada.");
    }

    public boolean validarCapital(BigDecimal capital_social) {
        if (capital_social.doubleValue() > CAPITAL_MINIMO_DE_CADASTRO) {
            return true;
        }

        return false;
    }

    public void enviarAoKafka(Cadastro cadastro) { producer.send("spec3-giovanni-vicente-3", cadastro); }

}
