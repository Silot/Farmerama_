/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Farmerama;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ntinos
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    private String address;
    String message="Invalid Input.";
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
        PrintWriter out = response.getWriter();
        
        //out.close();
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
        response.setContentType("text/html");
        SignUpVal user = new SignUpVal();
        if(!user.validExistence(request.getParameter("un")))
        {
            address = "SUErrorPage.jsp";
        }
        else if(user.validateInput(request.getParameter("un"), 
                request.getParameter("pw")))
        {
            if(request.getParameter("sex").toString().equals("Female")){
            user.setDoc(request.getParameter("un"), 
                request.getParameter("pw"), 
                request.getParameter("eMail"),
                request.getParameter("sex"), 
                request.getParameter("section"),
                request.getParameter("ProfileImageFemale"),
                request.getParameter("number"));
            address = "index.jsp";
            }
            else{
            user.setDoc(request.getParameter("un"), 
                request.getParameter("pw"), 
                request.getParameter("eMail"),
                request.getParameter("sex"), 
                request.getParameter("section"),
                request.getParameter("ProfileImageMale"),
                request.getParameter("number"));
            address = "index.jsp";
            }
        }
        else
        {
            address = "signUp.jsp";
            request.setAttribute("message", message);
        }
        
      
        
        
        //response.sendRedirect("index.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
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

}
