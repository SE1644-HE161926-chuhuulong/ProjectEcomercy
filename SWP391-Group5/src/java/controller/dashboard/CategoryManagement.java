/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.dashboard;

import entity.Category;
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
@WebServlet(name="CategoryManagement", urlPatterns={"/categoryManagement"})
public class CategoryManagement extends HttpServlet {
   
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoryManagament</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryManagament at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        CategoryModel cateDB = new CategoryModel();
        List<Category> cList = cateDB.getAllCategory();
        request.setAttribute("cList", cList);
         
        
        request.getRequestDispatcher("dashboard/categoryManagement.jsp").forward(request, response);
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
                String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        if (action.equalsIgnoreCase("addCategory")) {
            doPost_addCategory(request, response);
        } else if (action.equalsIgnoreCase("editCategory")) {
            doPost_editCategory(request, response);
        } else if (action.equalsIgnoreCase("update")) {
            doPost_update(request, response);
        } else if (action.equalsIgnoreCase("create")) {
            doPost_create(request, response);
        }
    }
     protected void doPost_addCategory(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          CategoryModel cateDB = new CategoryModel();
        List<Category> cList = cateDB.getAllCategory();
        request.setAttribute("cList", cList);
        request.getRequestDispatcher("dashboard/addCategory.jsp").forward(request, response);
     }
     
      protected void doPost_editCategory(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
        }
        CategoryModel cateDB = new CategoryModel();
        Category cate = cateDB.getCategoryById(id);
        List<Category> cList = cateDB.getAllCategoryExcept(id);
        request.setAttribute("id", id);
        request.setAttribute("cateName", cate.getCateName());
        request.setAttribute("image", cate.getImage());
        request.setAttribute("parentId", cate.getParentId());
        request.setAttribute("cateStatus", cate.getCateStatus());
        request.setAttribute("cList", cList);
        request.getRequestDispatcher("dashboard/editCategory.jsp").forward(request, response);
     }

       protected void doPost_update(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          CategoryModel cateDB = new CategoryModel();       
        if (request.getParameter("submit").equalsIgnoreCase("Save")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Category cate = new Category(id, request.getParameter("name"), request.getParameter("image"), Integer.parseInt(request.getParameter("category")), Integer.parseInt(request.getParameter("status")));
            cateDB.updateCategory(id, cate);
            response.sendRedirect("categoryManagement");
        } else{
            response.sendRedirect("categoryManagement");
        }
     }

        protected void doPost_create(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            CategoryModel cateDB = new CategoryModel();       
        if (request.getParameter("submit").equalsIgnoreCase("Save")) {
            
            Category cate = new Category(Integer.parseInt(request.getParameter("category")), request.getParameter("name"), request.getParameter("image"), Integer.parseInt(request.getParameter("category")), Integer.parseInt(request.getParameter("status")));
            cateDB.insertCategory(cate);
            response.sendRedirect("categoryManagement");
        } else{
            response.sendRedirect("categoryManagement");
        }
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
