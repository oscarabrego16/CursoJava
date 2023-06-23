/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.formas.dao;

import java.util.List;
import org.hibernate.Session;
import sv.edu.formas.modelo.entidad.Usuario;
import sv.edu.formas.modelo.helper.HibernateUtil;

/**
 *
 * @author oara1
 */
public class DaoUsuario {
    public List<Usuario> getAll(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cliente").list();
    }
}
