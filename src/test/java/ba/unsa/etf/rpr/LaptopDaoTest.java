package ba.unsa.etf.rpr;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LaptopDaoTest {
    private LaptopDao laptopDao;

    @BeforeEach
    void Inicijaliziraj(){
        laptopDao=new LaptopDaoSerializableFile();
    }

    @Test
    public void dodajLaptopUFile() {
        Laptop laptop=new Laptop("Lenovo","IdeaPad",1500.0,8,500,256,"i5","AMD Radeon",15.6);
        laptopDao.dodajLaptopUFile(laptop);
        LaptopDao novi=new LaptopDaoSerializableFile();
        assertTrue(novi.vratiPodatkeIzDatoteke().contains(laptop));
    }

    @Test
    public void getLaptop() throws Exception {
        laptopDao.dodajLaptopUFile(new Laptop("Lenovo","ThinkPad",1500.0,8,500,256,"i5","AMD Radeon",15.6));
        Laptop test= laptopDao.getLaptop("i5");
        assertNotNull(test);
        assertEquals("i5",test.getProcesor());
    }

    @Test
    public void napuniListu() {
        ArrayList<Laptop> test = new ArrayList<>();
        test.add(new Laptop("HP", "MyPad", 1500.0, 8, 500, 256, "i3", "AMD", 15.6));
        test.add(new Laptop("Acer", "Deluxe", 1200.0, 8, 200, 512, "i7", "AMD Radeon", 13.3));
        laptopDao.napuniListu(test);
        LaptopDao novi = new LaptopDaoSerializableFile();
        assertNotEquals(novi, test);
    }
}