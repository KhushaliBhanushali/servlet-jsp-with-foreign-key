package dao;

import java.sql.SQLException;
import java.util.List;

import model.Category;


public interface CategoryDAO {
	
	public List<Category> listAllCategory() throws SQLException;
    public Category getCategoryById(int id) throws SQLException;
    public boolean insertCategory(Category c1) throws SQLException;
    public boolean updateCategory(Category c1) throws SQLException;
    public boolean deleteCategory(int id) throws SQLException;

}
