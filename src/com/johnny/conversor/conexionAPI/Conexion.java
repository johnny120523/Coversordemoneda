package com.johnny.conversor.conexionAPI;

import com.google.gson.Gson;
import com.johnny.conversor.Modulos.MonedaApi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {

    String json;
    String jsonHistorial;

    public String getJson() {
        return json;
    }

    public MonedaApi HacerConversion(String conversionDeMoneda){


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/34f4a3a99e9bc8da2e870f93/pair/"+conversionDeMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();

            return new Gson().fromJson(json, MonedaApi.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda.");
        }


    }


}
