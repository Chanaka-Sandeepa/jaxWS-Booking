package com.chanaka.soapBooking.dao;

import java.util.List;
import com.chanaka.soapBooking.model.Product;

public interface ProductDAO {

	public boolean addProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public List<Product> searchProduct(String productName);
	
	public Product getProductById(int id);
	
	public List<Product> getAllProductByPrice(double price);
}
