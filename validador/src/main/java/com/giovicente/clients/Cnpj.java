package com.giovicente.clients;

public class Cnpj {

    private double capitalSocial;

    public Cnpj() { }

    public double getCapitalSocial() { return capitalSocial; }

    public void setCapitalSocial(double capitalSocial) { this.capitalSocial = capitalSocial; }

    public boolean validarCapital(double capitalSocial) {
        if (capitalSocial > 1000000.00) {
            return true;
        }

        return false;
    }

}
