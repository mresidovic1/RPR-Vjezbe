package ba.unsa.etf.rpr.predavanje;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void ubaci() throws Exception {
        imenik.Dodaj("Mahir", new FiksniBroj(Grad.Maglaj,"603 640"));
        imenik.Dodaj("Nina", new MobilniBroj(61,"230 244"));
        imenik.Dodaj("Ajdin",new MedunarodniBroj("Kairo","225 552"));
    }

    @Test
    public void dajBrojNadjen(){
        assertEquals(imenik.dajBroj("Mahir"),"032/603 640");
        assertNull(imenik.dajBroj("Igor"));
    }

    @Test
    public void dajImeTest() throws Exception {
        Imenik imenik = new Imenik();
        FiksniBroj fiksniBroj = new FiksniBroj(Grad.Bihac,"123321");
        imenik.Dodaj("Abdullah", fiksniBroj);

        assertEquals("Abdullah", imenik.dajIme(fiksniBroj));
        assertNull(imenik.dajIme(new FiksniBroj(Grad.Bihac, "121212")));
    }

    @Test
    public void DajBrojNijeNadjen(){
        String broj=imenik.dajBroj("Muris");
        assertNull(broj);
    }

    @Test
    public void DodajBrojTest(){
        TelefonskiBroj br=new MobilniBroj(61,"778 900");
        imenik.Dodaj("Zinedin", br);
        String broj=imenik.dajBroj("Zinedin");
        assertEquals(broj,"061/778 900");
    }

    @Test
    void toStringTest() throws Exception {
        Imenik imenik = new Imenik();
        imenik.Dodaj("Lamija", new FiksniBroj(Grad.Sarajevo, "123456"));
        imenik.Dodaj("Vesna", new MobilniBroj(61, "654321"));

        String ocekivaniIspis = "1. Lamija - 033/123456\n2. Vesna - 061/654321\n";
        assertEquals(ocekivaniIspis, imenik.toString());
    }
}