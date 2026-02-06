package com.johnny.conversor.Modulos;

public class Moneda {

    private String nombre;
    private double valor;
    private double tasaDeconversion;


    public Moneda (MonedaApi monedaapi) {

        this.nombre = monedaapi.target_code();
        this.valor = Double.parseDouble(monedaapi.conversion_result());
        this.tasaDeconversion = Double.parseDouble(monedaapi.conversion_rate());

    }

    public String getNombre() {
        return nombre;
    }


    public double getValor() {
        return valor;
    }


    public double getTasaDeconversion() {
        return tasaDeconversion;
    }


}
