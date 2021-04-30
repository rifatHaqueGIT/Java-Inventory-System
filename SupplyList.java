import java.util.ArrayList;
/**
 * This class holds an arrayList of type Supplier.
 * This allows for the manipulation of suppliers from multiple classes.
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 *
 */
public class SupplyList {
	private ArrayList<Supplier> suppliers;
	
	
	public SupplyList(ArrayList<Supplier> mySuppliers) {
		this.setSuppliers(mySuppliers);
	}


	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}


	public void listAllSuppliers() {
		System.out.println(suppliers);		
	}

}
