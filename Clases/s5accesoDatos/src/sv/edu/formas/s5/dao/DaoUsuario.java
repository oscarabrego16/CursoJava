package sv.edu.formas.s5.dao;

import java.util.List;
import sv.edu.formas.s5.conexion.OperacionesBD;
import sv.edu.formas.s5.entidad.Usuario;

public class DaoUsuario {
    public DaoUsuario(){
        
    }
    
    public boolean validar(String us, String pw){
        boolean res = false;
        String sql = "SELECT login FROM usuario WHERE login= '"+us+"' AND password = MD5('"+pw+"')";
        OperacionesBD op = new OperacionesBD();
        
        List<Object[]> lst = op.consultar(sql);
        if(lst.size()>0){
        res = true;
        }
    
    return res;
    }
}
