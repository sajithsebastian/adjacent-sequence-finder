package com.visa.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * 3X3X6 Rubik's cube has 6 different faces
 * Each face is different and can represented by 2 dimensional arrays as follows
 * 4 faces with 3X6 dimension and 2 faces with 3X3 dimension. 
 * 
 *    Solution :
 *    	Rubik's cube faces can be represented with 2D Array (4 3X6 char arrays and 2 3X3 char arrays containing A..Z)
 *    
 *    	Step 1 : Find longest adjacent sequence for each cell in a face. 
 *    		Step 1a: Recursively find the adjacent sequence by storing all paths in a lookup. 
 *    			Step 1a.1: Test adjacency for all 4 columns around and initiate recursive find for that cell   
 *    
 *    	Step 2: Compare longest sequence from all faces and return longest sequence as a List
 *    
 *    PreConditions : 
 *    	1) Adjacency is not considered for the letters in different Rubik's cube faces
 *      2) Reporting one way path only. Its possible the path can be started from the end cell of the 
 *         reported path. But it will not be reported as part of this as its potentially same.
 *      3) Diagonal adjacency is not considered.  
 *    
 *    Complexity :
 *       Time Complexity of this solution is O(N^2)
 *       Reduced the exponential complexity due to recursive path finding with the help of memorization. 
 *       Only one pass will happen for a cell to find possible longest path and it will get stored  and reused.
 *       
 *      TODO Add more test cases,Consider moving diagonally   
 *    		
 * @author ssebastian
 */	
class LongestSequenceFinder {
	// Function to check if cell (i, j) is a valid cell or not
	public boolean isValid(char[][] face, int i, int j) {
		return (i >= 0 && i < face.length && j >= 0 && j < face[0].length);
	}

	// Find longest path starting from cell (i, j) formed by adjacent
	// chars in the face
	public String findLongestPathFromPosition(char[][] face, int i, int j, Map<String, String> lookup,
			String faceColor) {
		// if the cell is invalid(checking edges)
		if (!isValid(face, i, j)) {
			return null;
		}

		// construct an unique map key from dynamic elements of the input
		String key = faceColor + "Face[" + i + "][" + j + "]";

		// if sub-problem is seen for the first time, solve it and
		// store its result in a map
		if (!lookup.containsKey(key)) {
			// string to store path starting (i, j)
			String path = null;

			// recur top cell if its value is +1 of value at (i, j)
			if (i > 0 && face[i - 1][j] - face[i][j] == 1) {
				path = findLongestPathFromPosition(face, i - 1, j, lookup, faceColor);
			}

			// recur right cell if its value is +1 of value at (i, j)
			if (j + 1 < face[0].length && face[i][j + 1] - face[i][j] == 1) {
				path = findLongestPathFromPosition(face, i, j + 1, lookup, faceColor);
			}

			// recur bottom cell if its value is +1 of value at (i, j)
			if (i + 1 < face.length && face[i + 1][j] - face[i][j] == 1) {
				path = findLongestPathFromPosition(face, i + 1, j, lookup, faceColor);
			}

			// recur left cell if its value is +1 of value at (i, j)
			if (j > 0 && face[i][j - 1] - face[i][j] == 1) {
				path = findLongestPathFromPosition(face, i, j - 1, lookup, faceColor);
			}

			// note that as matrix contains all distinct elements,
			// there is only one path possible from current cell

			if (path != null) {
				lookup.put(key, face[i][j] + " -> " + path);
			} else {
				lookup.put(key, String.valueOf(face[i][j]));
			}
		}

		// return path starting from (i, j)
		return lookup.get(key);
	}

	// Find longest sequences for
	public Map<String, String> findLongestSequanceOfArray(char[][] face, String faceColor) {
		Map<String, String> lookup = new HashMap<>();
		Map<String, String> result = new HashMap<>();
		String res = ""; // stores longest path found so far
		String str; // stores current path

		long resSize = Long.MIN_VALUE; // stores no. of elements in res
		for (int i = 0; i < face.length; i++) {
			for (int j = 0; j < face[0].length; j++) {
				// str would be like 1 - 2 - 3 - 4 - 5 -
				str = findLongestPathFromPosition(face, i, j, lookup, faceColor);
				// System.out.println(str);
				// find number of elements involved in current path
				long size = str.chars().filter(ch -> ch == '-').count();
				// update result if longer path is found
				String key = faceColor + "Face[" + i + "][" + j + "]";
				if (size > resSize) {
					res = str;
					resSize = size;
					result.clear();
					result.put(key, res);
				} else if (size == resSize) {
					result.put(key, str);
				}

			}
		}
		return result;
	}

	// Find results for all faces of Rubik's Cube
	public Map<String, String> findRubikCubeLongestSequence(char[][] faceYellow, char[][] faceWhite, char[][] faceGreen,
			char[][] faceOrange, char[][] faceBlue, char[][] faceRed) {

		Map<String, String> longestResults = new HashMap<>();
		longestResults.putAll(findLongestSequanceOfArray(faceYellow, "YELLOW"));
		longestResults.putAll(findLongestSequanceOfArray(faceWhite, "WHITE"));
		longestResults.putAll(findLongestSequanceOfArray(faceGreen, "GREEN"));
		longestResults.putAll(findLongestSequanceOfArray(faceOrange, "ORANGE"));
		longestResults.putAll(findLongestSequanceOfArray(faceBlue, "BLUE"));
		longestResults.putAll(findLongestSequanceOfArray(faceRed, "RED"));

		return getLongestResults(longestResults);
	}

	// Consolidate longest result from all faces
	public Map<String, String> getLongestResults(Map<String, String> clubbedResults) {
		Map<String, String> result = new HashMap<>();
		String longPath = "";
		for (String key : clubbedResults.keySet()) {
			if (longPath.length() < clubbedResults.get(key).length()) {
				result.clear();
				result.put(key, clubbedResults.get(key));
				longPath = clubbedResults.get(key);
			} else if (longPath.length() == clubbedResults.get(key).length()) {
				result.put(key, clubbedResults.get(key));
			}
		}

		return result;
	}

}