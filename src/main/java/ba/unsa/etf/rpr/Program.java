package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Program
{
    public static void main( String[] args )
    {
        LaptopDaoSerializableFile laptopDaoSerializableFile=new LaptopDaoSerializableFile();
        LaptopDaoJSONFile laptopDaoJSONFile=new LaptopDaoJSONFile();
        LaptopDaoXMLFile laptopDaoXMLFile=new LaptopDaoXMLFile();
        testiraj(laptopDaoSerializableFile);
        testiraj(laptopDaoJSONFile);
        testiraj(laptopDaoXMLFile);
    }

    private static void testiraj(LaptopDao laptopDao){
        Laptop laptop1=new Laptop("Dell","Inspiron",1200.0,8,512,256,"Intel i5","Nvidia GTX 1050",15.6);
        Laptop laptop2=new Laptop("HP","Pavilion",900.0,12,256,256,"AMD Ryzen 7","AMD Radeon 10",14.0);

        laptopDao.dodajLaptopUListu(laptop1);
        laptopDao.dodajLaptopUListu(laptop2);

        laptopDao.dodajLaptopUFile(laptop1);
        laptopDao.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> ucitani=laptopDao.vratiPodatkeIzDatoteke();
        for(Laptop laptop : ucitani) {
            System.out.println(laptop.toString());
        }
    }
}
