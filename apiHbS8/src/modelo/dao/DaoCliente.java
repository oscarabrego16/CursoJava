package modelo.dao;

import java.util.List;
import modelo.entidad.Cliente;
import modelo.helper.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoCliente {
    public List<Cliente> getAll(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cliente").list();
    }
    
    
}
