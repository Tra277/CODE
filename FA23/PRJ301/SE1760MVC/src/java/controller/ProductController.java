/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOProduct;

/**
 *
 * @author alexf
 */
@WebServlet(name="ProductController", urlPatterns={"/ProductURL"})
public class ProductController extends HttpServlet {
   
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
            DAOProduct dao = new DAOProduct();
            String service = request.getParameter("service");
            if(service==null){
                service= "selectPro";
            }
            if(service.equals("selectPro")){
                String msg = request.getParameter("message");
                if(msg==null){
                    msg="";
                }
                Vector<Product> vector = dao.getProduct("select * from Products");
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", "Products");
                request.setAttribute("tableTitle", "Product List");
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("JSP/DisplayProduct.jsp").forward(request, response);
            }
            if(service.equals("deletePro")){
                int pid =Integer.parseInt(request.getParameter("id"));
                int n = dao.deleteProduct(pid);
                String st = "";
                if(n>0){
                    st="Delete success";
                }else{
                    st="can't delete...";
                }
                response.sendRedirect("ProductURL?message="+st);
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
