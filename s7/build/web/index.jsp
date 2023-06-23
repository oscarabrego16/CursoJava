<%-- 
    Document   : index
    Created on : Apr 29, 2023, 12:30:09 PM
    Author     : oara1
--%>

<%@page import="sv.edu.formas.s7.entidad.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="sv.edu.formas.s7.dao.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate clientes</title>
    </head>
    <body>
        <h1>Clientes</h1>
        
        <%
        DaoCliente dc = new DaoCliente();
        //List<Cliente> lst = dc.consultar();
        /*for(int i=0; i< lst.size(); i++){
            out.println(lst.get(i).getIdCliente() + " " + lst.get(i).getNombre()+ " "+ lst.get(i).getApellido());
        }*/
        
        Cliente cli = new Cliente("Mario", "Diaz");
        dc.insertar(cli);
        %>
    </body>
</html>
