/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import entity.ProListImage;
import entity.Product;
import entity.ProductComment;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.List;
import model.ProListImageModel;
import model.ProductCommentModel;
import model.ProductModel;

/**
 *
 * @author Saka289
 */
@WebServlet(name = "ProductDetailController", urlPatterns = {"/productDetail"})
public class ProductDetailController extends HttpServlet {

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
            out.println("<title>Servlet ProductDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetailController at " + request.getContextPath() + "</h1>");
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
        ProListImageModel proListImageModel = new ProListImageModel();
        ProductCommentModel productCommentModel = new ProductCommentModel();
        String id_raw = request.getParameter("productId");
        int productId;
        try {
            productId = Integer.parseInt(id_raw);
            Product p = productModel.getProductDetail(productId);
            List<ProListImage> listPLI = proListImageModel.getProListImage(productId);
            List<ProductComment> listPC = productCommentModel.getProductCommentByProductId(productId);
            int count = 0;
            int temp = 0;
            int rating1 = 0, rating2 = 0, rating3 = 0, rating4 = 0, rating5 = 0;
            String rating = null;
            for (ProductComment pc1 : listPC) {
                temp += pc1.getRating();
                count++;
                if (pc1.getRating() == 1) {
                    rating1++;
                } else if (pc1.getRating() == 2) {
                    rating2++;
                } else if (pc1.getRating() == 3) {
                    rating3++;
                } else if (pc1.getRating() == 4) {
                    rating4++;
                } else if (pc1.getRating() == 5) {
                    rating5++;
                }
            }
            ArrayList<Integer> listRating = new ArrayList<>();
            listRating.add(rating1);
            listRating.add(rating2);
            listRating.add(rating3);
            listRating.add(rating4);
            listRating.add(rating5);
            double rating_raw = (double) temp / count;
            if (Double.isNaN(rating_raw)) {
                rating_raw = 0;
            } else {
                rating = format("%,.1f", rating_raw);
            }
            request.setAttribute("totalRating", rating);
            request.setAttribute("listRating", listRating);
            request.setAttribute("numberReview", count);
            request.setAttribute("listPC", listPC);
            request.setAttribute("ListPLI", listPLI);
            request.setAttribute("detailP", p);
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("product&category/single-product.jsp").forward(request, response);
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
