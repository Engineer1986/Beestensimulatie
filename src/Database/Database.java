package Database;

import Simulatie.Wereld;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection con;
    private Wereld eng;
    
    public Database (Wereld eng) {
        this.eng = eng;
    }
    
    // Zorg voor een database verbinding. Wordt aangeroepen in elke methode
    // waar de database nodig is.
    public Connection getConnection() {
        // Als er al een verbinding is, return deze
        if (this.con != null)
            return this.con;
        
        // Anders open een nieuwe verbinding
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://uttweakers.net:3306/beesten_simulatie", "beestensim", "password");
            return this.con;
        } catch (SQLException ex) {
            System.out.println("Error: Kon geen verbinding maken met de database.");
            System.out.println(ex.toString());
            // Kon geen verbinding maken met de database. Sluit de simulatie.
            System.exit(1);
            return null;
        }
    }
    
    // Deze methode returned een 2D array met worlddata
    public Integer[][] GetWorldData(Integer World) {
        Integer worldData[][];
        Connection ourCon = getConnection();
        
        worldData = new Integer[20][20];
        
        Statement stat;
        try {
            stat = ourCon.createStatement();
            String query = "SELECT * FROM world WHERE `worldid` = " + World.toString();
            ResultSet rs = stat.executeQuery(query);
            
        } catch (SQLException ex) {
            System.out.println("Error: Er heeft zich een database fout voorgedaan.");
            
            // Sluit de simulatie.
            System.exit(1);
            return null;
        }

        return worldData;
    }
    
    // Deze methode past een wereld aan
    public void UpdateWorld(Integer World, Integer PosX, Integer PosY, Integer NewValue) {
        Connection ourCon = getConnection();
    }
}
