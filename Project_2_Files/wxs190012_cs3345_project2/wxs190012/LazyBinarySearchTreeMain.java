/**
 * The util and io packages were used to import Scanner and IO functions
 * to read input file and write output in output file.
 */
import java.util.*;
import java.io.*;
/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 4/8/2025
 * Main testing class for LazyBinarySearchTree
 */
public class LazyBinarySearchTreeMain{
    /**
     * Main method of LazyBinarySearchTreeMain class that executes methods from
     * LazyBinarySearchTree class.
     * @param args arguments from command line used to read input file and write
     * in an output file.
     */
	public static void main(String[] args) {
		LazyBinarySearchTree<Integer> l=new LazyBinarySearchTree<Integer>();
		try {
		    /**
		     * Checks to see if two files are inputted for second command line
		     * command.
		     */
		     if(args.length<2||args.length>2)
		     {
		         System.out.println("The proper way to compile is: java LazyBinarySearchTreeMain inputFile outputFile");
		     }
		    /**
		     * Input file.
		     */
			File inputFile=new File(args[0]);
			/**
			 * Output file that program writes output to after executing.
			 */
			FileWriter outputFile = new FileWriter(args[1]);
			Scanner input=new Scanner(inputFile);
			while(input.hasNextLine())
			{
				String o=input.nextLine();
				/**
				 * Size of AVL Tree method.
				 */
				if(o.length()>=4 && o.equals("Size"))
				{
					int s=l.size();
					String size = String.valueOf(s);
					outputFile.write(size+"\n");
				}
				/**
				 * Height of AVL Tree method.
				 */
				else if(o.length()>=6 && o.equals("Height"))
				{
					int height=l.height();
					String h=String.valueOf(height);
					outputFile.write(h+"\n");
				}
				/**
				 * Insert node in AVL Tree method.
				 */
				else if(o.length()>=7 && o.substring(0, 7).equals("Insert:"))
				{
				    try{
				        int k = Integer.parseInt(o.substring(7));
					    boolean inserted=l.insert(k);
					    /**
					     * Output file prints True if node is successfully inserted.
					     */
					    if(inserted)
					    {
						    outputFile.write("True\n");
					    }
					    /**
					     * Output file prints False if node is not successfully inserted.
					     */
					    else if(!inserted)
					    {
						    outputFile.write("False\n");
					    }
				    }
				    /**
					 * Catches error if a non-integer value is inputted after "Insert:".
					 */
					catch(IllegalArgumentException e)
					{
					    outputFile.write("Error in insert: IllegalArgumentException raised\n");
					}
				}
				/**
				 * Delete node in AVL Tree method.
				 */
				else if(o.length()>=7 && o.substring(0,7).equals("Delete:"))
				{
				    try
				    {
				        int k=Integer.parseInt(o.substring(7));
					    boolean deleted=l.delete(k);
					    /**
					     * Output file prints True if node is successfully deleted.
					     */
					    if(deleted)
					    {
						    outputFile.write("True\n");
					    }
					    /**
					     * Output file prints False if node is not successfully deleted.
					     */
					    else if(!deleted)
					    {
						    outputFile.write("False\n");
					    }
				    }
				    /**
				     * Catches error if a non-integer value is inputed after "Delete:".
				     */
				    catch(IllegalArgumentException e)
				    {
				        outputFile.write("Error in delete: IllegalArgumentException raised\n");
				    }
				}
				/**
				 * Find minimum node in the AVL Tree method.
				 */
				else if(o.length()>=7 && o.equals("FindMin"))
				{
					int min=l.findMin();
					outputFile.write(min+"\n");
				}
				/**
				 * Find maximum node in the AVL Tree method.
				 */
				else if(o.length()>=7 && o.equals("FindMax"))
				{
					int max=l.findMax();
					outputFile.write(max+"\n");
				}
				/**
				 * The AVL Tree contains method.
				 */
				else if(o.length()>=9 && o.substring(0,9).equals("Contains:"))
				{
				    try{
				        int k=Integer.parseInt(o.substring(9));
					    boolean c=l.contains(k);
					    /**
					     * Prints True in output file if node is in AVL Tree.
					     */
					    if(c)
					    {
						    outputFile.write("True\n");
					    }
					    /**
					     * Prints False in output file if node is not in AVL Tree.
					     */
					    else if(!c)
					    {
						    outputFile.write("False\n");
					    }
				    }
				    /**
				     * Error is catched if input after "Contains:" is not an integer.
				     */
				    catch(IllegalArgumentException e)
				    {
				        outputFile.write("Error in contains: IllegalArgumentException raised\n");
				    }
				}
				/**
				 * Print all nodes in the AVL Tree method.
				 */
				else if(o.length()>=9 && o.equals("PrintTree"))
				{
					outputFile.write(l.toString()+"\n");
				}
				/**
				 * Error is printed if invalid operation is inputted.
				 */
				else
				{
					outputFile.write("Error in Line: "+o+"\n");
				}
			}
			input.close();
			outputFile.close();
		/**
		 * Catches error if there is no input file.
		 */
		}catch (FileNotFoundException e) {
			System.out.println("No input file!");
		}
		/**
		 * Catches error if there is no output file is produced.
		 */
		catch (IOException e)
		{
			System.out.println("No output file!");
		}
	}
}