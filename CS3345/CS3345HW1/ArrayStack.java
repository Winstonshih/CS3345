/**
 * Name: Winston Shih
 * Net ID: WXS190012
 * Date: 9/20/2024
 * Section: CS 3345.002
 */
import java.util.EmptyStackException;
/**
 * ArrayStack class provides an array-based implementation of BK Stack class.
 */
public class ArrayStack implements BKStack{
	private int top;
	private static final int INITIAL_CAPACITY=10;
	private double[] stack;
	/**
	 * This is the no-arguments constructor method of ArrayStack class that sets top to -1 and instantiates stack array with a capacity of 10.
	 */
	public ArrayStack()
	{
		top=-1;
		stack=new double[INITIAL_CAPACITY];
	}
	/**
	 * Method checks to see if array stack is empty by checking if top's index value is still equal to -1.
	 * @return boolean value for if array stack is empty.
	 */
	public boolean isEmpty()
	{
		return (top==-1);
	}
	/**
	 * Method returns number of elements in array stack. It increments current top value by 1 since top started at index -1.
	 * @return count of number of elements in array stack.
	 */
	public int count()
	{
		return (top+1);
	}
	/**
	 * This method removes and returns the last element in array stack after checking if array stack is empty.
	 * @return stack[top--] last element popped from the array stack.
	 * @throws EmptyStackException if array stack is empty.
	 */
	public double pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return stack[top--];
	}
	/**
	 * Method pushes element from parameter to top of an array stack, resizes array if array reaches max capacity, and returns the length of array stack.
	 * @param d element that is added to top of array stack.
	 */
	public void push(double d)
	{
		if(top==stack.length-1)
		{
			resize();
		}
		stack[++top]=d;
	}
	/**
	 * Method retrieves the top element in stack after checking to see if stack is empty.
	 * @return stack[top] Top element in stack.
	 * @throws EmptyStackException if array stack is empty
	 */
	public double peek()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return stack[top];
	}
	/**
	 * Method resizes array stack by a factor of 2 and copies the original array stack's elements into new array stack.
	 */
	private void resize()
	{
		double[] stack2=new double[stack.length*2];
		for(int i=0;i<stack.length;i++)
		{
			stack2[i]=stack[i];
		}
		stack=stack2;
	}
}
