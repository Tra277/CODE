/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Supplier;
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
import model.DAOSupplier;

/**
 *
 * @author alexf
 */
@WebServlet(name = "SupplierController", urlPatterns = {"/SupplierURL"})
public class SupplierController extends HttpServlet {

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
            DAOSupplier dao = new DAOSupplier();
            String service = request.getParameter("service");
            if (service == null) {
                service = "selectSup";
            }
            if (service.equals("selectSup")) {
                String msg = request.getParameter("message");
                if (msg == null) {
                    msg = "";
                }
                Vector<Supplier> vector = null;
                try {
                    vector = dao.getSupplier("select * from Suppliers");
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", "Products");
                request.setAttribute("tableTitle", "Product List");
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("JSP/displaySupplier.jsp").forward(request, response);
            }
            if (service.equals("deleteSup")) {
                int sid = Integer.parseInt(request.getParameter("id"));
                int n = dao.deleteSupplier(sid);
                String st = "";
                if (n > 0) {
                    st = "Delete success";
                } else {
                    st = "can't delete...";
                }
                response.sendRedirect("SupplierURL?message=" + st);
            }
            if (service.equals("insertSupplier")) {
                String companyName = request.getParameter("companyName");
                String contactName = request.getParameter("contactName");
                String contactTitle = request.getParameter("contactTitle");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String region = request.getParameter("region");
                String postalCode = request.getParameter("postalCode");
                String country = request.getParameter("country");
                String phone = request.getParameter("phone");
                String fax = request.getParameter("fax");
                String homePage = request.getParameter("homePage");

                Supplier s = new Supplier(companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, homePage);

                int n = dao.insertSupplier(s);

                String st = "";
                if (n > 0) {
                    st = "Add success";
                } else {
                    st = "can't insert...";
                }

                response.sendRedirect("SupplierURL?message=" + st);
            }
            if (service.equals("updateSupplier")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String sid = request.getParameter("sid");
                    Vector<Supplier> vector = null;
                    try {
                        vector = dao.getSupplier("select * from Suppliers where SupplierID =" + sid);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("data", vector);
                    request.getRequestDispatcher("JSP/updateSupplier.jsp").forward(request, response);
                } else {
                    int sid = Integer.parseInt(request.getParameter("sid")) ;
                    String companyName = request.getParameter("companyName");
                    String contactName = request.getParameter("contactName");
                    String contactTitle = request.getParameter("contactTitle");
                    String address = request.getParameter("address");
                    String city = request.getParameter("city");
                    String region = request.getParameter("region");
                    String postalCode = request.getParameter("postalCode");
                    String country = request.getParameter("country");
                    String phone = request.getParameter("phone");
                    String fax = request.getParameter("fax");
                    String homePage = request.getParameter("homePage");
                    Supplier s = new Supplier(sid, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, homePage);
                    int n = dao.updateSupplier(s);
                    String st = "";
                    if (n > 0) {
                        st = "update success";
                    } else {
                        st = "can't update because....";
                    }
                    response.sendRedirect("SupplierURL?message=" + st);
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
