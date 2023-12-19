import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GeografijaDAO dao=GeografijaDAO.getInstanca();

        dao.dodajDrzavu(new Drzava("Francuska"));
        dao.dodajGrad(new Grad("Pariz", 2206488, "Francuska"));
        dao.dodajDrzavu(new Drzava("Velika Britanija"));
        dao.dodajGrad(new Grad("London", 8982000, "Velika Britanija"));
        dao.dodajGrad(new Grad("Manchester", 547627, "Velika Britanija"));
        dao.dodajDrzavu(new Drzava("Austrija"));
        dao.dodajGrad(new Grad("Beč", 1897491, "Austrija"));
        dao.dodajGrad(new Grad("Graz", 280200, "Austrija"));
        dao.dodajDrzavu(new Drzava("Bosna i Hercegovina"));
        dao.dodajGrad(new Grad("Maglaj",43388,"Bosna i Hercegovina"));

        String gradoviString=ispisiGradove();
        System.out.println(gradoviString);

        glavniGrad();

        nadjiDrzavu();

        dao.obrisiDrzavu("Bosna i Hercegovina");

        System.out.println(ispisiGradove());


    }

    private static void nadjiDrzavu() {
        GeografijaDAO dao=GeografijaDAO.getInstanca();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Unesite naziv države: ");
        String drzava=scanner.nextLine();
        Drzava country=dao.nadjiDrzavu(drzava);
        if(country!=null){
            System.out.println("Drzava: "+country.getNaziv()+" je pronađena u bazi");
        }
        else{
            System.out.println("Država "+drzava+" nije definisana u bazi!");
        }
    }

    private static String ispisiGradove() {
        GeografijaDAO dao= GeografijaDAO.getInstanca();
        ArrayList<Grad> gradovi=dao.gradovi();
        StringBuilder sb=new StringBuilder();
        for(Grad grad : gradovi){
            sb.append(grad.getNaziv()).append(" (").append(grad.getDrzava()).append(") - ").append(grad.getBrojStanovnika()).append("\n");
        }
        return sb.toString();
    }

    private static void glavniGrad(){
        GeografijaDAO dao=GeografijaDAO.getInstanca();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Unesite naziv države: ");
        String drzava=scanner.nextLine();
        Grad glavniGrad=dao.glavniGrad(drzava);
        if(glavniGrad!=null){
            System.out.println("Glavni grad države "+drzava+" je "+glavniGrad.getNaziv());
        }
        else{
            System.out.println("Nepostojeća država");
        }
    }
}