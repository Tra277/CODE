/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOCustomer;

/**
 *
 * @author alexf
 */
@WebServlet(name = "customerController", urlPatterns = {"/CustomerURL"})
public class customerController extends HttpServlet {

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
            DAOCustomer dao = new DAOCustomer();
            String service = request.getParameter("service");
            if (service == null) {
                service = "selectCus";
            }
            if (service.equals("selectCus")) {
                String msg = request.getParameter("message");
                if (msg == null) {
                    msg = "";
                }
                Vector<Customer> vector = dao.getCustomer("select * from Customers");
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", "Customers");
                request.setAttribute("tableTitle", "Customer List");
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("JSP/displayCustomer.jsp").forward(request, response);
            }
            if (service.equals("deleteCus")) {
                String cid = request.getParameter("id");
                int n = dao.deleteCustomer(cid);
                String st = "";
                if (n > 0) {
                    st = "Delete success";
                } else {
                    st = "can't delete...";
                }
                response.sendRedirect("CustomerURL?message=" + st);
            }
            if (service.equals("insertCustomer")) {
                
                
                    String cid = request.getParameter("cid");
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
                    
                    

                    Customer cus = new Customer(cid, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);

                    int n = dao.insertCustomerByPrepared(cus);

                    String st = "";
                    if (n > 0) {
                        st = "Add success";
                    } else {
                        st = "can't insert...";
                    }
                    
                    response.sendRedirect("CustomerURL?message=" + st);
                
            }
            if(service.equals("updateCustomer")){
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String cid = request.getParameter("cid");
                    Vector<Customer> vector
                            = dao.getCustomer("select * from Customers where CustomerID ='" + cid+"'");
                    request.setAttribute("data", vector);
                    request.getRequestDispatcher("JSP/updateCustomer.jsp").forward(request, response);
                } else {
                    String cid = request.getParameter("cid");
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
                    Customer cus = new Customer(cid, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
                    int n = dao.updateCustomer(cus);
                    String st = "";
                    if (n > 0) {
                        st = "update success";
                    } else {
                        st = "can't update because....";
                    }
                    response.sendRedirect("CustomerURL?message=" + st);
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
