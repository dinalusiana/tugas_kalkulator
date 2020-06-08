/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kalkulatorrsbk.ejb.kalkulatorrsbklocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



/**
 *
 * @author USER
 */
@WebServlet(name = "kalkulatorservlet", urlPatterns = {"/kalkulatorservlet"})
public class kalkulatorservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet kalkulatorservlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet kalkulatorservlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tugas Kalkulator RSBK</title>");   
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h2>Tugas Kalkulator RSBK</h2></center>");
            out.println("<center><p>Kelompok :</p></center>");
            out.println("<center><p>Dina Lusiana - 21120117120030</p></center>");
            out.println("<center><p>Dimas Aldi Kartika - 21120117130057</p></center>");
            out.println("<center><p>Ayu Novita Mei U.- 21120117120032</p></center>");
            out.println("<center>");
            out.println("<br>");
            out.println("</br>");
            out.println("<center><h2>Kalkulator</h2></center>");
            out.println("<div id='calc-contain'>");
            out.println("<form name=\"calculator\">");
            out.println("<input type=\"text\" name=\"answer\" />");
            out.println("<br>");
            out.println("</center>");
            out.println("<center>");
            out.println("<br>");
            out.println("<input type=\"button\" value=\" 7 \" onclick=\"calculator.answer.value += '7'\" />");
            out.println("<input type=\"button\" value=\" 8 \" onclick=\"calculator.answer.value += '8'\" />");
            out.println("<input type=\"button\" value=\" 9 \" onclick=\"calculator.answer.value += '9'\" />");
            out.println("<input type=\"button\" value=\" + \" onclick=\"calculator.answer.value += '+'\" />");
            out.println("<br/>");
            out.println("<br>");
            out.println("<input type=\"button\" value=\" 4 \" onclick=\"calculator.answer.value += '4'\" />");
            out.println("<input type=\"button\" value=\" 5 \" onclick=\"calculator.answer.value += '5'\" />");
            out.println("<input type=\"button\" value=\" 6 \" onclick=\"calculator.answer.value += '6'\" />");
            out.println("<input type=\"button\" value=\" - \" onclick=\"calculator.answer.value += '-'\" />");
            out.println("<br/>"); 
            out.println("</br>");
            out.println("<input type=\"button\" value=\" 1 \" onclick=\"calculator.answer.value += '1'\" />");
            out.println("<input type=\"button\" value=\" 2 \" onclick=\"calculator.answer.value += '2'\" />");
            out.println("<input type=\"button\" value=\" 3 \" onclick=\"calculator.answer.value += '3'\" />");
            out.println("<input type=\"button\" value=\" x \" onclick=\"calculator.answer.value += '*'\" />");
            out.println("<br/>");  
            out.println("<br>");
            out.println("<input type=\"button\" value=\" c \" onclick=\"calculator.answer.value = ''\" />");
            out.println("<input type=\"button\" value=\" 0 \" onclick=\"calculator.answer.value += '0'\" />");
            out.println("<input type=\"button\" value=\" = \" onclick=\"calculator.answer.value = eval(calculator.answer.value)\" />");
            out.println("<input type=\"button\" value=\" / \" onclick=\"calculator.answer.value += '/'\" />");
            out.println("<br/>");
            out.println("</br>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private kalkulatorrsbklocal lookupkalkulatorrsbklocal() {
        try {
            Context c = new InitialContext();
            return (kalkulatorrsbklocal) c.lookup("java:global/kalkulator/kalkulator-ejb/kalkulatorrsbk!kalkulatorrsbk.ejb.kalkulatorrsbklocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
