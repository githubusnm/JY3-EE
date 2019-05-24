package com.neuedu.controller;

import com.neuedu.dao.ProductDAO;
import com.neuedu.entity.Product;
import com.neuedu.impl.ProductDAOImpl;
import com.neuedu.utils.Utils;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@MultipartConfig
@WebServlet(name = "addPriductServlet",urlPatterns = "/addproduct.do")
public class addPriductServlet extends HttpServlet {

    private ProductDAO pd;

    @Override
    public void init() throws ServletException {
        pd = new ProductDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pro_name = request.getParameter("pro_name");
        String pro_price = request.getParameter("pro_price");
        Part pro_img = request.getPart("pro_img");
        String pro_des = request.getParameter("pro_des");
        String pro_stock = request.getParameter("pro_stock");
        String pro_date = request.getParameter("pro_date");
        String pro_category_id = request.getParameter("pro_category_id");
        String pro_factory = request.getParameter("pro_factory");
        Product product = new Product(Utils.getRandomId(),pro_name, Double.parseDouble(pro_price),
                Utils.getFilename(pro_img),pro_des,Integer.parseInt(pro_stock),
                Utils.getDate(pro_date),Integer.parseInt(pro_category_id),pro_factory);
        pd.insert(product);
        response.sendRedirect("select.jsp");
    }
}
