package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbHelper1;
import model.Category;
import model.Product;
import model.ProductDTO;

public class ProductDaoImpl  implements ProductDAO{

	Connection jdbcConnection = null;
	CategoryDaoImpl dao = new CategoryDaoImpl();

	@Override
	public List<ProductDTO> listAllProducts() throws SQLException {

        List<ProductDTO> listProduct = new ArrayList<>();
        String sql = "select * from product";
        jdbcConnection = new DbHelper1().getConnection();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int product_id = resultSet.getInt("product_id");
            String name = resultSet.getString("name");
            float price = resultSet.getFloat("price");
            Date entry_date = resultSet.getDate("entry_date");
            boolean status = resultSet.getBoolean("status");
            //int category_id = resultSet.getInt("category_id");
            Category category = dao.getCategoryById(resultSet.getInt("category_id"));
            String image = resultSet.getString("image");

            ProductDTO product = new ProductDTO(product_id,name,price,entry_date,status,category,image);
            listProduct.add(product);
        }
        resultSet.close();
        statement.close();
        //disconnect();
        return listProduct;
    }

    @Override
    public ProductDTO getProductById(int product_id) throws SQLException {
    	ProductDTO product = new ProductDTO();
        String sql = "select * from product where product_id=?";
        jdbcConnection = new DbHelper1().getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, product_id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
        	
            String name = resultSet.getString("name");
            float price = resultSet.getFloat("price");
            Date entry_date = resultSet.getDate("entry_date");
            boolean status = resultSet.getBoolean("status");
            //int category_id = resultSet.getInt("category_id");
            Category category = dao.getCategoryById(resultSet.getInt("category_id"));
            String image = resultSet.getString("image");

           product = new ProductDTO(product_id, name,price,entry_date,status,category,image);
        }
        resultSet.close();
        statement.close();
        //disconnect();
        return product;
    }

    @Override
    public boolean insertProduct(Product p1) throws SQLException {
        String sql = "insert into product (name,price,status,category_id,image) values (?,?,?,?,?)";
        jdbcConnection = new DbHelper1().getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, p1.getName());
        statement.setFloat(2,p1.getPrice());
       // statement.setDate(3, (Date) p1.getEntry_date());
        statement.setBoolean(3,p1.isStatus());
        //statement.setInt(4, p1.getCategory_id());
        statement.setInt(4, p1.getCategory_id());
        statement.setString(5,p1.getImage());

        boolean b = statement.executeUpdate() > 0;
        statement.close();
        //disconnect();
        return b;

    }

    @Override
    public boolean updateProduct(Product p1) throws SQLException {

        String sql = "update product set name=?, price=?, status=?, category_id=?, image=? where product_id=?";

        jdbcConnection = new DbHelper1().getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, p1.getName());
        statement.setFloat(2,p1.getPrice());
       // statement.setDate(3, (Date) p1.getEntry_date());
        statement.setBoolean(3,p1.isStatus());
       // statement.setInt(4, p1.getCategory_id());
        statement.setInt(4, p1.getCategory_id());
        statement.setString(5,p1.getImage());
        statement.setInt(6,p1.getProduct_id());

        boolean b = statement.executeUpdate() > 0;
        statement.close();
        //disconnect();
        return b;
    }

    @Override
    public boolean deleteProduct(int product_id) throws SQLException {
        String sql = "delete from product where product_id=?";
       // connect();
        jdbcConnection = new DbHelper1().getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1,product_id);

        boolean b = statement.executeUpdate() > 0;
        statement.close();
        //disconnect();
        return b;
    }

}
