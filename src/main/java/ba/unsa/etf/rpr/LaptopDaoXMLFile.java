package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(){
        this.file=new File("laptopi.xml");
        this.laptopi=new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        XmlMapper xmlMapper=new XmlMapper();
        try{
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file,laptop);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws Exception {
        for(Laptop laptop : laptopi){
            if(laptop.getProcesor().equals(procesor)){
                return laptop;
            }
        }
        throw new Exception("Ne postoji laptop sa zadanim procesorom!");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi=laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        try{
            ObjectMapper xmlMapper=new XmlMapper();
            InputStream inputStream=new FileInputStream(new File("laptopi.xml"));
            TypeReference<ArrayList<Laptop>> typeReference=new TypeReference<ArrayList<Laptop>>() {};
            ArrayList<Laptop> lapTopi= xmlMapper.readValue(inputStream,typeReference);
            for(Laptop l : lapTopi){
                System.out.println(l.toString());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
