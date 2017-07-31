package cs544.exercise5_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
	public static void main(String[] args){
		//IProductService productService = new ProductService();

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		IProductService productService =context.getBean("productService", IProductService.class);
		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}
		
		System.out.println("we have "+productService.getNumberInStock(423)+" products with productNumber 423 in stock");
		System.out.println("we have "+productService.getNumberInStock(239)+" products with productNumber 239 in stock");
	}
}
