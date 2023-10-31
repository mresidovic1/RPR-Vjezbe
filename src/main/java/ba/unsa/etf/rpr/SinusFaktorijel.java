package ba.unsa.etf.rpr;

public class SinusFaktorijel {
    public SinusFaktorijel() {
    }

    public static double Sinus(double broj) {
        return Math.sin(broj);
    }

    public static long Faktorijel(int broj) {
        long faktorijel = 1L;

        for(int i = 2; i <= broj; ++i) {
            faktorijel *= (long)i;
        }

        return faktorijel;
    }

    public static void main(String[] args) {
        for(int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
            System.out.println("Faktorijel broja 25 je: " + Faktorijel(Integer.valueOf(args[i])));
            System.out.println("Sinus od 1 je: " + Sinus(Double.valueOf(args[i])));
        }

    }
}
