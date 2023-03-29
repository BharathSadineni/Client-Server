import java.sql.*;

public class Database {

    //This method executes a query and returns the number of albums for the artist with name artistName
    public int getTitles(String artistName) {
        int titleNum = 0;
        //Implement this method
        //Prevent SQL injections!
        String USERNAME = "postgres";
        String PASSWORD = "fsad";
        String URL = "jdbc:postgresql://localhost:5432/Music";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String a = "";
            ResultSet set;
            String query = "SELECT count(album) FROM album NATURAL JOIN artist WHERE artist.name = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, artistName);
            set = statement.executeQuery();
            while (set.next()) {
                a = set.getObject(1).toString();
            }
            titleNum = Integer.parseInt(a);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } return titleNum;
    }


    // This method establishes a DB connection & returns a boolean status
    public boolean establishDBConnection() {
        //Implement this method
        //5 sec timeout
        String USERNAME = "postgres";
        String PASSWORD = "fsad";
        String URL = "jdbc:postgresql://localhost:5432/Music";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return con.isValid(5);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}