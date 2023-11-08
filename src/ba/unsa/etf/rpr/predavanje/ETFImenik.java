package ba.unsa.etf.rpr.predavanje;

import java.util.Scanner;
import java.util.Set;

public class ETFImenik {
    public static Imenik imenik = new Imenik();
    private static void dodajUImenik(String ime, TelefonskiBroj broj){
        imenik.Dodaj(ime,broj);
    }
    private static void ispisiImenik(){
        System.out.println(imenik.toString());
    }
    private static void dajBroj(){
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite ime osobe: ");
        String ime=ulaz.nextLine();
        String broj=imenik.dajBroj(ime);
        System.out.println(broj==null ? "Nema trazenog broja" : broj);
    }
    private static TelefonskiBroj unesiBroj() throws Exception {
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Koji tip telefona koristite: ");
        String tip= ulaz.nextLine();
        switch(tip){
            case "fiksni":
                System.out.println("Unesite pozivni broj: ");
                String pozivni_br = ulaz.nextLine();
                System.out.println("Unesite broj fiksnog telefona: ");
                String br = ulaz.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni_br),br);
            case "mobilni":
                System.out.println("Unesite mrezu: ");
                int mreza = ulaz.nextInt();
                ulaz.nextLine();
                System.out.println("Unesite broj mobilnog telefona: ");
                String mob_br = ulaz.nextLine();
               return new MobilniBroj(mreza, mob_br);
            case "medunarodni":
                System.out.println("Unesite drzavu: ");
                String drzava = ulaz.nextLine();
                System.out.println("Unesite medjunarodni broj telefona: ");
                String medj_br = ulaz.nextLine();
                return new MedunarodniBroj(drzava, medj_br);
        }
        return null;
    }
    public static void izGrada(){
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite zeljeni grad: ");
        String grad=ulaz.nextLine();
        try{
            Grad g=Grad.valueOf(grad);
            Set<String> rez= imenik.izGrada(g);
            System.out.println(rez);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void dajIme() throws Exception {
        Scanner ulaz=new Scanner(System.in);
        TelefonskiBroj broj=unesiBroj();
        String ime=imenik.dajIme(broj);
        System.out.println(ime==null ? "Ime za dati broj ne postoji!" : "Ime korisnika sa brojem " + broj.ispisi() +" je: " + ime);

    }
    private static void naSlovo() {
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite prvo slovo imena: ");
        String slovo=ulaz.nextLine();
        String rez=imenik.naSlovo(slovo.toCharArray()[0]);
        System.out.println(rez);
    }
    public static void main(String[] args) throws Exception {
        for (; ; ) {
            Scanner ulaz = new Scanner(System.in);
            System.out.println("Unesite ime osobe ili dalje za nastavak: ");
            String ime = ulaz.nextLine();
            if(ime.equals("dalje")){
                break;
            }
            System.out.println("Koji telefon osoba koristi?");
            String upit = ulaz.nextLine();
            switch (upit) {
                case "fiksni":
                    System.out.println("Unesite pozivni broj: ");
                    String pozivni_br = ulaz.nextLine();
                    System.out.println("Unesite broj fiksnog telefona: ");
                    String br = ulaz.nextLine();
                    dodajUImenik(ime, new FiksniBroj(Grad.izPozivnog(pozivni_br), br));
                    break;
                case "mobilni":
                    System.out.println("Unesite mrezu: ");
                    int mreza = ulaz.nextInt();
                    ulaz.nextLine();
                    System.out.println("Unesite broj mobilnog telefona: ");
                    String mob_br = ulaz.nextLine();
                    dodajUImenik(ime, new MobilniBroj(mreza, mob_br));
                    break;
                case "medunarodni":
                    System.out.println("Unesite drzavu: ");
                    String drzava = ulaz.nextLine();
                    System.out.println("Unesite medjunarodni broj telefona: ");
                    String medj_br = ulaz.nextLine();
                    dodajUImenik(ime, new MedunarodniBroj(drzava, medj_br));
                    break;
            }
        }
        for(;;){
            Scanner ulaz=new Scanner(System.in);
            System.out.println("Unesite komandu [dajIme, dajBroj, ispisiImenik, Dovidjenja, naSlovo, izGrada]: ");
            String komanda=ulaz.nextLine();
            switch(komanda){
                case "dajIme":
                    dajIme();
                    break;
                case "dajBroj":
                    dajBroj();
                    break;
                case "ispisiImenik":
                    ispisiImenik();
                    break;
                case "naSlovo":
                    naSlovo();
                    break;
                case "izGrada":
                    izGrada();
                    break;
                case "Dovidjenja":
                    System.out.println("Hvala Vam na koristenju nasih usluga!");
                    System.exit(0);
            }
        }
    }
}
