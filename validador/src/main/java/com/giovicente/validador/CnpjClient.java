package com.giovicente.validador;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "cnpj", url = "https://www.receitaws.com.br/")
public interface CnpjClient {

    @GetMapping("/v1/cnpj/{cnpj}")
    Optional<Cnpj> getByCnpj(@PathVariable String cnpj);

}
