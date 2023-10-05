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
@WebServlet(name = "productController", urlPatterns = {"/Product_URL"})
public class productController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            DAOProduct dao = new DAOProduct();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllProduct";
            }
            if (service.equals("listAllProduct")) {
                Vector<Product> listProduct = dao.getProduct("select * from Products");
                out.println(" <table>\n"
                        + "    <tr>\n"
                        + "        <th>ProductID</th>\n"
                        + "        <th>ProductName</th>\n"
                        + "        <th>SupplierID</th>\n"
                        + "        <th>CategoryID</th>\n"
                        + "        <th>QuantityPerUnit</th>\n"
                        + "        <th>UnitPrice</th>\n"
                        + "        <th>UnitsInStock</th>\n"
                        + "        <th>UnitsOnOrder</th>\n"
                        + "        <th>ReorderLevel</th>\n"
                        + "        <th>Discontinued</th>\n"
                        + "        <th>update</th>\n"
                        + "        <th>delete</th>\n"
                        + "    </tr>");
                for (Product product : listProduct) {
                    out.println("<tr>"
                            + "<td>" + product.getProductID() + "</td>"
                            + "<td>" + product.getProductName() + "</td>"
                            + "<td>" + product.getSupplierID() + "</td>"
                            + "<td>" + product.getCategoryID() + "</td>"
                            + "<td>" + product.getQuantityPerUnit() + "</td>"
                            + "<td>" + product.getUnitPrice() + "</td>"
                            + "<td>" + product.getUnitInStock() + "</td>"
                            + "<td>" + product.getUnitsOnOrder() + "</td>"
                            + "<td>" + product.getReorderLevel() + "</td>"
                            + "<td>" + (product.getDiscontinued() == 1 ? "Continued" : "Discontinued") + "</td>"
                            + "<td><a href=\"Product_URL?service=deleteProduct&id=" + (product.getProductID()) + "\">delete</a></td>"
                            + "</tr>");

                }

                out.print(" </table>");
            }
            if (service.equals("deleteProduct")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteProduct(id);
                response.sendRedirect("Product_URL");
            }
            if (service.equals("insertProduct")) {
                //Insert Product
                //get data
                String pname = request.getParameter("name");
                String Supplied = request.getParameter("supid");
                String cate = request.getParameter("cateid");
                String QuantityPerUnit = request.getParameter("quantityPerUnit");
                String UnitePrice = request.getParameter("unitPrice");
                String UnitsInStock = request.getParameter("unitStock");
                String UnitsOnOrder = request.getParameter("unitOrder");
                String ReorderLevel = request.getParameter("reorder");
                String Discontinued = request.getParameter("discontinued");
                // check data
                if (pname == null) {

                }
                // convert
                int supid = Integer.parseInt(Supplied);
                int cateid = Integer.parseInt(cate);
                double price = Double.parseDouble(UnitePrice);
                int instock = Integer.parseInt(UnitsInStock);
                int onOrder = Integer.parseInt(UnitsOnOrder);
                int reOder = Integer.parseInt(ReorderLevel);
                int dis = Integer.parseInt(Discontinued);
                Product pro = new Product(pname, supid, cateid, QuantityPerUnit,
                        price, instock, onOrder, reOder, dis);
                int n = dao.insertProductByPrepared(pro);
                response.sendRedirect("Product_URL");
            }

        }
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
