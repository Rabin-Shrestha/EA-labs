package cs544.exercise5_1;

public class InventoryService implements IInventoryService {

	@Override
	public int getNumberInStock(int productNumber) {
		// TODO Auto-generated method stub
		return productNumber-200;
	}

}
