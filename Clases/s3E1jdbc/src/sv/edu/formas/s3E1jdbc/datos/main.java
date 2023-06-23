package sv.edu.formas.s3E1jdbc.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/curso";
            String user= "cursojava";
            String password = "cursojava";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection(url, user, password);
            
            Statement sentencia = cn.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM `cliente` ");
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
                    
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }
}
