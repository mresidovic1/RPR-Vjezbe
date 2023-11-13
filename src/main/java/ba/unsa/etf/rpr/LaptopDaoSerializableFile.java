package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao, Serializable {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() {
        this.file = new File("laptopi.txt");
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(laptop.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws Exception {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new Exception("Nema laptopa sa zadanim procesorom.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> lista = new ArrayList<>();
        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line+"\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
