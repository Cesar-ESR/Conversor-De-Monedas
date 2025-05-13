# Conversor-De-Monedas

## Descripción

Este proyecto es un **conversor de monedas** que permite a los usuarios convertir una moneda a otra usando tasas de cambio actuales obtenidas de una API externa. El programa proporciona una interfaz en consola, donde el usuario puede elegir la conversión que desea realizar, ingresar la cantidad de dinero a convertir y ver el resultado con la tasa de cambio actualizada.

Además, se implementa la capacidad de rastrear un historial de conversiones y guardarlo en un archivo JSON, proporcionando al usuario la opción de revisar conversiones anteriores.

## Características

- Conversión entre varias monedas (Dólar, Peso Argentino, Real Brasileño, Peso Colombiano, etc.).
- Opción para convertir monedas personalizadas ingresando los códigos de moneda.
- Historial de conversiones guardado en un archivo `historial.json`.
- Interfaz sencilla en consola.
- Consultas de tasas de cambio actuales a través de una API externa.

## Tecnologías

- **Java 11+**.
- **Gson 2.11.0** para trabajar con JSON.
- **API externa de tasas de cambio** (https://v6.exchangerate-api.com).

## Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/Cesar-ESR/Conversor-De-Monedas.git
   cd conversor-monedas

2. **Ejemplo de flujo de usuario**:

********************************************
Sea Bienvenido/a al Conversor de Moneda.
Desea realizar alguna conversion?
si


Monedas Disponibles:
1) Dólar ==> Peso Argentino
2) Peso Argentino ==> Dólar
3) Dólar ==> Real Brasileño
4) Real Brasileño ==> Dólar
5) Dólar ==> Peso Colombiano
6) Peso Colombiano ==> Dólar
7) Elige moneda personalizada
8) Historial de Conversiones
9) Salir
Elija la conversión deseada (1-9): 1
Usted seleccionó convertir USD a Peso Argentino.
Ingrese la cantidad a convertir: 10
Tasa actual: 1 USD = 1126.0000 ARS
Resultado: 10.00 USD = 11260.00 ARS

Deseas continuar con otra conversion? SI/NO
no
Gracias por usar el conversor de monedas. Hasta pronto.

3. **Funcionalidades Avanzadas.**:
   * Conversión personalizada: El usuario puede ingresar los códigos de moneda para realizar conversiones personalizadas.
   * Historial de conversiones: Se guarda un historial de todas las conversiones realizadas durante la sesión, y este se guarda en un archivo historial.json.
   * Consultar historial: Al seleccionar la opción de historial, el usuario puede ver todas las conversiones realizadas durante la sesión.
