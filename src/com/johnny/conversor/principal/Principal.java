package com.johnny.conversor.principal;

import com.johnny.conversor.Modulos.Conversiones;

import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        var Conversiones = new Conversiones();

        int Opcion = 0;

        while (Opcion != 8) {


            System.out.println("------------------------------------------");
            System.out.println("           CAMBIO DE MONEDAS              ");
            System.out.println("------------------------------------------");
            System.out.println(" 1. Dólar => Peso colombiano ");
            System.out.println(" 2. Peso colombiano => Dólar");
            System.out.println(" 3. Dólar => Real brasileño");
            System.out.println(" 4. Real brasileño => Dólar");
            System.out.println(" 5. Dólar => Peso argentino");
            System.out.println(" 6. Peso argentino => Dólar");
            System.out.println(" 7. Cambio personalizado ");
            System.out.println("------------------------------------------");
            System.out.println(" 8. Salir");
            System.out.println("------------------------------------------");

            Opcion = lectura.nextInt();
            lectura.nextLine(); // Consumir el salto de línea pendiente

            switch (Opcion) {

                case 1:

                    Conversiones. ConversionDeMoneda("USD", "COP");


                    break;

                case 2:

                    Conversiones.ConversionDeMoneda("COP", "USD");

                    break;

                case 3:

                    Conversiones.ConversionDeMoneda("USD", "BRL");

                    break;

                case 4:

                    Conversiones.ConversionDeMoneda("BRL", "USD");

                    break;

                case 5:

                    Conversiones.ConversionDeMoneda("USD", "ARS");

                    break;

                case 6:

                    Conversiones.ConversionDeMoneda("ARS", "USD");

                    break;

                case 7:

                    Conversiones.ConversionUniversal("" , "");

                    break;

                case 8:

                    break;


                default:

                    System.out.println("------------------------------------------");
                    System.out.println(" Opción no valida, Elige otra opción ");
                    System.out.println("------------------------------------------");

            }

        }



    }

}

