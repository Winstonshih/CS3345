package cs3345;
import java.util.*;
/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 2/23/2025
 * ProductTester is the class with a main function to run ProductSinglyLinkedList class'
 * methods to keep track of products.
 */
public class ProductTester extends Product{
	public static void main(String[] args) {
		//Singly Linked list of ProductTester class.
		ProductSinglyLinkedList<Product> l=new ProductSinglyLinkedList<Product>();
		Scanner input=new Scanner(System.in);
		//Initially set to zero to avoid variable has not been initialized error.
		int choice=0;
		do {
			System.out.println("Operations on List");
			System.out.println("  1. Make Empty");
			System.out.println("  2. Find ID");
			System.out.println("  3. Insert At Front");
			System.out.println("  4. Delete From Front");
			System.out.println("  5. Delete ID");
			System.out.println("  6. Print All Records");
			System.out.println("  7. Done");
			System.out.print("\n     Your choice: ");
			//While loop to catch invalid non-integer inputs.
			while(choice==0){
				try {
					choice=input.nextInt();
					input.nextLine();
					break; //While loop ends when user inputs a valid integer number.
				}catch(InputMismatchException e)//Catches InputMismatchException if user inputs a non-integer input.
				{
					System.out.println("     Invalid input type. Please input an integer (1-7) for operation choice.\n");
					System.out.println("Operations on List");
					System.out.println("  1. Make Empty");
					System.out.println("  2. Find ID");
					System.out.println("  3. Insert At Front");
					System.out.println("  4. Delete From Front");
					System.out.println("  5. Delete ID");
					System.out.println("  6. Print All Records");
					System.out.println("  7. Done");
					input.nextLine();
					System.out.print("\n     Your choice: ");
				}
			}
			//1. Make Empty.
			if(choice==1)
			{
				l.makeEmpty();
				System.out.println("     Linked list is empty.\n");
			}
			//2. Find ID.
			else if(choice==2)
			{
				try {
					System.out.print("     ID No: ");
					int idToFind=input.nextInt();
					Product p2=l.findID(idToFind);
					p2.printID();
					System.out.println("");
				}catch(NullPointerException e) //Catches NullPointerExceptionError if findID returns null.
				{
					System.out.println("     ID not found.\n");
				}
			}
			//3. Insert At Front.
			else if(choice==3)
			{
				Product p3=new Product();
				int productID=0;
				while(productID==0) {//Loops until user inputs valid productID.
					try {
						System.out.print("     Product ID: ");
						productID=input.nextInt();
					}catch(InputMismatchException e)//Catches InputMismatchException for productID.
					{
						System.out.println("     Invalid id.");
						input.nextLine();
					}
				}
				input.nextLine();
				System.out.print("     Product Name: ");
				String productName=input.nextLine();
				System.out.print("     Supplier Name: ");
				String supplierName=input.nextLine();
				p3.setID(productID);
				p3.setProductName(productName);
				p3.setSupplierName(supplierName);
				if(l.insertAtFront(p3)==true)//Adds Node at Front if Product ID is unique.
				{
					System.out.println("     Product Added.\n");
				}
				else {
					System.out.println("     Product Already Exists.\n");
				}
			}
			//4. Delete From Front.
			else if(choice==4)
			{
				try {
					Product p4=l.deleteFromFront();
					p4.printID();
					if(p4!=null)
					{
						System.out.println("     First item deleted.\n");
					}
					System.out.println("");
				}catch(NullPointerException e) {//Catches null value if singly linked list is empty.
					System.out.println("     Singly linked list is empty.\n");
				}
			}
			//5. Delete From Front.
			else if(choice==5)
			{
				try {
					System.out.print("     ID No: ");
					int delID=input.nextInt();
					Product p5=l.delete(delID);
					p5.printID();
					System.out.println("");
				}catch(NullPointerException e){ //Catches null value if ID is not found.
					System.out.println("     ID not found.\n");
				}
			}
			//6. Print All Records.
			else if(choice==6)
			{
				l.printAllRecords();
				System.out.println("");
			}
			//7.Done.
			else if(choice==7)
			{
				System.out.println("     Done.");
			}
			//If choice is an integer number that is not 1-7.
			else if(choice!=7)
			{
				System.out.println("     Invalid input.\n");
			}
			//Choice is reset to zero if choice is not 7 to avoid an infinite loop when trying and catching InputMismatchExceptions.
			if(choice!=7)
			{
				choice=0;
			}
		}while(choice!=7);//Ends when user inputs 7.
		input.close();
	}
}
