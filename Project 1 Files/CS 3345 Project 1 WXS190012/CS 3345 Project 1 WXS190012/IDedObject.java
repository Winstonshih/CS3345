package cs3345;
/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 2/23/2025
 * The IDedObject interface is a blueprint of the methods that will be used in 
 * ProductSinglyLinkedList class.
 */
public interface IDedObject {
	/**
	 * getID returns the ID of Product and the Product Name
	 * @return productID
	 */
	public int getID();
	/**
	 * printID prints the Product ID and the Product Name and Supplier Name associated with it.
	 */
	public void printID();
}
