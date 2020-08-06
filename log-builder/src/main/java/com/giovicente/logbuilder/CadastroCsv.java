package com.giovicente.logbuilder;

public class CadastroCsv {

    private String cnpj;
    private String cadastroAprovado;

    public CadastroCsv() { }

    public CadastroCsv(String cnpj, String cadastroAprovado) {
        this.cnpj = cnpj;
        this.cadastroAprovado = cadastroAprovado;
    }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getCadastroAprovado() { return cadastroAprovado; }

    public void setCadastroAprovado(String cadastroAprovado) { this.cadastroAprovado = cadastroAprovado; }

}
