Winston Shih
WXS190012
CS 3345.005-Satpute
4/8/2025
Project 2-Lazy Binary Search Tree README documentation
I used Eclipse IDE to write my Java code. The version of the Eclipse IDE is version 4.22.0 and JDK version my IDE uses is jdk-24. 
To compile my code, I copied my LazyBinarySearchTree.java and LazyBinarySearchTreeMain.java to OnlineGDB and created two text files 
called LazyBinarySearchTreeInput.txt and LazyBinarySearchTreeOutput.txt. The LazyBinarySearchTreeOutput.txt is initially
empty before the code is compiled. In the command line arguments section of the OnlineGDB terminal, I inputted 
LazyBinarySearchTreeinput.txt LazyBinarySearchTreeOutput.txt sp terminal knew what text file to read and what text file to write.
The LazyBinarySearchTreeInput.txt has the following content:
Height
FindMin
FindMax
Insert:98
Insert:67
Insert:55
Insert:45
PrintTree
Delete:84
Delete:45
Contains:45
FindMin
FindMax
PrintTree
Height
Size
Insert:84
Insert:32
Insert:132
PrintTree
Insert:980
Insert
hih
hello there
Delete: 900
Delete:45
Delete:84
Insert:45
PrintTree
Contains:-1
Contains:9600
Insert:
Contains:

Delete:
Insert:$
Delete:*
Contains:)
Insert: 9
Contains: 92
Delete: 85
PrintTree:
FindMin:
FindMax:
Height:
Size:
Height 
 Height
After running the code in OnlineGDB, the LazyBinarySearchTreeOutput.txt has the following content:
-1
-1
-1
True
True
True
True
98 67 55 45
False
True
False
45
98
98 67 55 *45
3
4
True
True
Error in insert: IllegalArgumentException raised
98 67 55 *45 32 84
Error in insert: IllegalArgumentException raised
Error in Line: Insert
Error in Line: hih
Error in Line: hello there
Error in delete: IllegalArgumentException raised
False
True
True
98 67 55 45 32 *84
Error in contains: IllegalArgumentException raised
Error in contains: IllegalArgumentException raised
Error in insert: IllegalArgumentException raised
Error in contains: IllegalArgumentException raised
Error in Line: 
Error in delete: IllegalArgumentException raised
Error in insert: IllegalArgumentException raised
Error in delete: IllegalArgumentException raised
Error in contains: IllegalArgumentException raised
Error in insert: IllegalArgumentException raised
Error in contains: IllegalArgumentException raised
Error in delete: IllegalArgumentException raised
Error in Line: PrintTree:
Error in Line: FindMin:
Error in Line: FindMax:
Error in Line: Height:
Error in Line: Size:
Error in Line: Height 
Error in Line:  Height
To compile the code on a terminal, you have to first cd to the directory in which LazyBinarySearchTree.java, 
LazyBinarySearchTreeMain.java, LazyBinarySearchTreeInput.txt, and LazyBinarySearchTreeOutput.txt files are located. You then use 
javac *.java to create class files for the java classes so that the code is executable on the terminal. After that, you write java 
LazyBinarySearchTreeMain LazyBinarySearchTreeInput.txt LazyBinarySearchTreeOutput.txt command to generate the output file 
LazyBinarySearchTreeOutput.txt that LazyBinarySearchTreeMain will generate. To produce javadocs, you have to use javadoc 
LazyBinarySearchTreeMain.java and javadoc LazyBinarySearchTree.java.