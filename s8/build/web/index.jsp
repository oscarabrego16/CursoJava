<%-- 
    Document   : index
    Created on : Apr 29, 2023, 3:01:09 PM
    Author     : oara1
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>

<%@page import="java.util.HashSet"%>
<%@page import="modelo.entidad.Detfact"%>
<%@page import="java.util.Set"%>
<%@page import="modelo.entidad.Factura"%>
<%@page import="modelo.entidad.Producto"%>
<%@page import="modelo.entidad.Cliente"%>
<%@page import="modelo.entidad.NewHibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
    </head>
    <body>
        <h1>Factura</h1>
        
        <%
            Cliente cli = new Cliente("Diana", "Martinez");
            
            Producto pro = new Producto("Producto a");
            Producto pro2 = new Producto("Producto b");
            
            Factura fact = new Factura();
            fact.setNoFactura("3");
            fact.setCliente(cli);
            fact.setDescripcion("Factura numero tres");
            
            Set<Detfact> detalle = new HashSet<Detfact>();
            detalle.add(new Detfact(fact, pro, 1));
            detalle.add(new Detfact(fact, pro2, 2));
            
            fact.setDetfacts(detalle);
            
            try {
                    Session sesion = NewHibernateUtil.getSessionFactory().openSession();
                    sesion.getTransaction().begin();
                    sesion.save(fact);
                    sesion.getTransaction().commit();
                    sesion.close();
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
        %>
        
    </body>
</html>
