import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAPI  {

    public static String obtenerJSON (String base) throws IOException, InterruptedException{
        String url = "https://v6.exchangerate-api.com/v6/8780950644006ffa53ab8f41/latest/" + base;

        // Prepara cliente y solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Envía solicitud y devuelve el cuerpo como String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}


