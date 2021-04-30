import java.util.ArrayList;
/**
 * This class holds methods which manipulate and use the ArrayList of items.
 *	These methods are specifically tailored to change and send the information of individual items to the Shop class,
 *	and also creates orders as item quantities are reduced.
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 */
public class Inventory {
private ArrayList<Item> items;
private Order myOrder;

	public Inventory(ArrayList<Item> myItems) {
		this.items = myItems;
		myOrder = new Order();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Order getMyOrder() {
		return myOrder;
	}

	public void setMyOrder(Order myOrder) {
		this.myOrder = myOrder;
	}
/**
 * Calls decreaseItem to lower the quantity of the named item.
 * This method also places an order for the decreased item.
 * @param name a String which represents an item
 * @return the Item in inventory with the reduced quantity
 */
	public Item manageItem(String name) {
		
		Item theItem = decreaseItem(name);
		
		if(theItem != null)
			placeOrder(theItem);
		
		return theItem;
	}
/**
 * PlaceOrder creates a orderLine which is then added to the order list.
 * This is done only if order(variable) is not null.
 * @param theItem an object of type Item 
 */
	private void placeOrder(Item theItem) {
		OrderLines order = theItem.generateOrderLine();
		if(order != null) {
			myOrder.addOrderLine(order);
		}
		
	}
/**
 * Searches for the item, and decreases its value.
 * If it is not found a null is returned, otherwise it is decreased, and theItem is returned
 * @param name a String of an Item
 * @return an object of type Item
 */
	private Item decreaseItem(String name) {
		Item theItem = searchForItem(name);
		if(theItem == null)
			return null;
		if(theItem.decreaseItemQuantity() == true ) {
			return theItem;
		}
		else
			return null;
		
	}
/**
 * This method searches for the item sharing the same name as the String sent to it.
 * This method looks through the item list and compares the names of the the Strings, and returns
 * the Item that it matches, or returns null if the item was not found.
 * @param name a String which is used to search for an item
 * @return an object of type Item sharing the description of the parameter 
 */
	public Item searchForItem(String name) {
		Item theItem = null;
		for(int i = 0; i < items.size();i++)
		{
			if(name.equals (items.get(i).getItemName())) {
				theItem = items.get(i);
				break;
			}
				
		}
		if(theItem != null)
			return theItem;
		else
			return null;
	}
	/**
	 * This method is an overloaded version of the method sharing the same name, but uses the parameter id.
	 * @param id an integer which is used to search for an item sharing the same id within the list
	 * @return an object of type item that shares the same id as the parameter
	 */
	public Item searchForItem(int id) {
		Item theItem = null;
		for(int i = 0; i < items.size();i++)
		{
			if(id == items.get(i).getItemId()) {
				theItem = items.get(i);
				break;
			}
				
		}
		if(theItem != null)
			return theItem;
		else
			return null;
	}
/**
 * Calls method printItem within class Item and prints all the item within the ArrayList item. 
 */
	public void printInventory() {
		for(int i = 0; i < items.size(); i++) {
			items.get(i).printItem();
		}
		
	}
/**
 * This method prints the orders amassed through the running of the program.
 * This method only works after the decreaseQuantity method is used, making it
 * less dynamic then it should be. This fault occurs because the items are not
 * checked before they are placed into the list, thus items that were originally 
 * below stock do not produce an order. This can be seen with items like Wing Bats
 * which is originally below 20(the limit to place an order) and Wedges.
 * @return A string with all current orders within
 */
	public String printOrder() {
		if(myOrder.getTheOrders() != null) {
		OrderLines order = null;
		String s ="*******************************************************";
		for(int i = 0; i < myOrder.getTheOrders().size();i++ ) {
			order = myOrder.getOrderLines(i);
			s+=("\nOrder Id:               "+"0000"+i+
				"\nDate Ordered            "+order.getToday()+
				"\n\nItem Description:     "+order.getLeItem().getItemName()+
				"\nAmount Ordered:         "+ order.getOrderQuantity()+
				"\nSupplier:                 "+ order.getLeItem().getSupplier().getSupplierName()+
				"\n***********************************************************\n");
		}
		return s;
		}
		else 
			return null;
	}

	

}
