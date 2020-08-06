package com.giovicente.validador;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cnpj", url = "https://www.receitaws.com.br/")
public interface CnpjClient {

    @GetMapping("/v1/cnpj/{cnpj}")
    Cnpj getByCnpj(@PathVariable String cnpj);

}
