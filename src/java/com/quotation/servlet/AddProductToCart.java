/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.servlet;

import com.quotation.pojos.Product;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class AddProductToCart extends HttpServlet {

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
        int productId=Integer.parseInt(request.getParameter("productId"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        System.out.println("Quantity: "+quantity);
        System.out.println("ProductId: "+productId);
        if(request.getSession().getAttribute("cart")==null){
            ArrayList cart=new ArrayList();
            Product product=new Product();
            product.setProductId(productId);
            product.setQty(quantity);
            cart.add(product);
            request.getSession().setAttribute("cart", cart);
        }else{
            ArrayList cart=(ArrayList)request.getSession().getAttribute("cart");
            Product product=new Product();
            product.setProductId(productId);
            product.setQty(quantity);
            cart.add(product);
            request.getSession().setAttribute("cart", cart);
        }
        ArrayList cart=(ArrayList)request.getSession().getAttribute("cart");
        out.println(cart.size());
        System.out.println("product in cart: "+cart.size());
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
