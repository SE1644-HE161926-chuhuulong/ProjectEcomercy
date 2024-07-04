/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.dashboard;

import com.google.gson.Gson;
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
 * @author ADMIN
 */
@WebServlet(name = "ProductManagement", urlPatterns = {"/productManagement"})
public class ProductManagement extends HttpServlet {

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
            out.println("<title>Servlet Dashboard</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Dashboard at " + request.getContextPath() + "</h1>");
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
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        ProductModel proDB = new ProductModel();
        CategoryModel cateDB = new CategoryModel();
        List<Product> list = proDB.getAllProduct();
        List<Category> cList = cateDB.getAllCategory();
        request.setAttribute("cList", cList);
        request.setAttribute("Prolist", list);
        if (action.equalsIgnoreCase("find")) {
            doGet_Find(request, response);
        }
        request.getRequestDispatcher("dashboard/productManagement.jsp").forward(request, response);
    }

    protected void doGet_Find(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        int id = Integer.parseInt(request.getParameter("id"));
        ProductModel ProDB = new ProductModel();
        Product p = ProDB.getProductDetail(id);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(p));
        writer.flush();
        writer.close();

    }

    protected void doPost_Update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductModel proDB = new ProductModel();
        if (request.getParameter("submit").equalsIgnoreCase("Save")) {
            int id = Integer.parseInt(request.getParameter("id"));
            proDB.updateProduct(id,
                    Integer.parseInt(request.getParameter("subcategory1")),
                    1,
                    request.getParameter("name"),
                    Double.parseDouble(request.getParameter("price")),
                    Double.parseDouble(request.getParameter("discount")),
                    request.getParameter("description"),
                    request.getParameter("image"),
                    Integer.parseInt(request.getParameter("quantity")),
                    3,
                    3,
                    null,
                    null,
                    Integer.parseInt(request.getParameter("status"))
            );
            response.sendRedirect("productManagement");
        } else {
            response.sendRedirect("productManagement");
        }

    }

    protected void doPost_Create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductModel proDB = new ProductModel();
        proDB.insertProduct(
                Integer.parseInt(request.getParameter("subcategory")),
                1,
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                Double.parseDouble(request.getParameter("discount")),
                request.getParameter("description"),
                request.getParameter("image"),
                Integer.parseInt(request.getParameter("quantity")),
                3,
                3,
                null,
                null,
                Integer.parseInt(request.getParameter("status"))
        );
        response.sendRedirect("productManagement");

    }

    protected void doPost_addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryModel cateDB = new CategoryModel();
        List<Category> cList = cateDB.getAllCategory();
        request.setAttribute("cList", cList);
        request.getRequestDispatcher("dashboard/addProduct.jsp").forward(request, response);
    }

    protected void doPost_editProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
        }
        System.out.println("ID=" + id);
        ProductModel proDB = new ProductModel();
        CategoryModel cateDB = new CategoryModel();
        List<Category> cList = cateDB.getAllCategory();
        Product p = proDB.getProductDetail(id);
        request.setAttribute("id", id);
        request.setAttribute("name", p.getProductName());
        request.setAttribute("price", p.getPrice());
        request.setAttribute("discount", p.getDiscount());
        request.setAttribute("des", p.getDescription());
        request.setAttribute("quantity", p.getQuantity());
        request.setAttribute("image", p.getImage());
        request.setAttribute("status", p.getProductStatus());
        request.setAttribute("parentId", p.getCategory().getParentId());
        request.setAttribute("cateId", p.getCategory().getCateId());
        request.setAttribute("cList", cList);
        request.getRequestDispatcher("dashboard/editProduct.jsp").forward(request, response);
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
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        if (action.equalsIgnoreCase("addProduct")) {
            doPost_addProduct(request, response);
        } else if (action.equalsIgnoreCase("editProduct")) {
            doPost_editProduct(request, response);
        } else if (action.equalsIgnoreCase("update")) {
            doPost_Update(request, response);
        } else if (action.equalsIgnoreCase("create")) {
            doPost_Create(request, response);
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
