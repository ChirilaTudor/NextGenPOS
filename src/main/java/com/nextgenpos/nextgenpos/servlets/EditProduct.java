package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditProduct", value = "/EditProduct")
public class EditProduct extends HttpServlet {

    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<ProductDto> products = productsBean.findAllProducts();
//        request.setAttribute("products", products);

        Long productId = Long.parseLong(request.getParameter("id"));
        ProductDto product = productsBean.findById(productId);
        request.setAttribute("products", product);

        request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp").forward(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("product_id");
        String productName = request.getParameter("product_name");
        Integer quantity = Integer.parseInt(request.getParameter("product_quantity"));
        Float price = Float.parseFloat(request.getParameter("product_price"));
        String description = request.getParameter("product_description");
        String provider = request.getParameter("product_provider");

        productsBean.updateProduct(productId,productName, quantity, price, description, provider);

        response.sendRedirect(request.getContextPath() + "/Products");
    }

}
