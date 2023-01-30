package com.nextgenpos.nextgenpos.servlets;
import com.nextgenpos.nextgenpos.common.ProductPhotoDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductPhotos", value = "/ProductPhotos")

public class ProductPhotos extends HttpServlet {
    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        ProductPhotoDto photo = productsBean.findPhotoByProductId(productId);
        if(photo != null){
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Error 404
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
