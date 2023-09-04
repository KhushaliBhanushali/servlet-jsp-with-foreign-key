package model;

import java.util.Date;

public class ProductDTO {
	
	private  int product_id;
    private String name;
    private Float price;
    private Date entry_date;
    private boolean status;
    private Category category;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ProductDTO() {
		super();
	}
	public ProductDTO(int product_id, String name, Float price, Date entry_date, boolean status, Category category,
			String image) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.entry_date = entry_date;
		this.status = status;
		this.category = category;
		this.image = image;
	}
	public ProductDTO(int product_id, String name, Float price, boolean status, Category category, String image) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.category = category;
		this.image = image;
	}
	public ProductDTO(String name, Float price, boolean status, Category category, String image) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
		this.category = category;
		this.image = image;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", name=" + name + ", price=" + price + ", entry_date="
				+ entry_date + ", status=" + status + ", category=" + category + ", image=" + image + "]";
	}
    
    
}
