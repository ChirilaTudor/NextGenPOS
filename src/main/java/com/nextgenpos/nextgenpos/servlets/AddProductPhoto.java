package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@MultipartConfig
@WebServlet(name = "AddProductPhoto", value = "/AddProductPhoto")
public class AddProductPhoto extends HttpServlet {

    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Long productId = Long.parseLong(request.getParameter("id"));
        Long productId = Long.parseLong("51");
        ProductDto product = productsBean.findById(productId);
        request.setAttribute("product", product);

        request.getRequestDispatcher("/WEB-INF/pages/addProductPhoto.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("product_id"));

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        productsBean.addPhotoToProduct(productId, fileName, fileType, fileContent);
        response.sendRedirect(request.getContextPath() + "/AddProductPhoto");
    }
}
