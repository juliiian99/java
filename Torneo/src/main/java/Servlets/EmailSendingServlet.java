package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.EmailData;
 
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {

    private String host = "smtp.gmail.com";
    private String port = "587";
    private String user = "reportesappjava@gmail.com";
    private String pass = "Milanesas123";
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = "reportesappjava@gmail.com";
        String subject = request.getParameter("subject");
        String usuario = request.getParameter("repUsuario");
        String content = request.getParameter("content");
 
        String resultMessage = "";
 
        try {
            EmailData.sendEmail(host, port, user, pass, recipient, subject, usuario,
                    content);
            resultMessage = "Su denuncia fue enviada correctamente";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "Se produjo un error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/MensajeReporte.jsp").forward(
                    request, response);
        }
    }
}