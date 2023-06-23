<%-- 
    Document   : index
    Created on : Apr 1, 2023, 2:32:18 PM
    Author     : oara1
--%>

<%@page import="sv.edu.formas.s5.entidad.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <%
            List<Cliente> ls = (List<Cliente>)request.getAttribute("lista"); //se asegura que pase por el servlet
        if(ls == null){
                out.println("La peticion se hizo de manera incorrecta");
            }else{
                for (int i = 0; i < ls.size(); i++) {
                        out.println(ls.get(i)+"<br>");
                    }
            }
        %>
    </body>
</html>
