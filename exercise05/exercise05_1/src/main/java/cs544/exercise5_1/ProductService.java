package cs544.exercise5_1;

import java.util.ArrayList;
import java.util.Collection;

public class ProductService implements IProductService {
	private Collection<Product> productList = new ArrayList<Product>();
	private IInventoryService inventoryService;
	
	public ProductService() {
		productList.add(new Product(234, "LCD TV", 895.50));
		productList.add(new Product(239, "DVD player", 315.00));
		productList.add(new Product(423, "Plasma TV", 992.55));
	}

	public Product getProduct(int productNumber) {
		for (Product product : productList) {
			if (product.getProductNumber() == productNumber)
				return product;
		}
		return null;
	}

	@Override
	public int getNumberInStock(int productNumber) {
		// TODO Auto-generated method stub
		return inventoryService.getNumberInStock(productNumber);
	}

	public void setInventoryService(IInventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

}
