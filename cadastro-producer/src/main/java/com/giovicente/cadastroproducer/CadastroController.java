package com.giovicente.cadastroproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroProducer cadastroProducer;

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void postCadastro(@RequestBody CreateCadastroRequest createCadastroRequest) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCnpj(createCadastroRequest.getCnpj());
        cadastro.setCadastroAprovado(false);

        cadastroProducer.enviarAoKafka(cadastro);
    }

}
