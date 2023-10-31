package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Scanner;

public class Stop {
    public static void main(String[] args) {
        ArrayList<Double> lista=new ArrayList<>();
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite brojeve u listu ('stop' za kraj unosa): ");
        for(;;){
            String unos=ulaz.next();
            if(unos.equalsIgnoreCase("stop")) break;
            else {
                double broj=Double.parseDouble(unos);
                lista.add(broj);
                continue;
            }
        }
        System.out.println("Najmanji broj u zadanoj listi je: " + min(lista));
        System.out.println("Najveci broj u zadanoj listi je: " + max(lista));
        System.out.println("Srednja vrijednost elemenata liste je: " + mean(lista));
        System.out.println("Standardna devijacija vrijednosti je: " + standardna_devijacija(lista));
    }
    public static double min(ArrayList<Double> lista){
        double najmanji=lista.get(0);
        for(double x : lista){
            if(x<najmanji) najmanji=x;
        }
        return najmanji;
    }
    public static double max(ArrayList<Double> lista){
        double najveci=lista.get(0);
        for(double x : lista){
            if(x>najveci) najveci=x;
        }
        return najveci;
    }
    public static double mean(ArrayList<Double> lista){
        int brojac=0; double suma=0;
        for(double x : lista) {
            suma += x;
            brojac++;
        }
        return suma/brojac;
    }
    public static double standardna_devijacija(ArrayList<Double> lista){
        double srednja_vr=mean(lista);
        double razlika_kvadrati=0;
        for(double x : lista){
            razlika_kvadrati+=Math.pow(x-srednja_vr,2);
        }
        double varijansa=razlika_kvadrati/lista.size();
        return Math.sqrt(varijansa);
    }
}
