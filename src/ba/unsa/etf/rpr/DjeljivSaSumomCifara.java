package ba.unsa.etf.rpr;

import java.util.Scanner;

public class DjeljivSaSumomCifara {
    public static void main(String[] args) {
        int n;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj n: ");
        n = ulaz.nextInt();
        System.out.println("Brojevi djeljivi sa sumom svojih cifara su: ");
        for(int i=1 ; i<=n ; i++) {
            if (DjeljivJe(i)) {
                System.out.println(i + " ");
            }
        }
    }

    /**
     * Metoda sumaCifara sluzi za izracunavanje zbira cifara unutar broja zadanog parametrom
     * @param n
     * @return
     */
    public static int sumaCifara(int n){
        int suma = 0;
        while(n!=0){
            suma+=n%10;
            n/=10;
        }
        return suma;
    }

    /**
     * Metoda DjeljivJe sluzi za provjeru da li je broj djeljiv sa sumom svojih cifara
     * Ova metoda poziva metodu sumaCifara
     * @param n
     * @return
     */
    public static boolean DjeljivJe(int n){
        int suma_cifara=sumaCifara(n);
        return n%suma_cifara==0;
    }
}
