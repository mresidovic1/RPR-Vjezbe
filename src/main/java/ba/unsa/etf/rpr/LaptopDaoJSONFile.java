package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(){
        this.file=new File("laptopi.json");
        this.laptopi=new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,laptop);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws Exception {
        for(Laptop laptop : laptopi){
            if(laptop.getProcesor().equals(procesor)) return laptop;
        }
        throw new Exception("Nema laptopa sa zadanim procesorom!");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi=laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            ArrayList<Laptop> lapTopi = objectMapper.readValue(new File("laptopi.json"),new TypeReference<ArrayList<Laptop>>(){});
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
