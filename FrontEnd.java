import java.util.ArrayList;
import java.util.Scanner;
/**
 * FrontEnd is the applications interface creating class, which displays the options the user can choose.
 * These option manipulate and display the various attributes of the inventory and places orders for those items.
 * The class shop is the only connection FrontEnd has to the back end of the program.
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 *
 */
public class FrontEnd {
	private Shop theShop;
	private Scanner scan;
	FrontEnd () {
		FileManager file = new FileManager ();
		ArrayList<Supplier> suppliers = file.readSuppliers();
		ArrayList<Item> items = file.readItems();
		theShop = new Shop(new Inventory(items), new SupplyList(suppliers));
		scan = new Scanner(System.in);
	}
	/**
	 *    a method which generates the menu options for use in this application. through options 1-7,
	 *    the user can choose to list all tools, search for a tool by name or id, check a particular items quantity,
	 *    decrease a particular items quantity, print the orders to suppliers for the particular date, or quit the program.
	 */	
	private void printMenuChoices() {
		System.out.println("Please choose an option: ");
		System.out.println("<______________________> ");
		System.out.println("1. List all tools in inventory. ");
		System.out.println("2. Search for tool by name. ");
		System.out.println("3. Search for tool by id. ");
		System.out.println("4. Check item quantity.");
		System.out.println("5. Decrease item quantity. ");
		System.out.println("6. Print todays order.");
		System.out.println("7. Quit, like a degenerate ");
		System.out.println("<_______________________>");
		System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|");
		System.out.println("Pick options 1-7: ");
	}
	/**
	 * The menu is the logic which allows for the options to translate to choices in the program.
	 * This is done through a switch which works through using user inputs of numbers 1-7, and calls member functions to 
	 * do the specified task by the noted number.
	 */
	public void menu() {
		
		while(true) {
			printMenuChoices();
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1:
				theShop.listAllItems();
				break;
			case 2:
				searchByName();
				break;
			case 3:
				searchById();
				break;
			case 4:
				checkQuantity();
				break;
			case 5:
				decreaseItem();
				break;
			case 6:
				printOrder();
				break;
			case 7:
				System.out.println("\nOk, bye");
				return;
			default:
				System.out.println("\nInvalid Input, try again pleb\n");
				break;
		}
		}
		
		
	}
/**
 * Calls the decreaseItem method in Class theShop and prints whether the item was decreased or not.
 */
	private void decreaseItem() {
		String name = getItemName();
		System.out.println(theShop.decreaseItemQuantity(name));
//		while(true) {
//			System.out.println("would you like to search for another item? (yes or no)");
//			String s = scan.nextLine().toLowerCase();
//			if(s.equals("yes"))
//			name = getItemName();
//			System.out.println(theShop.decreaseItemQuantity(name));
//			if(s.equals("no"))
//				break;
//		}
//		
	}
/**
 * Calls the method of the same name in the Class theShop and prints the items current quantity.
 */
	private void checkQuantity() {
		String name = getItemName();
		System.out.println(theShop.getItemQuantity(name));
//		while(true) {
//			System.out.println("would you like to search for another item? (yes or no)");
//			String s = scan.nextLine().toLowerCase();
//			if(s.equals("yes"))
//			name = getItemName();
//			System.out.println(theShop.getItemByName(name));
//			if(s.equals("no"))
//				break;
//		}
//		
	}
	/**
	 * Calls the back end for the item with a similar ID and prints the item if found. 
	 * It returns a item not found message if not found.
	 */
	private void searchById() {
		int id = getItemId();
		System.out.println(theShop.getItemById(id));
//		while(true) {
//			System.out.println("would you like to search for another item? (yes or no)");
//			String s = scan.nextLine().toLowerCase();
//			if(s.equals("yes"))
//			id = getItemId();
//			System.out.println(theShop.getItemById(id));
//			if(s.equals("no"))
//				break;
//		}
	}
	/**
	 * Calls the back end to find an item that shares the same name.
	 * This method prints that item if found or prints that it couldn't be found.
	 */		
	private void searchByName() {
		String name = getItemName();
		System.out.println(theShop.getItemByName(name));
		
//		while(true) {
//			System.out.println("would you like to search for another item? (yes or no)");
//			String s = scan.nextLine().toLowerCase();
//			if(s.equals("yes"))
//			name = getItemName();
//			System.out.println(theShop.getItemByName(name));
//			if(s.equals("no"))
//				break;
//		}
//		
	}
	/**
	 * This method calls the back end to create and print the orders made so far.
	 * 
	 */
	private void printOrder() {
	System.out.println(theShop.printOrder());
	}
	
	/**
	 * Asks the user for the name of the item they would like to find.
	 * @return the name of the item 
	 */
	private String getItemName() {
		System.out.println("Please print the item name: ");
		String name = scan.nextLine();
		
		return name;
	
	}
	/**
	 * Asks the user for the Id they would like to find.
	 * @return the Id 
	 */
	private int getItemId() {
		System.out.println("Please print the item id: ");
		int id =Integer.parseInt(scan.nextLine());
		return id;
	}
	public static void main(String[] args) {
		FrontEnd fE = new FrontEnd();
		fE.menu();

	}

}
