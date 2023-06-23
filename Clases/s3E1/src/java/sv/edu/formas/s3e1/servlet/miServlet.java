/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.formas.s3e1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class miServlet  extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        this.procesar(rq,rp);
    }
    @Override
    public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        this.procesar(rq,rp);
    }
    
    public void procesar(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        PrintWriter out = rp.getWriter();
        out.println("Hola mundo desde servlets");
    }
}
