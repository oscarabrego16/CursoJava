/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.formas.s7.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sv.edu.formas.s7.dominio.HibernateUtil;
import sv.edu.formas.s7.entidad.Cliente;

/**
 *
 * @author oara1
 */
public class DaoCliente {
    public List<Cliente> consultar(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cliente").list();
        
    }
    
    public boolean insertar(Cliente cli){
        boolean r = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        try{
            
        sesion.saveOrUpdate(cli);
        tx.commit();
        r=true;
        }catch(Exception e){
            System.err.println("Error "+ e.getMessage());
        }
        return r;
    }
}
