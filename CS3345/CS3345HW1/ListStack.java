/**
 * Name: Winston Shih
 * Net ID: WXS190012
 * Date: 9/20/2024
 * Section: CS 3345.002
 */
import java.util.EmptyStackException;
/**
 * ListStack provides a Linked List implementation of BackMasking class, which is an implementation of Iterator interface.
 */
public class ListStack implements BKStack, Iterable<Double>{
	private int size;
	private int modCount=0;
	private ListStackNode begin;
	private ListStackNode end;
	private ListStackNode top;
	/**
	 * LinkedStackNode is the linked list node implementation for the List Stack class.
	 */
	private static class ListStackNode
	{
		private Double data;
		private ListStackNode previous;
		private ListStackNode next;
		/**
		 * This is a parameterized constructor for ListStackNode object if data, next node, and previous nodes are defined.
		 * @param d data of node.
		 * @param p previous node.
		 * @param n next node.
		 */
		public ListStackNode(Double d, ListStackNode p, ListStackNode n)
		{
			data=d;
			previous=p;
			next=n;
		}
		/**
		 * This is a parameterized constructor for ListStackNode object if data is only parameter that is defined.
		 * @param d data of node.
		 */
		public ListStackNode(Double d)
		{
			data=d;
			previous=null;
			next=null;
		}
	}
	/**
	 * This is a no arguments constructor for List Stack class that calls clear method to create a new linked list stack.
	 */
	public ListStack()
	{
		clear();
	}
	/**
	 * Clear method of ListStackNode class that sets instantiates begin and end nodes, links begin and end nodes together,sets size to 0, and increments modification 
	 * counter.
	 */
	public void clear()
	{
		begin=new ListStackNode(null,null,null);
		end=new ListStackNode(null,begin,null);
		begin.next=end;
		size=0;
		modCount++;
	}
	/**
	 * Method returns the size of Linked List Stack.
	 * @return size of Linked List Stack.
	 */
	public int size()
	{
		return size;
	}
	/**
	 * Method checks to see if Linked List Stack is empty.
	 * @return (top==null) boolean value for if Linked List Stack is empty.
	 */
	public boolean isEmpty()
	{
		return (top==null);
	}
	/**
	 * Method invokes void method called add and returns true after value is added to Linked List Stack.
	 * @param x double value to be added to List Stack.
	 * @return true after double value is added to Linked List Stack.
	 */
	public boolean add(Double x)
	{
		add(size(), x);
		return true;
	}
	/**
	 * Method invokes addBefore and getNode methods to add double value before a specified index.
	 * @param idx index that double value is added before.
	 * @param x double value that is added before an index in Linked List Stack.
	 */
	public void add(int idx, Double x)
	{
		addBefore(getNode(idx, 0, size()),x);
	}
	/**
	 * Method adds double object contained in Node p.
	 * @param p Node containing the double value.
	 * @param x double value that is added to Linked List Stack.
	 */
	private void addBefore(ListStackNode p, Double x)
	{
		ListStackNode nextNode=new ListStackNode(x, p.previous, p);
		nextNode.previous.next=nextNode;
		p.previous=nextNode;
		size++;
		modCount++;
	}
	/**
	 * Method creates a node at an index with a specified range of element indices through a recursive call.
	 * @param idx index of new node.
	 * @return a new node at idx that has a list of elements from index 0 to index of size of linked list stack minus one.
	 */
	private ListStackNode getNode(int idx)
	{
		return getNode(idx, 0, size()-1);
	}
	/**
	 * Method gets Node at idx that must be between index low and index high and checks to see if index is before or after midpoint of list stack to find the node
	 * more efficiently.
	 * @param idx index to search.
	 * @param low lowest index.
	 * @param up highest index.
	 * @return p internal node related to idx
	 * @throws IndexOutOfBoundsException if index is higher than last index or lower than first index (inclusive).
	 */
	private ListStackNode getNode(int idx, int low, int up)
	{
		ListStackNode p;
		if(idx>up||idx<low)
		{
			throw new IndexOutOfBoundsException();
		}
		if(idx<(size()/2))
		{
			p=begin.next;
			for(int i=0;i<idx;i++)
			{
				p=p.next;
			}
		}
		else
		{
			p=end;
			for(int i=size();i>idx;i--)
			{
				p=p.previous;
			}
		}
		return p;
	}
	/**
	 * This method removes a node from linked list stack by calling the Double remove(ListStackNode p) method.
	 * @param idx index of node that will be removed.
	 * @return data of the removed node.
	 */
	public Double remove(int idx)
	{
		return remove(getNode(idx));
	}
	/**
	 * Set method goes to index idx, change the value of the node to a new double value (newVal), and returns the node's old double value (oldVal).
	 * @param idx index of node whose value will be updated.
	 * @param newVal new double value of node.
	 * @return oldVal old double value of node.
	 */
	public Double set( int idx, Double newVal )
	{
		ListStackNode p = getNode(idx);
	    Double oldVal = p.data;
	    p.data = newVal;
	    return oldVal;
	}
	/**
	 * This method removes a node from Linked List Stack, decreases size of stack, increases modification counter by 1, and returns data of the removed node.
	 * @param p node that will be removed from Linked List Stack.
	 * @return p.data data of removed node
	 */
	public Double remove(ListStackNode p)
	{
		p.next.previous=p.previous;
		p.previous.next=p.next;
		size--;
		modCount++;
		return p.data;
	}
	/**
	 * This class returns an iterator for Double Values.
	 * @return new ListStackIterator instance of ListStackIterator class
	 */
	public java.util.Iterator<Double> iterator()
	{
		return new ListStackIterator();
	}
	/**
	 * List Stack's Iterator Class that implements java.util.Iterator<Double> class.
	 */
	private class ListStackIterator implements java.util.Iterator<Double>
	{
		private ListStackNode current=begin.next;
		private int expectedModCount=modCount;
		private boolean okToRemove=false;
		/**
		 * Method returns if there is another value in the linked list stack after the current node.
		 * @return boolean value for there is another value after current node.
		 */
		public boolean hasNext()
		{
			return (current!=end);
		}
		/**
		 * next checks if modification counter is correct, there is another node after current node to iterate, retrieves current node's data, moves the iterator to 
		 * next node, and flags the current node to be removed by the next remove method call.
		 * @return nextItem next node after current node.
		 * @throws ConcurrentModificationException if Modification counter is not equal to expected Modification counter.
		 * @throws NoSuchElementException if there is not another value after current node.
		 */
		public Double next()
		{
			if(modCount!=expectedModCount)
			{
				throw new java.util.ConcurrentModificationException();
			}
			if(!(hasNext()))
			{
				throw new java.util.NoSuchElementException();
			}
			Double nextItem=current.data;
			current=current.next;
			okToRemove=true;
			return nextItem;
		}
		/**
		 * Remove method checks to see if program's count of modifications matches expected count of modifications, remove operation was invoked only once, removes node
		 * before current node, increments expected count of modifications by 1, and resets okToRemove back to false.
		 * @throws ConcurrentModificationException if program's count of modifications does not equal expected count of modifications.
		 * @throws IllegalStateExpection if remove operation is invoked more than once.
		 */
		public void remove()
		{
			if(modCount!=expectedModCount)
			{
				throw new java.util.ConcurrentModificationException();
			}
			if(!okToRemove)
			{
				throw new IllegalStateException( );
			}
			ListStack.this.remove(current.previous);
			expectedModCount++;
			okToRemove = false;
		}
	}
	/**
	 * Uses enhanced for loop to count the number of non-null values in Linked List Stack and returns number of elements.
	 * @return nodeCount number of elements in Linked List Stack.
	 */
	public int count()
	{
		int nodeCount=0;
		ListStackNode current=top;
		for(Double data:this)
		{
			if(data!=null)
			{
				nodeCount++;
				current=current.next;
			}
		}
		return nodeCount;
	}
	/**
	 * Method creates a node, tests to see if stack is not empty, makes next pointer point to current top element, and updates top of stack with new stack element.
	 * @param d element that will be pushed to top of Linked List Stack.
	 */
	public void push(double d)
	{
		ListStackNode node=new ListStackNode(d);
		if(!(isEmpty()))
		{
			node.next=top;
		}
		top=node;
	}
	/**
	 * This method checks to see if Linked List Stack is empty before it removes and returns the last element of Linked List stack.
	 * @return data last element of Linked List Stack.
	 * @throws EmptyStackException if Linked List Stack is empty.
	 */
	public double pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		Double data=top.data;
		top=top.next;
		return data;
	}
	/**
	 * Checks to see if Linked List Stack is empty and returns 
	 * @return top.data if the stack is not empty.
	 * @throws EmptyStackException if Linked List Stack is empty.
	 */
	public double peek()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return top.data;
	}
}
