<%-- 
    Document   : index
    Created on : May 4, 2023, 3:13:30 PM
    Author     : oara1
--%>

<%@page import="modelo.entidad.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
        DaoUsuario du = new DaoUsuario();
        List<Usuario> users = du.getAll();
        out.print(users.get(0).getNombre());
        %>
    </body>
</html>
