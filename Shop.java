/**
 * The Shop is the central back end class, calling the various other classes and their methods.
 * The class inventory and SupplyList hold the lists for items and suppliers respectively, and are connected here.
 * These classes are called from here and return the strings which are printed in the FrontEnd. 
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 */
public class Shop {
private Inventory inv;
private SupplyList supList;

public Shop(Inventory inv, SupplyList supList) {
	super();
	this.inv = inv;
	this.supList = supList;
}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	public SupplyList getSupList() {
		return supList;
	}
	public void setSupList(SupplyList supList) {
		this.supList = supList;
	}
	
	/**
	 * Calls the inventory to print all items.
	 */
	public void listAllItems() {
		inv.printInventory();
	}
	/**
	 * Calls manageItem in class inventory and returns the string to be printed on the FrontEnd.
	 * if a item is found it returns that the item has been decreased, otherwise it says the item could not be decresed.
	 * @param name the name of the item that should be decreased in quantity
	 * @return a string which says whether the items quantity was decreased or not
	 */
	public String decreaseItemQuantity(String name) {
		
		if(inv.manageItem(name)==null)
			return "Could not decrease item quantity";
		else
			return "Item quantity of "+name+" has been decreased";
	}
	/**
	 * Calls the class supList to print all suppliers.
	 */
	public void listAllSupplier() {
		supList.listAllSuppliers();
	}
	/**
	 * Calls inventory to print all current orders.
	 * Works when an item is decreased, then the method is called to print an order.
	 * @return a String with all the orders or that there are no orders
	 */
	public String printOrder() {
		String s = inv.printOrder();
		if(s.equals(null))
			return "no orders at the moment";
		else
			return s ;
	}
	/**
	 * Calls method searchItemByName in inventory to find the item and sends back the item.
	 * @param name the name of the item to be searched for
	 * @return a String which holds the item information of the item searched for
	 */
	public String getItemByName(String name) {
		Item s = null;
		s = inv.searchForItem(name);
		String temp = "";
		
		if(s!= null) {
			temp = "| Item ID: "+s.getItemId()+"| Item name: "+ s.getItemName()+"| Item Quantity: "+ s.getItemQuantity()+"| Item price: "+ s.getItemPrice()+"| Supplier id: "+ s.getSupplierId();
			return temp;
		}
		else {
			temp = "Sorry "+name+" is not in the inventory.";
			return  temp;
		}
		
	}
	/**
	 * Calls method searchItemByName in inventory to find the item and sends back the item.
	 * @param id the id of the item to be searched for
	 * @return a String which holds the item information of the item searched for
	 */
	public String getItemById(int id) {
		Item s = null;
		s = inv.searchForItem(id);
		String temp = "";
		
		if(s!= null) {
			temp = "| Item ID: "+s.getItemId()+"| Item name: "+ s.getItemName()+"| Item Quantity: "+ s.getItemQuantity()+"| Item price: "+ s.getItemPrice()+"| Supplier id: "+ s.getSupplierId();
			return temp;
		}
		else {
			temp = "Sorry id number "+id+" is not in the inventory.";
			return  temp;
	}
	}
	/**
	 * This method also uses the inventory search method and returns the current quantity of the named item.
	 * @param name a String of the name of the item to be searched for inside inventory
	 * @return a String which says whether the item was found with its current quantity or if it is not within the inventory
	 */
	public String getItemQuantity(String name) {
		Item s = null;
		s = inv.searchForItem(name);
		String temp = "";
		
		if(s!= null) {
			temp =  name+" has the item Quantity: "+ s.getItemQuantity();
			return temp;
		}
		else {
			temp = "Sorry "+name+" is not in the inventory.";
			return  temp;
		}
	}
	
	
}
