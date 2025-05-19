package cs3345;
/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 2/23/2025
 * The ProductSinglyNode is the Node class for the Singly Linked List Class.
 */
public class ProductSinglyNode<T>{
	T data;
	ProductSinglyNode<T> next;
	/**
	 * Parameterized constructor that sets node data to parameter value of d and next node 
	 * to parameter value of n.
	 * @param d node data
	 * @param n next node
	 */
	public ProductSinglyNode(T d, ProductSinglyNode<T> n)
	{
		this.data=d;
		this.next=n;
	}
	/**
	 * ProductSinglyNode class' no-args constructor that sets node data and next node to null.
	 */
	public ProductSinglyNode()
	{
		this.data=null;
		this.next=null;
	}
	/**
	 * Parameterized constructor of ProductSinglyNode class that sets data to parameter value of d
	 * and sets next node to null.
	 * @param d node data
	 */
	public ProductSinglyNode(T d)
	{
		this.data=d;
		this.next=null;
	}
	/**
	 * Parameterized constructor of ProductSinglyNode class that sets next node to parameter value of n
	 * and data to null.
	 * @param n next node
	 */
	public ProductSinglyNode(ProductSinglyNode<T> n)
	{
		this.data=null;
		this.next=n;
	}
	
}
