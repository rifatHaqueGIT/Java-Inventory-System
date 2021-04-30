import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
/**
 * This class holds the individual item for order and the quantity to be ordered, and a String of the current date.
 * This method of finding and formating todays date was found at the website https://www.javatpoint.com/java-get-current-date.
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 *
 */
public class OrderLines {
	private Item leItem;
	private int orderQuantity;
	private String today;
	
	public OrderLines(Item item, int orderQuantity) {
		this.leItem = item;
		this.orderQuantity = orderQuantity;
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.setToday(date.format(now));
		
	}

	public OrderLines() {}

	public Item getLeItem() {
		return leItem;
	}

	public void setLeItem(Item leItem) {
		this.leItem = leItem;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
	
}
