package ba.unsa.etf.rpr.predavanje;

import java.util.Objects;
public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;
    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    /**
     * ispis u obliku drzava / broj (npr. Bosna i Hercegovina / 061 445 300
     * @return
     */
    @Override
    public String ispisi() {
        if(drzava==null || broj==null) return null;
        else
        return drzava + " / " +broj;
    }
    @Override
    public int hashCode() {
        return Objects.hash(drzava,broj);
    }

}
