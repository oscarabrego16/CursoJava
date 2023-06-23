<%-- 
    Document   : index
    Created on : Apr 1, 2023, 12:51:27 AM
    Author     : oara1
--%>

<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.DriverManager"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina JSP</title>
        <style>
            .registros{
                background: #99999f;
            }
        </style>
    </head>
    <body>
        <h1>Hola mundo desde JSP!</h1>
        <%
        try{
        String url="jdbc:mysql://localhost:3306/curso";
        String usuario= "cursojava";
        String clave = "cursojava";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection(url, usuario, clave);  
            
            Statement sentencia = cn.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT id, nombre, apellido FROM `cliente`");
            
            while(rs.next()){
                out.println("<p class='registros'>"+rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getString(3)+ "</p>");
                
            }
            rs.close();
            sentencia.close();
            cn.close();
            }catch (Exception e){}
        %>
    </body>
</html>
