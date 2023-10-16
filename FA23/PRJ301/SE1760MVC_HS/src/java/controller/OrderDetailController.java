/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOOrderDetail;

/**
 *
 * @author alexf
 */
@WebServlet(name="OrderDetailController", urlPatterns={"/OrderDetailURL"})
public class OrderDetailController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            DAOOrderDetail dao = new DAOOrderDetail();
            String service = request.getParameter("service");
            if (service == null) {
                service = "selectOrderDetail";
            }
            if (service.equals("selectOrderDetail")) {
                String msg = request.getParameter("message");
                if (msg == null) {
                    msg = "";
                }
                Vector<OrderDetail> vector = null;
                try {
                    vector = dao.getOrderDetail("select * from [Order Details]");
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", "OrderDetails");
                request.setAttribute("tableTitle", "OrderDetail List");
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("JSP/displayOrderDetail.jsp").forward(request, response);
            }
            if (service.equals("deleteOd")) {
                int oid = Integer.parseInt(request.getParameter("oid"));
                int pid = Integer.parseInt(request.getParameter("pid"));
                int n = dao.deleteOrderDetail(oid,pid);
                String st = "";
                if (n > 0) {
                    st = "Delete success";
                } else {
                    st = "can't delete...";
                }
                response.sendRedirect("OrderDetailURL?message=" + st);
            }
            if (service.equals("insertOrderDetail")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    ResultSet rsOrder = dao.getData("select distinct OrderID from Orders");
                    ResultSet rsPro = dao.getData("select ProductID,ProductName from Products");
                    request.setAttribute("rsOrder", rsOrder);
                    request.setAttribute("rsPro", rsPro);
                    request.getRequestDispatcher("JSP/addOrderDetail.jsp").forward(request, response);
                } else {
                    

                    //convert
                    int oid = Integer.parseInt(request.getParameter("oid"));
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double discount = Double.parseDouble(request.getParameter("discount"));

                    OrderDetail od = new OrderDetail(oid, pid, unitPrice, quantity, discount);

                    int n = dao.insertOrderDetail(od);

                    String st = "";
                    if (n > 0) {
                        st = "Insert success";
                    } else {
                        st = "can't insert...";
                    }
                    
                    response.sendRedirect("OrderDetailURL?message=" + st);
                }
            }
            if (service.equals("updateOrderDetail")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int oid = Integer.parseInt(request.getParameter("oid"));
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    Vector<OrderDetail> vector = null;
                    try {
                        vector = dao.getOrderDetail("select * from [Order Details] where OrderID = "+oid+" and ProductID=" + pid);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("data", vector);
                    request.getRequestDispatcher("JSP/updateOrderDetail.jsp").forward(request, response);
                } else {
                    int oid = Integer.parseInt(request.getParameter("oid"));
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double discount = Double.parseDouble(request.getParameter("discount"));

                    OrderDetail od = new OrderDetail(oid, pid, unitPrice, quantity, discount);

                    int n = dao.updateOrderDetail(od);

                    String st = "";
                    if (n > 0) {
                        st = "update success";
                    } else {
                        st = "can't update...";
                    }
                    
                    response.sendRedirect("OrderDetailURL?message=" + st);
                }
            }
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
