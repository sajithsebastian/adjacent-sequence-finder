# Find Longest Path of Adjacency in a Rubik's cube
Given a Rubik’s cube (3x3x6), each of the surface cells is marked with an English capital letter 'A' to 'Z'. 
Find the maximum length path such that all cells along the path are adjacent letters. Print the max length, 
the letters in the string, and its index sequence. If there are multiple answers, print all the answer

## Solution
	Rubik's cube faces can be represented with 2D Array (4 3X6 char arrays and 2 3X3 char arrays containing A..Z)
     	Step 1 : Find longest adjacent sequence for each cell in a face. 
     		Step 1a: Recursively find the adjacent sequence by storing all paths in a lookup. 
    			Step 1a.1: Test adjacency for all 4 columns around and initiate recursive find for that cell       
    	Step 2: Compare longest sequence from all faces and return longest sequence as a List
 ## Code Referance  	
 Refer LongestSequenceFinder.java for the implementation.
 Refer RubikcCubePathFinderTest.java for sample test execution details.  

## Complexity 
Time Complexity of this solution is O(N^2)
Memorization is used to reduce the complexity of computing the sub program results recursively. This reduced the exponential complexity to  O(N^2)
Only one pass will happen for a cell to find possible longest path and it will get stored  and reused.
## Build & Tests
```bash
# Compile and execute the shell script 
mvn clean install
./run.sh
```