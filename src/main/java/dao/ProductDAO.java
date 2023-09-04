package dao;

import java.sql.SQLException;
import java.util.List;

import model.Product;
import model.ProductDTO;

public interface ProductDAO {
	
	public List<ProductDTO> listAllProducts() throws SQLException;
    public ProductDTO getProductById(int product_id) throws SQLException;
    public boolean insertProduct(Product p1) throws SQLException;
    public boolean updateProduct(Product p1) throws SQLException;
    public boolean deleteProduct(int product_id) throws SQLException;
}
