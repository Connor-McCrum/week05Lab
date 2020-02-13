/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class ShoppingList extends HttpServlet {

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
        if(request.getParameter("logout") != null){
            HttpSession session = request.getSession(false);
            session.invalidate();
            

            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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
        HttpSession session = request.getSession(false);
        String addOrDelete = request.getParameter("addOrDelete");
        if (addOrDelete != null) {
            boolean boolAddOrDelete = Boolean.parseBoolean(addOrDelete);
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            if(boolAddOrDelete){
                String itemToAdd = request.getParameter("toAdd");
                items.add(itemToAdd);
                session.setAttribute("items",items );
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            else{
                String toRemove = request.getParameter("anItem");
                items.remove(toRemove);
                session.setAttribute("items", items);
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }
       
        else {
            String username = request.getParameter("username");
            if (username != null && !username.equals("")) {
                session.setAttribute("username", username);
                session.setAttribute("items", new ArrayList<String>());
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }

        
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
