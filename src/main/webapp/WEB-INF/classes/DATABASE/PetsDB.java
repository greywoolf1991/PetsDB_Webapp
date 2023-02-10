package DATABASE;

import java.sql.*;
import java.util.ArrayList;

public class PetsDB {
    private static String url = "jdbc:mysql://localhost:3306/petsdb";
    private static String username = "GreyWoolf";
    private static String password = "5346123";

    public static ArrayList<Pet> select() {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pets");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String type = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    Pet pet = new Pet(id, type, name);
                    pets.add(pet);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return pets;
    }
    public static Pet selectOne(int id) {
        Pet pet = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM pets WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int petId = resultSet.getInt(1);
                        String type = resultSet.getString(2);
                        String name = resultSet.getString(3);
                        pet = new Pet(petId, type, name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return pet;
    }
    public static int insert(Pet pet) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO pets (type, name) Values (?, ?);";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, pet.getType());
                    preparedStatement.setString(2, pet.getName());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Pet pet) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE pets SET type = ?, name = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, pet.getType());
                    preparedStatement.setString(2, pet.getName());
                    preparedStatement.setInt(3, pet.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM pets WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
