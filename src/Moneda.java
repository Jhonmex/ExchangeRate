import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Moneda {
    protected String divisaReferencia;
    protected String divisaSecundaria;
    private double valorMoneda;
    private String json;
    private Scanner sc;
    private double monto;
    private double resultado;
    private String currencyCode;
    private double rate;

    public void realizarSolicitud() {
        String direccion = "https://v6.exchangerate-api.com/v6/fe07803fe0c1fc2a45a4e545/latest/" + divisaReferencia.toUpperCase();
        try {
            //Solicitud API
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    public void obtenerValorMoneda(){
        //Se crea FORMATEA JSON CON GSON
        Gson gson = new Gson();
        ExchangeRatesResponse exchangeRatesResponse = gson.fromJson(json, ExchangeRatesResponse.class);
        //Metodo para obtener el valor en otra moneda
        System.out.println("Escribe la divisa de referencia");
        //Checar como asignar valor a divisaSecundaria
        valorMoneda= exchangeRatesResponse.getConversion_rates().get(divisaSecundaria.toUpperCase());
        System.out.println(valorMoneda);
        System.out.println("El valor de 1 " + divisaReferencia + " en " + divisaSecundaria.toUpperCase() + " es: " + valorMoneda);
    }

}
