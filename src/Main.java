//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************************");
        System.out.println("Bienvenidos al conversor de monedas");

        System.out.println("1- Dolar => Peso Argentino");
        System.out.println("2- Peso Argentino => Dolar");
        System.out.println("3- Dolar => Real Brasileño");
        System.out.println("4- Real Brasileño => Dolar");
        System.out.println("5- Dolar => Peso Colombiano");
        System.out.println("6- Peso Colombiano => Dolar");
        System.out.println("7- Salir");
        System.out.println("Elija una opcion valida");
        Moneda moneda = new Moneda();
        moneda.realizarSolicitud();


    }
}