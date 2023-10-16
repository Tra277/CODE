/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOCategory;

/**
 *
 * @author alexf
 */
@WebServlet(name = "categoryController", urlPatterns = {"/CategoryURL"})
public class categoryController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOCategory dao = new DAOCategory();
            String service = request.getParameter("service");
            if (service == null) {
                service = "selectCategory";
            }
            if (service.equals("selectCategory")) {
                String msg = request.getParameter("message");
                if (msg == null) {
                    msg = "";
                }
                Vector<Category> vector = null;
                try {
                    vector = dao.getCategory("select * from Categories");
                } catch (SQLException ex) {
                    Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", "Categories");
                request.setAttribute("tableTitle", "Category List");
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("JSP/displayCategory.jsp").forward(request, response);
            }
            if (service.equals("deleteCategory")) {
                int cid = Integer.parseInt(request.getParameter("id"));
                int n = dao.deleteCategory(cid);
                String st = "";
                if (n > 0) {
                    st = "Delete success";
                } else {
                    st = "can't delete...";
                }
                response.sendRedirect("CategoryURL?message=" + st);
            }
            if (service.equals("insertCategory")) {
                String categoryName = request.getParameter("categoryName");
                String description = request.getParameter("description");
                String picture = request.getParameter("picture");

                Category c = new Category(categoryName, description, picture);

                int n = dao.insertCategory(c);

                String st = "";
                if (n > 0) {
                    st = "Add success";
                } else {
                    st = "can't insert...";
                }

                response.sendRedirect("CategoryURL?message=" + st);

            }
            if (service.equals("updateCategory")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int cid = Integer.parseInt(request.getParameter("id"));
                    Vector<Category> vector = null;
                    try {
                        vector = dao.getCategory("select * from Categories where CategoryID =" + cid);
                    } catch (SQLException ex) {
                        Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("data", vector);
                    request.getRequestDispatcher("JSP/updateCategory.jsp").forward(request, response);
                } else {
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    String categoryName = request.getParameter("categoryName");
                    String description = request.getParameter("description");
                    String picture = request.getParameter("picture");

                    Category c = new Category(cid, categoryName, description, picture);

                    int n = dao.updateCategory(c);

                    String st = "";
                    if (n > 0) {
                        st = "update success";
                    } else {
                        st = "can't update...";
                    }

                    response.sendRedirect("CategoryURL?message=" + st);
                }
            }

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

}
