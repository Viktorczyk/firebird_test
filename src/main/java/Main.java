import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            connection  = DriverManager.getConnection(
                    "jdbc:firebirdsql://localhost/N:\\Bazy\\Firebird2.5\\firebirdtest.FDB?serverTimezone=CET",
                    "admin",
                    "admin");


            PreparedStatement preparedStatment =
                    connection.prepareStatement(
                            "Select * from car where nazwa like ?");
            preparedStatment.setString(1, "%Fiat%");
            ResultSet result = preparedStatment.executeQuery();
            while (result.next()){
                String marka = result.getString("Marka");
                String model = result.getString("Model");
                String year = result.getString("Rok");
                Double price = result.getDouble("Cena");
                System.out.println(marka+ " " +model+" "+year +" "+price);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
    }

