package ba.unsa.etf.rpr;

import java.util.Scanner;
public class Ispis {
    public static void main(String[] args) {
        int a,b;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite dva broja: ");
        a = ulaz.nextInt();
        b = ulaz.nextInt();
        System.out.println("Unijeli ste brojeve: "+a+" i "+b);
    }
}
