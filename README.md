# Conversor de Monedas

Este es un programa Java simple que te permite convertir montos de una moneda a otra utilizando los tipos de cambio actuales obtenidos de la API de ExchangeRate-API.

## Requisitos

- Java 8 o superior.
- Conexión a Internet para obtener los tipos de cambio de la API en línea.

## Uso

1. Clona este repositorio en tu máquina local.
2. Abre una terminal y navega hasta el directorio del proyecto.
3. Compila el programa ejecutando el siguiente comando:

    ```bash
    javac Main.java
    ```

4. Ejecuta el programa con el siguiente comando:

    ```bash
    java Main
    ```

5. Sigue las instrucciones en pantalla para realizar conversiones de moneda.

## Cómo funciona

El programa solicita al usuario la moneda base y la moneda de destino. Luego, obtiene los tipos de cambio actuales de la API de ExchangeRate-API y muestra al usuario el valor de 1 unidad de la moneda base en la moneda de destino. A continuación, solicita al usuario el monto que desea convertir y muestra el resultado de la conversión.

## Créditos

- Este programa utiliza la API de ExchangeRate-API para obtener los tipos de cambio en tiempo real. Puedes encontrar más información en [ExchangeRate-API](https://www.exchangerate-api.com/).

## Contribuir

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
