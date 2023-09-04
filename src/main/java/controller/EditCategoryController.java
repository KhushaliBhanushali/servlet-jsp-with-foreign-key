package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDaoImpl;
import model.Category;


@WebServlet(name="EditCategoryController", value = "/edit_category")
@MultipartConfig
public class EditCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryDaoImpl dao = new CategoryDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = null;
		try {
			existingCategory = dao.getCategoryById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/admin/category_edit.jsp");
        request.setAttribute("category", existingCategory);
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        String old_image = request.getParameter("old_image");
	        String fileName = old_image;
	        
			// Uploading our selected image into the images folder
			System.out.println(request.getPart("image"));
			
			try
			{
				 String fileTime = new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date());
				Part p = request.getPart("image");
				if(p.getSubmittedFileName() != "") {
					fileName = p.getSubmittedFileName();
					fileName = fileTime + fileName;
					
					//String path = getServletContext().getRealPath("") + "images";
				String path = "D:/eclipse-workspace/Category_demo/src/main/webapp/static/images/category/" + fileName;
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
	        //String image = request.getParameter("image");


	        Category category = new Category(id, name, description,fileName);
	        try {
				dao.updateCategory(category);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        response.sendRedirect("category");
	}

}
