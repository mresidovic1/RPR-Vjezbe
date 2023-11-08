package ba.unsa.etf.rpr.predavanje;

/**
 * veoma vazan enum za generisanje imena grada na osnovu pozivnog broja
 * takodjer, vazno radi provjere da li je validan fiksni pozivni broj
 */

public enum  Grad {
    Bugojno("030"),
    Orasje("031"),
    Maglaj("032"),
    Sarajevo("033"),
    Livno("034"),
    Tuzla("035"),
    Mostar("036"),
    Bihac("037"),
    Gorazde("038"),
    Ljubuski("039"),
    Banjaluka("051"),
    Trebinje("059");

    private String pozivniBroj;

    Grad(String pozivni_br){
        pozivniBroj=pozivni_br;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }

    public void setPozivniBroj(String pozivniBroj) {
        this.pozivniBroj = pozivniBroj;
    }

    /**
     * vazna metoda zbog konstruktora FiksniBroj pri dodavanju u imenik u glavnom programu
     * vraca grad na osnovu pozivnog broja
     * @param pozivni
     * @return
     */
    public static Grad izPozivnog(String pozivni){
        for(Grad g : Grad.values()){
            if(g.getPozivniBroj().equals(pozivni)){
                return g;
            }
        }
        return null;
    }
}
