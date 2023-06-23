<%-- 
    Document   : index
    Created on : Apr 22, 2023, 1:58:42 PM
    Author     : oara1
--%>

<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="sv.edu.formas.s7.servicios.OtroServicioCliente"%>
<%@page import="java.util.List"%>
<%@page import="sv.edu.formas.s7.entidad.Cliente"%>
<%@page import="sv.edu.formas.s7.servicios.ServicioCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <%
            /*
            ServicioCliente sc = new ServicioCliente();
            List<Cliente> lst = sc.consultarClientes();
            out.println(lst.size());
            
            for(int i=0; i<lst.size(); i++){
             out.println(lst.get(i).toString() + "<br>");
        }*/
            Gson gson = new Gson();
            OtroServicioCliente osc = new OtroServicioCliente();
            String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJPc2NhciBSb2RyaWd1ZXoiLCJpYXQiOjE2ODIxOTkxOTksImV4cCI6MTY4MjIwMDA5OSwiZW1haWwiOiJvYXJhMTZAaG90bWFpbC5jb20ifQ.cvoP7Bm17tROmw61P-I1Ndyr7W4a40LjSjvH_z_gh14";
            String cadena = osc.consultarTodos(String.class, token);
            TypeToken<List<Cliente>> tk = new TypeToken<List<Cliente>>(){};
            List<Cliente> lst = gson.fromJson(cadena, tk.getType());
            for(int i=0; i<lst.size(); i++){
             out.println(lst.get(i).toString() + "<br>");
            }
            //out.print(cadena);
        %>
    </body>
</html>
