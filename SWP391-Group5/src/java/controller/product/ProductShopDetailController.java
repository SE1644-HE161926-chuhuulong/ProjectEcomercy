/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.CategoryModel;
import model.ProductModel;

/**
 *
 * @author Saka289
 */
@WebServlet(name = "ProductShopDetailController", urlPatterns = {"/productshopdetail"})
public class ProductShopDetailController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductShopDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductShopDetailController at " + request.getContextPath() + "</h1>");
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
        ProductModel productModel = new ProductModel();
        CategoryModel categoryModel = new CategoryModel();
        List<Category> listC = categoryModel.getAllCategory();
        String cateId_raw = request.getParameter("cateId");
        String listCateId_raw = request.getParameter("listCateId");
        int cateId, listCateId;
        try {
            if (cateId_raw != null) {
                cateId = Integer.parseInt(cateId_raw);
                List<Product> ListP = productModel.getProductByCategory(cateId);
                request.setAttribute("listP", ListP);
            }
            if (listCateId_raw != null) {
                listCateId = Integer.parseInt(listCateId_raw);
                List<Product> ListP1 = productModel.getProductByAllCategory(listCateId);
                request.setAttribute("listP", ListP1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("product&category/category.jsp").forward(request, response);
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
