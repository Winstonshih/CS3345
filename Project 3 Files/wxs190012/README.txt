Winston Shih
WXS190012
CS 3345.005-Satpute
5/11/2025
Project 3-QuickSorter.java README Documentation
I used Eclipse IDE to write my Java code. The version of the Eclipse IDE is 
version 4.22.0 and JDK version my IDE uses is jdk-24. To compile my code, I 
copied my QuickSorter.java and QuickSorterMain.java to OnlineGDB and created 
three text files called report.txt, unsorted.txt, and sorted.txt. The three txt 
files are initially empty before the code is compiled. In the command line 
arguments section of the OnlineGDB terminal, I inputted 100000 (size of 
arraylist) report.txt unsorted.txt sorted.txt so terminal knew what text file 
to read and what text file to write. Because of the storage limitations of 
OnlineGDB, you need to delete report.txt, sorted.txt, and unsorted.txt to compile 
a new test case on OnlineGDB. To compile on terminal, you first have to type 
javac *.java in the directory path of QuickSorterMain.java and QuickSorter.java 
to make those java files executable. After making those class files executable, 
you input ./QuickSorterMain size report.txt unsorted.txt sorted.txt. This 
command createsa list of randomly selected elements in unsorted.txt, the sorted 
version of that list in sorted.txt, and a report of how long it took each pivot 
method to sort the list of elements in report.txt. There is an IOException 
handling for when user inputs a value for array size that exceeds storage 
capacity for OnlineGDB. There is also a InputMismatchException for when user
inputs wrong data type for one of the 4 arguments for command line argument.
An IndexOutOfBoundsException is also handled to ensure none of the partition 
strategies encounters a negative index when testing the source code.
Sorted array
Test Case 1:
Array Size = 450000
FIRST_ELEMENT : PT0.245555021S
RANDOM_ELEMENT : PT0.178459007S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.166360745S
MEDIAN_OF_THREE_ELEMENTS : PT0.088791568S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 2
Array Size = 500000
FIRST_ELEMENT : PT0.325248276S
RANDOM_ELEMENT : PT0.132535858S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.171417188S
MEDIAN_OF_THREE_ELEMENTS : PT0.086554759S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 3
Array Size = 100000
FIRST_ELEMENT : PT0.180820188S
RANDOM_ELEMENT : PT0.106859579S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.101463359S
MEDIAN_OF_THREE_ELEMENTS : PT0.109477029S
Most Efficient: MEDIAN_OF_THREE_RANDOM_ELEMENTS
Test Case 4
Array Size = 1000000
FIRST_ELEMENT : PT0.350630088S
RANDOM_ELEMENT : PT0.298796645S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.375948547S
MEDIAN_OF_THREE_ELEMENTS : PT0.245024304S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 5
Array Size = 400000
FIRST_ELEMENT : PT0.26595818S
RANDOM_ELEMENT : PT0.15692464S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.171214494S
MEDIAN_OF_THREE_ELEMENTS : PT0.147270662S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 6 
Array Size = 300000
FIRST_ELEMENT : PT0.195045451S
RANDOM_ELEMENT : PT0.116123944S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.11956589S
MEDIAN_OF_THREE_ELEMENTS : PT0.093337291S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Almost sorted (10% is randomly swapped after sorting)
Test Case 1
Array Size = 500000
FIRST_ELEMENT : PT0.321742551S
RANDOM_ELEMENT : PT0.108448358S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.116336587S
MEDIAN_OF_THREE_ELEMENTS : PT0.091035039S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 2
Array Size = 100000
FIRST_ELEMENT : PT0.197296026S
RANDOM_ELEMENT : PT0.092039148S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.105454509S
MEDIAN_OF_THREE_ELEMENTS : PT0.022324999S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 3 
Array Size = 1000000
FIRST_ELEMENT : PT0.310654127S
RANDOM_ELEMENT : PT0.184062241S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.210347273S
MEDIAN_OF_THREE_ELEMENTS : PT0.097684714S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 4 
Array Size = 1000500
FIRST_ELEMENT : PT0.383871757S
RANDOM_ELEMENT : PT0.230050019S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.233888928S
MEDIAN_OF_THREE_ELEMENTS : PT0.106045187S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 5
Array Size = 400000
FIRST_ELEMENT : PT0.291559776S
RANDOM_ELEMENT : PT0.113396228S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.178749407S
MEDIAN_OF_THREE_ELEMENTS : PT0.050467259S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Test Case 6 
Array Size = 450000
FIRST_ELEMENT : PT0.299325689S
RANDOM_ELEMENT : PT0.189614575S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.18269221S
MEDIAN_OF_THREE_ELEMENTS : PT0.140157438S
Most Efficient: MEDIAN_OF_THREE_ELEMENTS
Based on these sample outputs, it seems like  MEDIAN_OF_THREE_ELEMENTS seems to 
be the most efficient method for sorted array lists on average.
MEDIAN_OF_THREE_ELEMENTS is also most efficient for most almost sorted array 
lists test cases. Therefore, MEDIAN_OF_THREE_ELEMENTS is the most efficient 
partition strategy on average. The reason why MEDIAN_OF_THREE_ELEMENTS is most 
efficient is that its partitions split the data evenly by finding median of 
first, middle, and last element of each partitions. This strategy requires less 
comparisons and less time complexity since it requires less partitions compared
to FIRST_ELEMENT and its time complexity of O(nlogn) is lower than FIRST_ELEMENT's
O(n^2) time complexity. It is slightly more efficient than RANDOM_ELEMENT and
MEDIAN_OF_THREE_RANDOM_ELEMENTS since it does not have to allocate running time to 
generate one or three random numbers before quick sorting the unsorted array list.