import java.io.Serializable;

public class Stock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double unitPrice;
	private int qty;
	private String importedDate;
	public Stock() {
		
	}
	public Stock(int id, String name, double unitPrice, int qty, String importedDate) {
		
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.importedDate = importedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImportedDate() {
		return importedDate;
	}
	public void setImportedDate(String importedDate) {
		this.importedDate = importedDate;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", qty=" + qty + ", importedDate="
				+ importedDate + "]";
	}
	
	
}
