/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidad.Usuario;
import modelo.helper.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author oara1
 */
public class DaoUsuario {

    public List<Usuario> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Usuario").list();
    }

    public boolean validar(String us, String pw) {
        boolean r = false;
        /*try{
        */
            
            
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        Query query=  sesion.createQuery("from Usuario U WHERE U.username= :us AND U.password= MD5(:pw)");
        query.setParameter("us", us);
        query.setParameter("pw", pw);
        
        
        if(query.list().size()>0){
        r=true;
        }
        /*
        
        Transaction tx = sesion.beginTransaction();
        String hql = "FROM Usuario U WHERE U.username= :us AND U.password= MD5(:pw)";
        Query query = sesion.createQuery(hql);
        query.setParameter("us", us);
        query.setParameter("pw", pw);
        List results = query.list();
        if(results != null && results.isEmpty()){
            r= true;
            System.out.println("modelo.dao.DaoUsuario.validar()   "+ " SE ENCONTRO USUARIO ");
        }
            System.out.println("modelo.dao.DaoUsuario.validar() "+ results);
        System.out.println("modelo.dao.DaoUsuario.validar()   "+ " NOOO SE ENCONTRO USUARIO "+ us+pw);
        tx.commit();
        }catch(Exception e){
             System.err.println("Error " + e.getMessage());
        }
        */
        
        
        /*
        
        Query query = sesion.createSQLQuery("SELECT username FROM usuario WHERE username= :us AND password = MD5(:pw)");
        query.setParameter("us", us);
        query.setParameter("pw", pw);
        Transaction tx = sesion.beginTransaction();
        try {
            query.executeUpdate();
            tx.commit();
            r = true;
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }*/
        return r;

    }

    public boolean insertar(Usuario us) {
        boolean r = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query query = sesion.createSQLQuery("INSERT INTO `usuario`( `nombre`, `apellido`, `username`, `password`) VALUES (:nombre,:apellido,:username,MD5(:password))");
        query.setParameter("nombre", us.getNombre());
        query.setParameter("apellido", us.getApellido());
        query.setParameter("username", us.getUsername());
        query.setParameter("password", us.getPassword());
        Transaction tx = sesion.beginTransaction();
        try {
            query.executeUpdate();
            tx.commit();
            r = true;
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        return r;
    }

    public boolean eliminar(int id) {
        boolean r = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String sql = "DELETE FROM `usuario` WHERE idUsuario = :id";
        Query query = sesion.createSQLQuery(sql);
        Transaction tx = sesion.beginTransaction();
        query.setParameter("id", id);
        try {
            query.executeUpdate();
            tx.commit();
            r = true;
            System.out.println("modelo.dao.DaoUsuario.eliminar() EXITOS");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return r;
    }

    public boolean modificar(int id, Usuario us) {
        boolean r = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String sql = "UPDATE `usuario` SET `nombre`=:nomb1,`apellido`=:ape,`username`=:use,`password`=MD5(:pas) WHERE idUsuario = :id";
        Query query = sesion.createSQLQuery(sql);
        Transaction tx = sesion.beginTransaction();
        query.setParameter("id", id);
        query.setParameter("nomb1", us.getNombre());
        query.setParameter("ape", us.getApellido());
        query.setParameter("use", us.getUsername());
        query.setParameter("pas", us.getPassword());

        try {
            query.executeUpdate();
            tx.commit();
            r = true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return r;
    }

}
