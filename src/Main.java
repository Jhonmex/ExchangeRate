import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Moneda moneda = new Moneda();
        moneda.realizarSolicitud();
        moneda.obtenerValorMoneda();
        moneda.multiplicarMonto();
        moneda.nuevoIntenteto();
        sc.close();
    }
}