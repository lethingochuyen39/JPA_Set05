package com.aptech.student1318434.controllers;

import com.aptech.student1318434.services.ProductBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    @Inject
    ProductBean ProductBeanService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductBeanService = new ProductBean();
        req.setAttribute("productList", ProductBeanService.findAll());
        req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] values = req.getParameterValues("del");

            for (String id : values) {
                int ids = Integer.parseInt(id);
                ProductBeanService.deleteProduct(ids);
            }
            req.setAttribute("productList", ProductBeanService.findAll());
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getServletContext().getRequestDispatcher("/failed.jsp").include(req, resp);
        }
    }
}