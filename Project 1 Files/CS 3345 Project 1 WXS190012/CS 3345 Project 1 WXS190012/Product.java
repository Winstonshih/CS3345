package cs3345;
/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 2/23/2025
 * The Product Java class implements IDedObject interface and defines productID, productName, 
 * and supplierName and its setter, getter, and print methods.
 */
public class Product implements IDedObject{
	private int productID;
	private String productName;
	private String supplierName;
	/**
	 * The no-args constructor of the Product class defines productID to a default value of 0 
	 * and productName and supplierName to default value of "".
	 */
	public Product()
	{
		this.productID=0;
		this.productName="";
		this.supplierName="";
	}
	/**
	 * Product class' parameterized constructor that sets productID to value of parameter p 
	 * and sets value of productName and supplierName to an empty string.
	 * @param p product's ID
	 */
	public Product(int p)
	{
		this.productID=p;
		this.productName="";
		this.supplierName="";
	}
	/**
	 * Product class' parameterized constructor that sets productID to value of parameter p,
	 * sets productName to value of parameter n, and sets value of supplierName to an empty string.
	 * @param p product ID
	 * @param n product name
	 */
	public Product(int p, String n)
	{
		this.productID=p;
		this.productName=n;
		this.supplierName="";
	}
	/**
	 * Product class' parameterized constructor that sets productID to value of parameter p,
	 * sets productName to value of parameter n, and sets supplierName to s.
	 * @param p product ID
	 * @param n product name
	 * @param s supplier name
	 */
	public Product(int p, String n,String s)
	{
		productID=p;
		productName=n;
		supplierName=s;
	}
	/**
	 * getID returns the product ID.
	 * @return productID ID of product
	 */
	public int getID()
	{
		return this.productID;
	}
	/**
	 * printID prints all contents associated with a productID (productID, productName, and supplierName).
	 */
	public void printID()
	{
		System.out.println("     "+getID());
		printProductName();
		printSupplierName();
	}
	/**
	 * setID sets productID to value of parameter productID.
	 * @param productID ID of product
	 */
	public void setID(int productID)
	{
		this.productID=productID;
	}
	/**
	 * getProductName returns name of product.
	 * @return productName name of product
	 */
	public String getProductName()
	{
		return this.productName;
	}
	/**
	 * printProductName prints out the name of product.
	 */
	public void printProductName()
	{
		System.out.println("     "+this.productName);
	}
	/**
	 * Sets productName's value to value passed by the productName parameter.
	 * @param productName Name of the product.
	 */
	public void setProductName(String productName)
	{
		this.productName=productName;
	}
	/**
	 * getSupplierName gets the name of the product's supplier.
	 * @return supplierName Name of the product supplier.
	 */
	public String getSupplierName()
	{
		return this.supplierName;
	}
	/**
	 * This void method prints out the name of supplier of the specified product.
	 */
	public void printSupplierName()
	{
		System.out.println("     "+this.supplierName);
	}
	/**
	 * This void sets supplierName to value passed through supplierName parameter.
	 * @param supplierName Name of supplier of product.
	 */
	public void setSupplierName(String supplierName)
	{
		this.supplierName=supplierName;
	}
}
