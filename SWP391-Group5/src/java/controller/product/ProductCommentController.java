/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import entity.ProductComment;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.ProductCommentModel;

/**
 *
 * @author Saka289
 */
@MultipartConfig(
        location = "D:/Study Materials/Code_Java_Web/SWP391_Project/swp391-se1637-group5/Source/SWP391-Group5/web/public/img/product",
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)              // 50MB
@WebServlet(name = "ProductCommentController", urlPatterns = {"/productcomment"})
public class ProductCommentController extends HttpServlet {

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
            out.println("<title>Servlet ProductCommentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductCommentController at " + request.getContextPath() + "</h1>");
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
        ProductCommentModel productCommentModel = new ProductCommentModel();
        ArrayList<String> listImage = new ArrayList<String>();
        HttpSession session = request.getSession();
        // User user = (User) session.getAttribute("account");
        User user = new User(2, 1, "sdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdf");
        String rating_raw = request.getParameter("rating");
        String review = request.getParameter("review");
        String productId_raw = request.getParameter("productId");
        int rating, productId = 0;
        String path = "img/product/";
        if (user != null) {
            try {
                rating = Integer.parseInt(rating_raw);
                productId = Integer.parseInt(productId_raw);
                Collection<Part> parts = request.getParts();
                for (Part filePart : parts) {
                    String fileName = getFileName(filePart);
                    if (fileName != null) {
                        filePart.write(fileName);
                        listImage.add(path.concat(fileName));
                    }
                }
                productCommentModel.insertProductComment(user, productId, review, rating, listImage);
            } catch (IOException e) {
                System.out.println(e);
            }
            response.sendRedirect("productDetail?productId=" + productId);
        } else {
            response.sendRedirect("login");
        }
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (!contentDisposition.contains("filename=")) {
            return null;
        }
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;
        return contentDisposition.substring(beginIndex, endIndex);
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
