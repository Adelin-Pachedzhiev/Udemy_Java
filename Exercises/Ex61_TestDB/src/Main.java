import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/adelinpachedzhiev/Documents/Udemy/Java/Exercises/Ex61_TestDb/Test.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    " (name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts (name, phone, email)  VALUES('Adi', 012312112,'email@email.com') ");

            statement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}