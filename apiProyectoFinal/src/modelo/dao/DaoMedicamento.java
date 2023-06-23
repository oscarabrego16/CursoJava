package modelo.dao;

import java.util.List;
import modelo.entidad.Medicamento;
import modelo.entidad.Usuario;
import modelo.helper.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoMedicamento {

    public List<Medicamento> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("FROM modelo.entidad.Medicamento").list();
    }

    public boolean insertar(Medicamento med) {
        boolean r = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query query = sesion.createSQLQuery("INSERT INTO `medicamento`( `nombre`, `laboratorio`, `activo`) VALUES (:nombre,:laboratorio,:activo)");
        query.setParameter("nombre", med.getNombre());
        query.setParameter("laboratorio", med.getLaboratorio());
        query.setParameter("activo", med.getActivo());
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
        String sql = "DELETE FROM `medicamento` WHERE idMedicamento = :id";
        Query query = sesion.createSQLQuery(sql);
        Transaction tx = sesion.beginTransaction();
        query.setParameter("id", id);
        try {
            query.executeUpdate();
            tx.commit();
            r = true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return r;
    }

    public boolean modificar(int id, Medicamento med) {
        boolean r = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String sql = "UPDATE `medicamento` SET `nombre`=:nomb1,`laboratorio`=:lab,`activo`=:act WHERE idMedicamento = :id";
        Query query = sesion.createSQLQuery(sql);
        Transaction tx = sesion.beginTransaction();
        query.setParameter("id", id);
        query.setParameter("nomb1", med.getNombre());
        query.setParameter("lab", med.getLaboratorio());
        query.setParameter("act", med.getActivo());

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
