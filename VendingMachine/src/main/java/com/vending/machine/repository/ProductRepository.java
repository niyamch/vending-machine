package com.vending.machine.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vending.machine.domain.Product;
import com.vending.machine.util.Constants;

@Repository
public class ProductRepository {
	private List<Product> products;
	
	public ProductRepository() {
		setInitialData();
	}

	public void setInitialData() {
		products = List.of(new Product("cola", 100, 7), new Product("croissant", 120, 6), new Product("lollypop", 40, 2),
				new Product("waffle", 70, 10), new Product("energy drink", 160, 8));
	}
	
	public Product getProductByName(String productName) {
		if (!products.stream().anyMatch(product -> product.getName().equals(productName.toLowerCase()))) {
			return null;
		}
		
		return products.stream().filter(filterProduct -> filterProduct.getName().equals(productName))
				.findFirst().get();
	}

	public String buyProductAndGetMessage(Product product) {
		if (!hasStock(product)) {
			return Constants.PRODUCT_OUT_OF_STOCK;
		} else {
			product.setQuantity(product.getQuantity() - 1);
			return Constants.ENJOY + Constants.SPACE + product.getName() + Constants.EXCLAMATION_MARK;
		}
	}
	
	public boolean hasStock(Product product) {
		if (product.getQuantity() <= 0) {
			return false;
		}
		
		return true;
	}
}
