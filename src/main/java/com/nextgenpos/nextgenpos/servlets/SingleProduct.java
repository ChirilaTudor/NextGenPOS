package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SingleProduct", value = "/SingleProduct")
public class SingleProduct extends HttpServlet {
    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDto> single_product = productsBean.findAllProducts();
        Long idProduct = Long.parseLong(request.getParameter("idProduct"));
        ProductDto productDto = productsBean.findById(idProduct);
        request.setAttribute("single_product", productDto);
        request.getRequestDispatcher("/WEB-INF/pages/singleProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] productIdsAsString = request.getParameterValues("single_product_ids");
        if(productIdsAsString != null){
            List<Long> productsIds = new ArrayList<>();
            for(String productIdAsString : productIdsAsString){
                productsIds.add(Long.parseLong(productIdAsString));
            }
            productsBean.deleteProductsByIds(productsIds);
        }
        response.sendRedirect(request.getContextPath() + "/SingleProduct");
    }
}
