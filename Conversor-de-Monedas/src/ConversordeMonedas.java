import jdk.jshell.spi.ExecutionControl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;


public class ConversordeMonedas {

    public static double obtenerTasaCambio(String monedaBase, String monedaDestino) throws IOException, ExecutionControl.InternalException, InterruptedException {

        String json = ConexionAPI.obtenerJSON(monedaBase);

        // Analisis del JSON
        JsonObject objeto = JsonParser.parseString(json).getAsJsonObject();
        JsonObject tasas = objeto.getAsJsonObject("conversion_rates");

        if(tasas.has(monedaDestino)){
            return tasas.get(monedaDestino).getAsDouble();
        }else{
            throw new IllegalArgumentException("Moneda destino no encontrada" + monedaDestino);
        }

    }
}
