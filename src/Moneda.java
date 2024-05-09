import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Moneda {
    private Scanner divisaReferencia;
    private Scanner divisaSecundaria;
    private Scanner monto;
    private String divisaRef;
    private String divisaSec;
    private double valorMoneda;
    private String json;

    public void realizarSolicitud() {
        System.out.println("*******************************************");
        System.out.println("Bienvenidos al conversor de monedas");
        System.out.println("Escribe la moneda base");
        Scanner scanner = new Scanner(System.in);
        boolean monedaValida = false;
        while (!monedaValida){
            divisaRef = scanner.nextLine().toUpperCase();
            String direccion = "https://v6.exchangerate-api.com/v6/fe07803fe0c1fc2a45a4e545/latest/" + divisaRef;
            try {
                //Solicitud API
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200){
                    json= response.body();
                    monedaValida=true;
                }else {
                    System.err.println("Error al realizar la solicitud: " + response.statusCode());
                    System.out.println("Escribe una moneda valida");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void obtenerValorMoneda(Scanner scanner) {
        //Se crea FORMATEA JSON CON GSON
        Gson gson = new Gson();
        ExchangeRatesResponse exchangeRatesResponse = gson.fromJson(json, ExchangeRatesResponse.class);
        boolean monedaSecundariaValida = false;
        //Metodo para obtener el valor en otra moneda
        System.out.println("Escribe la divisa de referencia");
        while (!monedaSecundariaValida){
            divisaSec = scanner.nextLine().toUpperCase();
            Double conversionRate =exchangeRatesResponse.getConversion_rates().get(divisaSec);
            if (conversionRate != null){
                valorMoneda = conversionRate;
                System.out.println(valorMoneda);
                System.out.println("El valor de 1 " + divisaRef + " en " + divisaSec + " es: " + valorMoneda);
                monedaSecundariaValida = true;
            }else {
                System.err.println("La divisa de referencia no está disponible en la respuesta JSON.");
                System.out.println("Escribe una moneda valida");
            }
        }
    }
    public void multiplicarMonto(Scanner scanner){
        boolean numeroValido = false;
        System.out.println("Escribe el monto para convertir");
        while (!numeroValido){
            if (scanner.hasNextDouble()){
                double valor2 = scanner.nextDouble();
                scanner.nextLine();
                double resultado = valor2 * valorMoneda;
                System.out.println("El valor de " + valor2 + " " +divisaRef + " multiplicado en " + divisaSec + " con valor "+ valorMoneda + " da " + resultado);
                numeroValido = true;
            }else{
                System.err.println("El valor ingresado no es un número válido.");
                System.out.println("Ingresa un valor de nuevo");
                scanner.nextLine();
            }
        }
    }
}
