import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * As seen from Professor Moshirpour's video, this class centralizes all the text file importation in one place.
 * The files suppliers.txt and items.txt are imported and put into their respective classes, this
 * allows for easier and less intensive, as the files are imported in one place.
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 */
		
public class FileManager {
	ArrayList<Supplier> suppliers;
	
	FileManager() {}
	/**
	 * Reads the file supplier.txt and places it with in an ArrayList of type Supplier.
	 * @return a list of type Supplier
	 */
	ArrayList<Supplier> readSuppliers(){
		suppliers = new ArrayList<Supplier>();
		try {
			//my file path, not the same if in another directory.
			FileReader file  = new FileReader("C:\\Users\\rotte\\Desktop\\ENSF 409\\TheSqa\\src\\suppliers.txt");
			
			
			BufferedReader fi = new BufferedReader(file);
			String line = "";		
			while((line = fi.readLine()) != null) {
				String[] temp = line.split(";");
				
					Supplier mySupplier = new Supplier(Integer.parseInt(temp[0]),temp[1],
							(temp[2]),(temp[2]));
					suppliers.add(mySupplier);
				}
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
			
			return suppliers;
	}
	/**
	 * A method under FileManager which creates and returns a list
	 * of type Item. This list is filled with the values within the
	 * text file items.txt, and connects it with the supplier list.
	 * @return a list of type Item
	 */
			
	ArrayList<Item> readItems(){
		
	ArrayList<Item> items = new ArrayList<Item>();
	try {
		FileReader file  = new FileReader("C:\\Users\\rotte\\Desktop\\ENSF 409\\TheSqa\\src\\items.txt");
		
		
		BufferedReader fi = new BufferedReader(file);
		String line = "";		
		while((line = fi.readLine()) != null) {
			String[] temp = line.split(";");
			int supplierId = Integer.parseInt(temp[4]);
			Supplier theSupplier = findSupplier(supplierId);
			if(theSupplier != null) {
				Item myItem = new Item(Integer.parseInt(temp[0]),temp[1],Integer.parseInt(temp[2]),
						Double.parseDouble(temp[2]),theSupplier );
				items.add(myItem);
				theSupplier.getItemList().add(myItem);
				
				}
		
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
	}
	return items;
}
	/**
	 * Matches a supplier to its item.
	 * This allows for a supplier to remember its corresponding item and vice versa, allowing an item to only be added
	 * if the supplier information is already existent.
	 * @param supplierId an id of the supposed supplier
	 * @return theSupplier to the correspond item is returned or null
	 */
	private Supplier findSupplier(int supplierId) {
		Supplier theSupplier = null;
		for (Supplier s: suppliers) {
			if (s.getSupplierId()==supplierId) {
				theSupplier = s;
				break;
			}
		}
		return theSupplier;
	}
	
	
	
}
