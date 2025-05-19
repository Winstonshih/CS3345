//Java packages needed for Duration class methods and other methods.
import java.util.*;
import java.time.Duration;
/**
 * Winston Shih
 * CS 3345.002
 * 5/11/2025
 * This class defines the QuickSorter partition and pivot strategy methods to sort an unsorted array list. 
 */
public class QuickSorter {
	/**
	 * Public enumeration of the pivot strategies the program can implement.
	 */
	public enum PivotStrategy {
	    FIRST_ELEMENT,
	    RANDOM_ELEMENT,
	    MEDIAN_OF_THREE_RANDOM_ELEMENTS,
	    MEDIAN_OF_THREE_ELEMENTS
	}
	/**
	 * Generates a random array list of elements based on input for size.
	 * @param size size of ArrayList.
	 * @return Randomly selected ArrayList of elements.
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Integer> generateRandomList(int size) throws IllegalArgumentException
	{
		if(size<0)
		{
			throw new IllegalArgumentException("Invalid Array List!");
		}
		Random r=new Random();
		ArrayList<Integer> randList=new ArrayList<Integer>(size);
		for(int i=0;i<size;i++)
		{
			randList.add(r.nextInt());
		}
		return randList;
	}
	/**
	 * Sorts list using given pivot strategy and returns duration it takes to sort the array list in nanoseconds
	 * @param <E> Generic type that extends methods from Comparable class.
	 * @param list unsorted array list.
	 * @param pivotStrategy Pivot strategy to sort array list.
	 * @return endTime time in nanoseconds it took to sort array list with given pivot strategy.
	 * @throws NullPointerException if pivotStrategy or list is null.
	 */
	public static <E extends Comparable<E>> Duration timedQuickSort(ArrayList<E> list, PivotStrategy pivotStrategy) throws NullPointerException
	{
		if(pivotStrategy==null||list==null)
		{
			throw new NullPointerException("Null");
		}
		long startTime=System.nanoTime();
		quickSort(list, 0, list.size()-1,pivotStrategy);
		long endTime=System.nanoTime();
		endTime-=startTime;
		return Duration.ofNanos(endTime);
	}
	/**
	 * Private method that quick sorts unsorted array list based on pivotStrategy, first element, and last element.
	 * @param <E> Generic type that extends methods from Comparable class.
	 * @param list Unsorted array list.
	 * @param f first element.
	 * @param l last element.
	 * @param pivotStrategy Pivot Strategy used to sort array list.
	 */
	private static <E extends Comparable<E>> void quickSort(List<E> list, int f, int l, PivotStrategy pivotStrategy) {
        int pivot;
		if (f<l) {
            pivot=partition(list, f, l, pivotStrategy);
            quickSort(list, f, pivot-1, pivotStrategy);
            quickSort(list, pivot+1, l, pivotStrategy);
        }
    }
	/**
	 * Returns median of three elements.
	 * @param <E> Generic type that extends methods from Comparable class.
	 * @param list
	 * @param f first element.
	 * @param c center element.
	 * @param l last element.
	 * @return median index of the three elements
	 */
	 private static <E extends Comparable<E>> int medianOfThree(List<E> list, int f, int c, int l)
	{
        // Find median without swapping with l-1 (which could be out of bounds)
		if(list.get(c).compareTo(list.get(f))<0)
		{
			swap(list, f, c);
		}
		if(list.get(l).compareTo(list.get(f))<0)
		{
			swap(list, f, l);
		}
		if(list.get(l).compareTo(list.get(c))<0)
		{
			swap(list, c, l);
		}
		
		// Return the index of the median value (which is now at position c)
		return c;
	}
	 /**
	  * Swaps the first and second element in unsorted array list.
	  * @param <T> Generic type.
	  * @param list unsorted array list
	  * @param f first element.
	  * @param l second element.
	  */
	private static <E> void swap(List<E> list, int f, int l) {
        E temp = list.get(f);
        list.set(f,  list.get(l));
        list.set(l, temp);
    }
	/**
	 * Partitions the unsorted list and returns index of last partition.
	 * @param <E> Generic type that extends methods from Comparable class.
	 * @param list unsorted array list
	 * @param f first element.
	 * @param l last element.
	 * @param s Pivot Strategy that is chosen.
	 * @return finalPosition final partition index
	 */
	private static <E extends Comparable<E>> int partition(List<E> list,int f, int l, PivotStrategy s)
	{
		int pIndex=choosePivot(list, f, l, s);
		swap(list, f, pIndex);
		E pivot=list.get(f);
		int i=f+1;
		int j=f+1;
		while(j<=l)
		{
			if(list.get(j).compareTo(pivot)<0)
			{
				swap(list, i, j);
				i++;
			}
			j++;
		}
		int finalPosition=i-1;
		swap(list, f, finalPosition);
		return finalPosition;
	}
	/**
	 * Method to choose pivot strategy to sort array list.
	 * @param <E> Generic type that extends methods from Comparable class.
	 * @param list unsorted ArrayList
	 * @param f first element in unsorted ArrayList
	 * @param l last element in unsorted ArrayList
	 * @param s Pivot Strategy that is chosen.
	 * @return index of the chosen pivot
	 */
	private static <E extends Comparable<E>> int choosePivot(List<E> list, int f, int l, PivotStrategy s)
	{
		Random r=new Random();
		int rElem;
		int median3;
		int rmedian3;
		int c=(f+l)/2;
		// Returns first element if there are only 2 elements. 
		if (l - f < 2) {
		    return f; 
		}
		//Returns first element if the Pivot Strategy is FIRST_ELEMENT.
		if(s==PivotStrategy.FIRST_ELEMENT)
		{
			return f;
		}
		//Returns a random element if Pivot Strategy is RANDOM_ELEMENT
		else if(s==PivotStrategy.RANDOM_ELEMENT)
		{
			rElem=r.nextInt(l - f + 1) + f;
			return rElem;
		}
		//Returns median of three randomly selected elements.
		else if(s==PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS)
		{
			int r1 = f + r.nextInt(l-f+1);
            int r2 = f + r.nextInt(l-f+1);
            int r3 = f + r.nextInt(l-f+1);
            rmedian3=medianOfThree(list, r1, r2, r3);
			return rmedian3;
		}
		//Returns median of three elements.
		else if(s==PivotStrategy.MEDIAN_OF_THREE_ELEMENTS)
		{
			median3=medianOfThree(list, f, c, l);
            return median3;
            
		}
		else //Returns first element if no proper pivot strategy is selected.
		{
			return f;
		}
	}
}