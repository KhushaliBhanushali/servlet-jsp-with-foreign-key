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

import dao.CategoryDaoImpl;
import model.Category;

@WebServlet(name="CategoryListController", value = "/category")
public class CategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 CategoryDaoImpl dao = new CategoryDaoImpl();
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Category> list = null;
		try {
			list = dao.listAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        request.setAttribute("listCategory", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/admin/category_list2.jsp");
	        dispatcher.forward(request, response);
	}

	
}
