
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletDetecta", urlPatterns = {"/ServletDetecta"})
public class ServletDetecta extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
    response.setHeader("Cache-Control", "no-cache");
     
    int contador = 0;
     Cookie[] co = request.getCookies();
     
     if(co != null){
         for(Cookie c : co){
             if(c.getName().equals("visitas")){
                 contador = Integer.parseInt(c.getValue());
             }
         }
     }
     contador++;
     
     Cookie c = new Cookie("visitas", Integer.toString(contador));
     c.setMaxAge(10);
     
     response.addCookie(c);
     
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
     if(contador <= 1 ){
            out.println ("<HTML>");           
            out.println ("<BODY style=\"background-color: skyblue\">");   
            out.println ("<BR>");
            out.println ("<BR>");
            out.println("<p style=\"text-align: center;font-size: 35px\">Bienvenido a nuestro sitio web!!!</p>");  
            out.println ("<BR>");
            out.println ("</BODY>");          
            out.println ("</HTML>");  
          
     }
     else{
            out.println ("<HTML>");           
            out.println ("<BODY style=\"background-color: skyblue\">");   
            out.println ("<BR>");
            out.println ("<BR>");
            out.println("<p style=\"text-align: center;font-size: 35px\">Gracias por visitarnos nuevamente!!!</p>");  
            out.println ("<BR>");
            out.println ("</BODY>");          
            out.println ("</HTML>");   
     }       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
}
