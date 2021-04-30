import java.util.ArrayList;
/**
 * This class holds the general information of the supplier.
 * Also holds a list of all matching items that the supplier provides
 * @author Rifat haque
 * @version 1.0
 * @since February 16, 2020
 *
 */
public class Supplier {
	private int supplierId;
	private String supplierName;
	private String address;
	private String contact;
	private ArrayList <Item> items;
	
	
	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}

	public Supplier(int supplierId, String supplierName, String address, String contact) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.address = address;
		this.contact = contact;
		items = new ArrayList<Item>();
	}

	public void setItemList(Item myItem) {
		items.add( myItem);
	}
	public ArrayList<Item> getItemList() {
		return items;
	}

}
