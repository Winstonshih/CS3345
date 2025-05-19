/**
 * Java packages imported for IO and time methods to read and write files and calculate pivot Strategy execution times.
 */
import java.util.*;
import java.io.*;
import java.time.*;
/**
 * Winston Shih
 * 5/11/2025
 * CS 3345.002
 * QuickSorterMain.java: Main method class used to test Pivot Strategy methods from QuickSorter.java.
 */
public class QuickSorterMain {
	/**
     * Main method of QuickSorterMain class that executes methods from
     * QuickSorter class.
     * @param args arguments from command line used to read input file and write
     * in an output file.
     */
	public static void main(String[] args) {
		//Catches error if there are less than 4 or more than 4 arguments in terminal after ./QuickSorterMain.
		if(args.length!=4)
		{
			System.out.println("The command line execution should look like this: ./QuickSorterMain 100000 report.txt unsorted.txt sorted.txt");
		}
		try
		{ 
			//Array list size argument
			int size=Integer.parseInt(args[0]);
			//report.txt argument
			FileWriter reportFile=new FileWriter(args[1]);
			//unsorted.txt argument
			FileWriter unsortedFile=new FileWriter(args[2]);
			//sorted.txt argument
			FileWriter sortedFile=new FileWriter(args[3]);
			ArrayList<Integer> l = QuickSorter.generateRandomList(size);
			for (Integer num : l) {
                unsortedFile.write(num + "\n");
            }
			unsortedFile.close();
			//There are multiple array list copies to ensure each method has 
			//same amount of time to sort the arraylist.
			ArrayList<Integer> l1=new ArrayList<Integer>(l);
			ArrayList<Integer> l2=new ArrayList<Integer>(l);
			ArrayList<Integer> l3=new ArrayList<Integer>(l);
			ArrayList<Integer> l4=new ArrayList<Integer>(l);
			Duration t1 = QuickSorter.timedQuickSort(l1, QuickSorter.PivotStrategy.FIRST_ELEMENT);
            Duration t2 = QuickSorter.timedQuickSort(l2, QuickSorter.PivotStrategy.RANDOM_ELEMENT);
            Duration t3 = QuickSorter.timedQuickSort(l3, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS);
            Duration t4 = QuickSorter.timedQuickSort(l4, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS);
            //For almost sorted scenarios (10% randomly swapped after sorting)
            //int count=size/10;
			//Random r=new Random();
			//for(int i=0; i<count;i++)
            //{
            //    int i1=r.nextInt(size);
            //    int i2=r.nextInt(size);
            //    int temp=i1;
            //    l1.set(i1,l1.get(i2));
            //    l1.set(i2,l1.get(temp));
            //}
            for(Integer num: l1)
            {
            	sortedFile.write(num+"\n");
            }
            sortedFile.close();
            reportFile.write("Array Size = " + size + "\n");
            reportFile.write("FIRST_ELEMENT : " + t1 + "\n");
            reportFile.write("RANDOM_ELEMENT : " + t2 + "\n");
            reportFile.write("MEDIAN_OF_THREE_RANDOM_ELEMENTS : " + t3 + "\n");
            reportFile.write("MEDIAN_OF_THREE_ELEMENTS : " + t4);
            reportFile.close();
		}catch(InputMismatchException e) //Catches error for when a non integer value is entered for array list size.
		{
			System.out.println("Array size has to be an integer!");
		}
		catch(IOException e) //Catches other errors.
		{
			System.out.println("Error: "+e);
		}
		catch(IndexOutOfBoundsException e) //Catches errors for when index of partitions and pivots are invalid.
		{
		    System.out.println("Index is out of bounds!");
		}
	}

}
