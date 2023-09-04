package model;

import java.util.Date;

public class Product {
	
	private  int product_id;
    private String name;
    private Float price;
    private Date entry_date;
    private boolean status;
    private int category_id;
    private String image;
    
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product() {
		super();
	}
	public Product(int product_id) {
		super();
		this.product_id = product_id;
	}
	public Product(int product_id, String name, Float price, Date entry_date, boolean status, int category_id,
			String image) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.entry_date = entry_date;
		this.status = status;
		this.category_id = category_id;
		this.image = image;
	}
	public Product(String name, Float price, Date entry_date, boolean status, int category_id, String image) {
		super();
		this.name = name;
		this.price = price;
		this.entry_date = entry_date;
		this.status = status;
		this.category_id = category_id;
		this.image = image;
	}
	
	
	public Product(String name, Float price, boolean status, int category_id, String image) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
		this.category_id = category_id;
		this.image = image;
	}
	
	public Product(int product_id, String name, Float price, boolean status, int category_id, String image) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.category_id = category_id;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", price=" + price + ", entry_date="
				+ entry_date + ", status=" + status + ", category_id=" + category_id + ", image=" + image + "]";
	}
    
    
}
