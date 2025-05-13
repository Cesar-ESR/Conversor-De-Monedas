import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//      Selector de menus e inicio de monedas
        Scanner intro = new Scanner(System.in);
        List<String> historial = new ArrayList<>();

        System.out.println("********************************************");
        System.out.println("Sea Bienvenido/a al Conversor de Moneda.");
        System.out.println("Desea realizar alguna conversion?");
        String respuesta = intro.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            int seleccionMoneda = 0;
            String cambio = "";
            String destino = "";

            while (seleccionMoneda != 9) {
                System.out.println("\nMonedas Disponibles:");
                System.out.println("1) Dólar ==> Peso Argentino");
                System.out.println("2) Peso Argentino ==> Dólar");
                System.out.println("3) Dólar ==> Real Brasileño");
                System.out.println("4) Real Brasileño ==> Dólar");
                System.out.println("5) Dólar ==> Peso Colombiano");
                System.out.println("6) Peso Colombiano ==> Dólar");
                System.out.println("7) Elige moneda personalizada");
                System.out.println("8) Historial de Conversiones");
                System.out.println("9) Salir");
                System.out.print("Elija la conversión deseada (1-9): ");

                seleccionMoneda = intro.nextInt();

                switch (seleccionMoneda) {
                    case 1 -> {
                        System.out.println("Usted seleccionó convertir USD a Peso Argentino.");
                        cambio = "USD"; destino = "ARS"; }
                    case 2 -> {
                        System.out.println("Usted seleccionó convertir Peso Argentino a USD.");
                        cambio = "ARS"; destino = "USD"; }
                    case 3 -> {
                        System.out.println("Usted seleccionó convertir USD a Real Brasileño.");
                        cambio = "USD"; destino = "BRL"; }
                    case 4 -> {
                        System.out.println("Usted seleccionó convertir Real Brasileño a USD.");
                        cambio = "BRL"; destino = "USD"; }
                    case 5 -> {
                        System.out.println("Usted seleccionó convertir USD a Peso Colombiano.");
                        cambio = "USD"; destino = "COP"; }
                    case 6 -> {
                        System.out.println("Usted seleccionó convertir Peso Colombiano a USD.");
                        cambio = "COP"; destino = "USD"; }
                    case 7 -> {
                        System.out.println("Ingrese su tipo de cambio (ej. USD):");
                        cambio = intro.next();
                        System.out.println("Ingrese la moneda destino (ej. MXN):");
                        destino = intro.next();
                    }
                    case 8 -> {
                        if(historial.isEmpty()){
                            System.out.println("No se encuentran conversiones en el historial");
                        }else{
                            System.out.println("Historial de Conversiones pasadas");
                            for (String registro : historial){
                                System.out.println("- " + registro);
                            }
                        continue;
                        }
                    }
                    case 9 -> {
                        System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                        return;
                    }
                    default -> {
                        System.out.println("Opción no válida. Intente nuevamente.");
                        continue; // vuelve al inicio sin hacer conversión
                    }
                }

                // Si eligió salir, no hace nada más
                if (seleccionMoneda == 9) break;

                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = intro.nextDouble();

                try {
                    double tasa = ConversordeMonedas.obtenerTasaCambio(cambio, destino);
                    double resultado = cantidad * tasa;

                    System.out.printf("Tasa actual: 1 %s = %.4f %s\n", cambio, tasa, destino);
                    System.out.printf("Resultado: %.2f %s = %.2f %s\n\n", cantidad, cambio, resultado, destino);


                    // Agrega al Historial
                    String entradaHistorial = String.format("%.2f %s = %.2f %s (Tasa: %.4f)", cantidad, cambio, resultado, destino, tasa);
                    historial.add(entradaHistorial);

                } catch (Exception e) {
                    System.out.println("Error en la conversión: " + e.getMessage());
                }

                System.out.println("Deseas continuar con otra conversion? SI/NO");
                String continuar = intro.next();

                if(continuar.equalsIgnoreCase("no")){
                    System.out.println("Gracias por usar el conversor de monedas. Hasta pronto");
                    break;
                }
            }
        } else if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("Hasta luego");
        } else {
            System.out.println("Por favor, solo coloque 'si' o 'no'.");
        }

        intro.close();
    }

    public static void saveHistorial(List<String> historial) {
        Gson gson = new Gson();
        Historial historialObj = new Historial(historial);
        try (FileWriter writer = new FileWriter("historial.json")) {
            gson.toJson(historialObj, writer);
            System.out.println("Historial guardado exitosamente en 'historial.json'.");
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}



