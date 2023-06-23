package sv.edu.formas.s5.dao;

import java.util.ArrayList;
import java.util.List;
import sv.edu.formas.s5.conexion.OperacionesBD;
import sv.edu.formas.s5.entidad.Cliente;

public class DaoCliente {
    private List<Cliente> lista;
    
    public DaoCliente(){
        this.lista = new ArrayList<>();
    }
    public List<Cliente> getAll(){
        String sql = "SELECT idCliente, nombre, apellido FROM `cliente`";
        OperacionesBD op = new OperacionesBD();
        List<Object[]> lst = op.consultar(sql);
        for (int i = 0; i < lst.size(); i++) {
            Cliente cli = new Cliente();
            cli.setIdCliente(Integer.parseInt(lst.get(i)[0].toString()));
            cli.setNombre(lst.get(i)[1].toString());
            cli.setApellido(lst.get(i)[2].toString());
            this.lista.add(cli);
        }
    return this.lista;
    }
    
        public Cliente getById(int id){
        String sql = "SELECT idCliente, nombre, apellido FROM `cliente` WHERE idCliente='"+id+"'";
        OperacionesBD op = new OperacionesBD();
        List<Object[]> lst = op.consultar(sql);
        Cliente cli = new Cliente();
        if(lst.size()>0){
            //el registro si se filtro
            cli.setIdCliente(Integer.parseInt(lst.get(0)[0].toString()));
            cli.setNombre(lst.get(0)[1].toString());
            cli.setApellido(lst.get(0)[2].toString());
        }
    return cli;
    }
        
        public int insertar(Cliente cli){
            int r= 0;
            String sql = "INSERT INTO Cliente (nombre, apellido) VALUES ('"+cli.getNombre()+"','"+cli.getApellido()+"')";
            //String sql = "INSERT INTO Cliente (nombre, apellido) VALUES (?,?)";
        
            OperacionesBD op = new OperacionesBD();
            r = op.ejecutar(sql);
            return r;
        }
        
        public int modificar(int id, Cliente cli){
            int r= 0;
             String sql = "UPDATE Cliente SET nombre = '"+cli.getNombre()+"', apellido ='"+cli.getApellido()+"' WHERE idCliente= "+id+"";
            //String sql = "INSERT INTO Cliente (nombre, apellido) VALUES (?,?)";
        
            OperacionesBD op = new OperacionesBD();
            r = op.ejecutar(sql);
            return r;
        }
        public int eliminar(int id){
            int r= 0;
             String sql = "DELETE from Cliente WHERE idCliente = "+id;
            //String sql = "INSERT INTO Cliente (nombre, apellido) VALUES (?,?)";
        
            OperacionesBD op = new OperacionesBD();
            r = op.ejecutar(sql);
            return r;
        }
}
