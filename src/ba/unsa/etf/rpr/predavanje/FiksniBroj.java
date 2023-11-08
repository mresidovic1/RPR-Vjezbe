package ba.unsa.etf.rpr.predavanje;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) throws Exception {
        if(grad==null){
            throw new Exception("Nema pozivnog broja!");
        }
        this.grad=grad;
        this.broj=broj;
    }

    /**
     * ispis u obliku 032/ 618 800
     * poziva se geter iz enuma Grad
     * @return
     */
    @Override
    public String ispisi() {
        if(grad==null || broj==null) return null;
        else
        return grad.getPozivniBroj() + "/" + broj;
    }
    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
