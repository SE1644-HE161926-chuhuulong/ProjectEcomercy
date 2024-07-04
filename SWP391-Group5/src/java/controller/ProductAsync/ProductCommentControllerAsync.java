/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ProductAsync;

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
@WebServlet(name = "ProductCommentControllerAsync", urlPatterns = {"/productcommentAsync"})
public class ProductCommentControllerAsync extends HttpServlet {

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
            out.println("<title>Servlet ProductCommentControllerAsync</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductCommentControllerAsync at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("Id");
        int productId;
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
        PrintWriter out = response.getWriter();
        for (ProductComment list1 : listPC) {
            out.println("                                    <div class=\"review_item\">\n"
                    + "                                        <div class=\"media\">\n"
                    + "                                            <div class=\"d-flex\">\n"
                    + "                                                <img src=\"" + list1.getUser().getAvatar() + "\" alt=\"\">\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"media-body\">\n"
                    + "                                                <h4>" + list1.getUser().getFullName() + "</h4>\n"
                    + "                                                <c:forEach begin=\"1\" end=\"${pc.rating}\">\n"
                    + "                                                    <i class=\"fa fa-star\"></i>\n"
                    + "                                                </c:forEach>\n"
                    + "                                                <c:forEach begin=\"${pc.rating}\" end=\"4\">\n"
                    + "                                                    <i style=\"font-family: FontAwesome;\" class=\"fa fa-star-o\"></i>\n"
                    + "                                                </c:forEach>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                        <p>${pc.content}</p>\n"
                    + "                                        <c:if test=\"${pc.listImage.size() != null}\">\n"
                    + "                                            <div class=\"review-comment\">\n"
                    + "                                                <div class=\"row-review\">\n"
                    + "                                                    <c:forEach items=\"${pc.listImage}\" var=\"pc1\">\n"
                    + "                                                        <div class=\"column-review\">\n"
                    + "                                                            <img src=\"${pc1.image}\" alt=\"\"  onclick=\"myFunction(this, '${pc1.id}');\">\n"
                    + "                                                        </div>\n"
                    + "                                                    </c:forEach>\n"
                    + "                                                </div>\n"
                    + "                                                <c:forEach items=\"${pc.listImage}\" var=\"pc2\">\n"
                    + "                                                    <div class=\"container-review\">\n"
                    + "                                                        <span onclick=\"this.parentElement.style.display = 'none'\" class=\"closebtn-review\">&times;</span>\n"
                    + "                                                        <img id=\"expandedImg${pc2.id}\" style=\"width:80%\">\n"
                    + "                                                    </div>\n"
                    + "                                                </c:forEach>\n"
                    + "                                            </div>\n"
                    + "                                        </c:if>\n"
                    + "                                    </div>");
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
