/**
 * The class item holds the various variables which describe a single item.
 * It also calls on the class orderLines if an item hold below the MINIMUNORDERNUMBER.
 * This can only happen once per a item as the class also holds a boolean variable
 * alreadyOrdered, which prevents multiple orders.
 *  @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 *
 */

public class Item {
	
	private int itemId;
	private String itemName;
	private int itemQuantity;
	private double itemPrice;
	private int supplierId;
	private Supplier supplier;
	private boolean alreadyOrdered;
	private static final int ORDERQUANTITY = 50;
	private static final int MINIMUMORDERNUMBER = 20;
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
		setSupplierId(supplier.getSupplierId());
		
	}
	public Item() {	}
	
	public Item(int itemId, String itemName, int itemQuantity, double itemPrice, Supplier supplier) {
		setItemId(itemId);
		setItemName(itemName);
		setItemQuantity(itemQuantity);
		setItemPrice(itemPrice);
		setSupplier(supplier);
	}
	/**
	 * This method decreases the quantity if the current quantity of the item is not zero.
	 * It also returns true if decreased and false if it cannot be decreased of if the items not within the list.
	 * @return true if quantity is decreased and false if it is not decreased
	 */
	public boolean decreaseItemQuantity() {
		if(itemQuantity > 0) {
			itemQuantity--;
			return true;
		}
		else
			return false;
	}
	/**
	 * Creates the order for an item if the item is below the minimum stock quantity.
	 * This method does not allow for multiple orders as it checks if the item has already 
	 * had an order placed under its name.
	 * @return the order or null if an order is not made
	 */
	public OrderLines generateOrderLine() {
		OrderLines o1;
		if(getItemQuantity() < MINIMUMORDERNUMBER && alreadyOrdered == false) {
			o1 = new OrderLines (this, (ORDERQUANTITY-itemQuantity));
			alreadyOrdered = true;
			return o1;
		}
		return null;
	}
	
	/**
	 * Prints the individual Item and all its information.
	 * This includes its id, name,quantity,price,and matching supplierId.
	 */
	public void printItem() {
		System.out.println("| Item ID: "+itemId+"| Item name: "+ itemName+"| Item Quantity: "+ itemQuantity+"| Item price: "+ itemPrice+"| Supplier id: "+ supplierId);
		
	}
	
	
	
}
