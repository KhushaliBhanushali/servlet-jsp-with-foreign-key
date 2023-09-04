package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import model.Category;
import model.Product;
import model.ProductDTO;


@WebServlet(name="/EditProductController", value="/edit_product")
@MultipartConfig
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDaoImpl dao = new ProductDaoImpl();
	CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> list = null;
		try {
			list = categoryDaoImpl.listAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        request.setAttribute("listCategory", list);  
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
	        ProductDTO existingProduct = null;
			try {
				existingProduct = dao.getProductById(product_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/admin/product_edit.jsp");
	        request.setAttribute("product", existingProduct);
	        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
        String name = request.getParameter("name");
        Float price = Float.parseFloat(request.getParameter("price"));
        //boolean status = Boolean.parseBoolean(request.getParameter("status")) ;
        boolean status = Integer.parseInt(request.getParameter("status"))>0 ;
        int category_id = Integer.parseInt(request.getParameter("category_id"));
       // Category category = categoryDao.getCategoryById(category_id);
       //String image = request.getParameter("image");
        
        String old_image = request.getParameter("old_image");
        String fileName = old_image;
        
		// Uploading our selected image into the images folder
		System.out.println(request.getPart("image"));
		
		try
		{
			Part p = request.getPart("image");
			if(p.getSubmittedFileName() != "") {
				fileName = p.getSubmittedFileName();
				
				//String path = getServletContext().getRealPath("") + "images";
			String path = "D:/eclipse-workspace/Category_demo/src/main/webapp/static/images/product/" + fileName;
			System.out.println("Upload Path : "+path);
			
		FileOutputStream fos=new FileOutputStream(path);
		InputStream is=p.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}


        Product product = new Product(product_id, name, price,status,category_id,fileName);
       
        try {
			dao.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("product");
	}

}
