import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {
    private static GeografijaDAO instanca;
    private Connection connection;

    private GeografijaDAO(){
        try{
            connection= DriverManager.getConnection("jdbc:sqlite:baza.db");
            kreirajTabelu();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static GeografijaDAO getInstanca() {
        if (instanca == null) {
            instanca = new GeografijaDAO();
        }
        return instanca;
    }

    private void kreirajTabelu() {
        try(Statement statement=connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS drzava (naziv TEXT PRIMARY KEY)");
            statement.execute("CREATE TABLE IF NOT EXISTS grad (naziv TEXT PRIMARY KEY, broj_stanovnika INT, drzava TEXT)");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Grad> gradovi(){
        ArrayList<Grad> gradovi=new ArrayList<>();
        try(Statement statement=connection.createStatement()){
            ResultSet resultSet= statement.executeQuery("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            while(resultSet.next()){
                String naziv=resultSet.getString("naziv");
                int brojStanovnika=resultSet.getInt("broj_stanovnika");
                String drzava=resultSet.getString("drzava");
                gradovi.add(new Grad(naziv,brojStanovnika,drzava));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return gradovi;
    }

    public Grad glavniGrad(String drzava){
        try(PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM grad WHERE drzava=?")){
            preparedStatement.setString(1,drzava);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                String naziv=resultSet.getString("naziv");
                int brojStanovnika=resultSet.getInt("broj_stanovnika");
                return new Grad(naziv,brojStanovnika,drzava);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void obrisiDrzavu(String drzava){
        try(PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM drzava WHERE naziv=?")){
            preparedStatement.setString(1,drzava);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void dodajGrad(Grad grad){
        try(PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO grad VALUES(?,?,?)")){
            preparedStatement.setString(1,grad.getNaziv());
            preparedStatement.setInt(2,grad.getBrojStanovnika());
            preparedStatement.setString(3,grad.getDrzava());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void dodajDrzavu(Drzava drzava){
        try(PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO drzava VALUES (?)")){
            preparedStatement.setString(1, drzava.getNaziv());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void izmijeniGrad(Grad grad){
        try(PreparedStatement preparedStatement=connection.prepareStatement("UPDATE grad SET broj_stanovnika=? WHERE naziv=?")){
            preparedStatement.setInt(1,grad.getBrojStanovnika());
            preparedStatement.setString(2,grad.getNaziv());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Drzava nadjiDrzavu(String drzava){
        try(PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM drzava WHERE naziv=?")){
            preparedStatement.setString(1,drzava);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Drzava(drzava);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
