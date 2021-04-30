import java.util.ArrayList;
/**
 * This class holds an array with all the current orders, and adds new orders.
 *  @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 *
 */
public class Order {
	private ArrayList<OrderLines> theOrders;
	
	public Order() {
		theOrders = new ArrayList<OrderLines>();
	}

	public ArrayList<OrderLines> getTheOrders() {
		return theOrders;
	}

	public void setTheOrders(ArrayList<OrderLines> theOrders) {
		this.theOrders = theOrders;
	}

	public OrderLines getOrderLines(int i) {
		return theOrders.get(i);
	}
	
	public void addOrderLine(OrderLines order)
	{
		theOrders.add(order);
		
	} 
	
	
	
}
