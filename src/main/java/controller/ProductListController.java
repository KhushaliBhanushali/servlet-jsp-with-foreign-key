package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDaoImpl;
import model.Product;
import model.ProductDTO;


@WebServlet(name="/ProductListController", value="/product")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ProductDaoImpl dao = new ProductDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<ProductDTO> list = null;
		try {
			list = dao.listAllProducts();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	        request.setAttribute("listProduct", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/admin/product_list.jsp");
	        dispatcher.forward(request, response);
	        
	}

	
	

}
