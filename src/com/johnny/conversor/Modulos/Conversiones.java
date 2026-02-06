package com.johnny.conversor.Modulos;

import com.johnny.conversor.conexionAPI.Conexion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversiones {
    double cantidad;
    Scanner lectura = new Scanner(System.in);
    Conexion conexion = new Conexion();
    private List<String> historial = new ArrayList<>();


    public void IngresarCantidad() {

        System.out.println("------------------------------------------");
        System.out.println("       Ingrese la cantidad      ");
        System.out.println("------------------------------------------");

        cantidad = lectura.nextDouble();
        lectura.nextLine(); // Consumir el salto de línea pendiente

    }

    public void ConversionDeMoneda (String monedainicial, String monedasalida ) {

        IngresarCantidad();

        MonedaApi miMonedaApi = conexion.HacerConversion( monedainicial + "/" + monedasalida + "/" + cantidad);
        Moneda miMoneda = new Moneda(miMonedaApi);

        String monedaAcambiar = "";
        String monedaCambiada = "";

        if (monedainicial.equalsIgnoreCase("USD")) {
            monedaAcambiar = "dólares";
        } else if (monedainicial.equalsIgnoreCase("ARS")) {
            monedaAcambiar = "pesos argentinos";
        } else if (monedainicial.equalsIgnoreCase("BRL")) {
            monedaAcambiar = "reales";
        } else if (monedainicial.equalsIgnoreCase("COP")) {
            monedaAcambiar = "pesos colombianos";
        }


        if (monedasalida.equalsIgnoreCase("USD")) {
            monedaCambiada = "dólares";
        } else if (monedasalida.equalsIgnoreCase("COP")) {
            monedaCambiada = "pesos colombianos";
        } else if (monedasalida.equalsIgnoreCase("ARS")) {
            monedaCambiada = "pesos argentinos";
        } else if (monedasalida.equalsIgnoreCase("BRL")) {
            monedaCambiada = "reales";
        }

        System.out.println("------------------------------------------\n");
        System.out.println("El valor de: "+ cantidad + " " + monedaAcambiar + " ("+ monedainicial +") " + "son: " + miMoneda.getValor() + " " + monedaCambiada + " (" + miMoneda.getNombre() + ")");
        System.out.println("Usando una tasa de conversion de: "+ miMoneda.getTasaDeconversion() +"\n");

        String registro = cantidad + " " + monedaAcambiar + " (" + monedainicial + ") => " + miMoneda.getValor() + " " + monedaCambiada + " (" + miMoneda.getNombre() + ") Tasa: " + miMoneda.getTasaDeconversion();
        historial.add(registro);

    }

    public void ConversionUniversal (String monedainicial, String monedasalida ) {


        System.out.println("------------------------------------------");
        System.out.println(" Ingrese el Nombre de la moneda inicial y la moneda a  ");
        System.out.println("  cambiar en formato de divisas (ej. COP,USD,EUR) ");
        System.out.println("------------------------------------------");

        monedainicial = lectura.nextLine().toUpperCase();

        System.out.println("------------------------------------------");

        monedasalida = lectura.nextLine().toUpperCase();

        IngresarCantidad();

        MonedaApi miMonedaApi = conexion.HacerConversion( monedainicial + "/" + monedasalida + "/" + cantidad);
        Moneda miMoneda = new Moneda(miMonedaApi);

        String monedaAcambiar = "";
        String monedaCambiada = "";

        // Lógica para la moneda de ORIGEN (MonedaINI)
        if (monedainicial.equalsIgnoreCase("USD")) {
            monedaAcambiar = "dólares";
        } else if (monedainicial.equalsIgnoreCase("ARS")) {
            monedaAcambiar = "pesos argentinos";
        } else if (monedainicial.equalsIgnoreCase("BRL")) {
            monedaAcambiar = "reales";
        } else if (monedainicial.equalsIgnoreCase("COP")) {
            monedaAcambiar = "pesos colombianos";
        }

        // Lógica para la moneda de DESTINO (MonedaFIN)
        if (monedasalida.equalsIgnoreCase("USD")) {
            monedaCambiada = "dólares";
        } else if (monedasalida.equalsIgnoreCase("COP")) {
            monedaCambiada = "pesos colombianos";
        } else if (monedasalida.equalsIgnoreCase("ARS")) {
            monedaCambiada = "pesos argentinos";
        } else if (monedasalida.equalsIgnoreCase("BRL")) {
            monedaCambiada = "reales";
        }

        System.out.println("------------------------------------------");
        System.out.println("El valor de: "+ cantidad + " " + monedaAcambiar + " ("+ monedainicial +") " + "son: " + miMoneda.getValor() + " " + monedaCambiada + " (" + miMoneda.getNombre() + ")");
        System.out.println("Usando una tasa de conversion de: "+ miMoneda.getTasaDeconversion() +"\n");

        String registro = cantidad + " " + monedaAcambiar + " (" + monedainicial + ") => " + miMoneda.getValor() + " " + monedaCambiada + " (" + miMoneda.getNombre() + ") Tasa: " + miMoneda.getTasaDeconversion();
        historial.add(registro);

    }



}
