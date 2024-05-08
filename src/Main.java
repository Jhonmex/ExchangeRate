import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Moneda moneda = new Moneda();
        System.out.println("*******************************************");
        System.out.println("Bienvenidos al conversor de monedas");
        System.out.println("Escribe la moneda base");
        moneda.divisaReferencia = sc.nextLine();
        moneda.realizarSolicitud();
        moneda.divisaSecundaria = sc.nextLine();
        moneda.obtenerValorMoneda();


    }
}