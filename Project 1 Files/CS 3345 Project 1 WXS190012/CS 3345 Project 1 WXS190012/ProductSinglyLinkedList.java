package cs3345;
/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 2/23/2025
 * ProductSinglyLinkedList is the singly linked list class that will store nodes
 * about a Product's name, supplier name, and ID.
 */
public class ProductSinglyLinkedList<T extends IDedObject>{
	private ProductSinglyNode<T> head;
	/**
	 * No-args constructor that creates an empty linked list by setting head to null.
	 */
	public ProductSinglyLinkedList()
	{
		this.head=null;
	}
	/**
	 * makeEmpty deletes all nodes in singly linked list.
	 */
	public void makeEmpty() {
		this.head= null;
	}
	/**
	 * findID traverses singly linked list to look for node with productID that matches the parameter ID
	 * and returns the data of the node if IDs match.
	 * @param ID the ID of product the method will look for.
	 * @return head.data if node is found.
	 * @return null if node is not found.
	 */
	public T findID(int ID) {
		for(ProductSinglyNode<T> n=head;n!=null;n=n.next)
		{
			if(n.data.getID()==ID)
			{
				return n.data;
			}
		}
		return null;
	}
	/**
	 * insertAtFront inserts node at front of singly linked list if node does not appear in list.
	 * @param x node that will be inserted in the front.
	 * @return false if node is already in singly linked list.
	 * @return true if node is inserted to front of list.
	 */
	public boolean insertAtFront(T x) {
		for(ProductSinglyNode<T> curr=head; curr!=null;curr=curr.next)
		{
			if(curr.data.getID()==x.getID())
			{
				return false;
			}
		}
		ProductSinglyNode<T> node2=new ProductSinglyNode<T>(x);
		node2.next=head;
		head=node2;
		return true;
	}
	/**
	 * deleteFromFront deletes the first node in singly linked list.
	 * @return null if linked list is empty.
	 * @return del if linked list is not empty.
	 */
	public T deleteFromFront() {
		if(head==null)//Checks to see if Linked List is empty.
		{
			return null;
		}
		T del=head.data;
		head=head.next;
		return del;
	}
	/**
	 * delete method deletes node from Product Singly Linked List by traversing it from start to end.
	 * @param ID the productID of the node that needs to be deleted.
	 * @return null if linked list is empty or ID can not be found.
	 * @return del if method finds the node at specified ID.
	 */
	public T delete(int ID) {
		ProductSinglyNode<T> prev=null;
		ProductSinglyNode<T> curr;
		T del;
		if(head==null)//Checks to see if linked list is empty.
		{
			//return null;
		}
		if(head.data.getID()==ID)//Checks to see if first linked node's ID matches the ID in parameter.
		{
			del=head.data;
			head=head.next;
			return del;
		}
		for(curr=head;curr!=null;curr=curr.next)
		{
			if(curr.data.getID()==ID)//Returns deleted node if ID matches.
			{
				del=curr.data;
				prev.next=curr.next;
				return del;
			}
			prev=curr;
		}
		return null;//Returns null if ID is not found after traversing entire list.
	}
	/**
	 * printAllRecords prints all Product nodes' product name, product id, and supplier name.
	 */
	public void printAllRecords() {
		if(head==null) //If linked list is empty.
		{
			System.out.println("     Singly linked list is empty.");
		}
		for(ProductSinglyNode<T> curr=head;curr!=null;curr=curr.next)
		{
			curr.data.printID();
		}
	} 	 
}
