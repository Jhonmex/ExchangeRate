import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Moneda {
    protected String currency;
    private double monto;
    private double resultado;
    private String direccion = "https://v6.exchangerate-api.com/v6/fe07803fe0c1fc2a45a4e545/latest/USD";

    public void realizarSolicitud() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    public void cantidadAConvertir(){

    }

}
