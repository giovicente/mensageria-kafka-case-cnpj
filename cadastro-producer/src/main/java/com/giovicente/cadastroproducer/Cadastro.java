package com.giovicente.cadastroproducer;

public class Cadastro {

    private String cnpj;
    private boolean cadastroAprovado;

    public Cadastro() { }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public boolean isCadastroAprovado() { return cadastroAprovado; }

    public void setCadastroAprovado(boolean cadastroAprovado) { this.cadastroAprovado = cadastroAprovado; }

}
