package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbHelper1;
import model.Category;

public class CategoryDaoImpl implements CategoryDAO{
	
	Connection jdbcConnection = null;
   
	//DbHelper dbHelper = new DbHelper();
	@Override
	public List<Category> listAllCategory() throws SQLException {
		List<Category> listCategory = new ArrayList<>();
        String sql = "select * from category";
        jdbcConnection = new DbHelper1().getConnection();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String image = resultSet.getString("image");

            Category category = new Category(id,name,description,image);
            listCategory.add(category);
        }
        resultSet.close();
        statement.close();
       
        return listCategory;
	}

	@Override
	public Category getCategoryById(int id) throws SQLException {
		Category category = new Category();
        String sql = "select * from category where id=?";
        jdbcConnection = new DbHelper1().getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            String name= resultSet.getString("name");
            String description = resultSet.getString("description");
            String image = resultSet.getString("image");

            category = new Category(id,name,description,image);
        }
        resultSet.close();
        statement.close();
       // dbHelper.disconnect();
        return category;
	}

	@Override
	public boolean insertCategory(Category c1) throws SQLException {
		String sql = "insert into category (name,description,image) values (?,?,?)";
        
		jdbcConnection = new DbHelper1().getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, c1.getName());
        statement.setString(2, c1.getDescription());
        statement.setString(3, c1.getImage());

        boolean b = statement.executeUpdate() > 0;
        statement.close();
        //dbHelper.disconnect();
        return b;
	}

	@Override
	public boolean updateCategory(Category c1) throws SQLException {
		String sql = "update category set name=?,description=?,image=? where id=?";
		jdbcConnection = new DbHelper1().getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, c1.getName());
        statement.setString(2, c1.getDescription());
        statement.setString(3, c1.getImage());
        statement.setInt(4,c1.getId());

        boolean b = statement.executeUpdate() > 0;
        statement.close();
       // dbHelper.disconnect();
        return b;
	}

	@Override
	public boolean deleteCategory(int id) throws SQLException {
		 String sql = "delete from category where id=?";
		 // dbHelper.connect();
		 jdbcConnection = new DbHelper1().getConnection();
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1,id);

	        boolean b = statement.executeUpdate() > 0;
	        statement.close();
	       // dbHelper.disconnect();
	        return b;
	}

	
}
