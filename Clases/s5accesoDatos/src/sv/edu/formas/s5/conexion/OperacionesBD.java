
package sv.edu.formas.s5.conexion;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class OperacionesBD {
    private ConexionBD cn;
    
    public OperacionesBD(){
        try {
            this.cn = new ConexionBD();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Object[]> consultar(String sql){
        List<Object[]> lst = new ArrayList<>();
        Statement sentencia;
        ResultSet rs=null;
        int cols;
        Object[] fila;
        try {
            sentencia = this.cn.getConexion().createStatement();
            rs= sentencia.executeQuery(sql);
            cols = rs.getMetaData().getColumnCount();
            while(rs.next()){
                fila = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    fila[i]= rs.getObject(i+1);
                }
                lst.add(fila);
            }
            this.cn.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public int ejecutar(String sql){
        int nr=0;
        try {
            PreparedStatement ps = this.cn.getConexion().prepareStatement(sql);
            nr = ps.executeUpdate();
            this.cn.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nr;
    }
    
}
