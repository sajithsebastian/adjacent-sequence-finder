package com.visa.challenge;

import java.util.Map;

public class RubikcCubePathFinderTest {
	
	public static void main(String[] args) {
//		System.out.println("testInvalidRubikCubeFace ");
//		testInvalidRubikCubeFace();		
//		System.out.println("testSameDataOn4Faces ");
//		testSameDataOn4Faces();
//		System.out.println("testMultipleLongPathOnSingleFace ");
//		testMultipleLongPathOnSingleFace();
		System.out.println("testOneLongPathAcrossFaces ");
		testOneLongPathAcrossFaces();
	}
	
	// Test Invalid Rubik's Cube Face 
	public static void testInvalidRubikCubeFace() {
		LongestSequenceFinder rcPathFinder = new LongestSequenceFinder();
		char faceRed[][] = null;
		
		char faceWhite[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
							  { 'J', 'I', 'V', 'W', 'X', 'Y' },
							  { 'N', 'B', 'M', 'N', 'O', 'A' } };
		
		char faceYellow[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
							   { 'J', 'I', 'V', 'W', 'X', 'Y' },
							   { 'N', 'B', 'M', 'N', 'O', 'A' } };
		
		char faceBlue[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
							 { 'J', 'I', 'V', 'W', 'X', 'Y' },
							 { 'N', 'B', 'M', 'N', 'O', 'A' } };
		
		char faceOrange[][] = {{ 'A', 'B', 'C' },
							   { 'J', 'I', 'H' },
							   { 'K', 'L', 'O' } };
		
		char faceGreen[][] = {{ 'D', 'E', 'A' },
							  { 'G', 'F', 'A' },
							  { 'N', 'O', 'A' } };

		Map<String, String> longestResults = rcPathFinder.findRubikCubeLongestSequence(faceYellow, faceWhite, faceGreen, faceOrange,
				faceBlue, faceRed);
		
		longestResults.keySet().stream()
			.forEach(key -> System.out.println("Start Position=" + key +" Path=" + longestResults.get(key)));
	}	
	
	// Test Rubiks cube with same arrangement on long faces single long path
	public static void testOneLongPathAcrossFaces() {
		LongestSequenceFinder rcPathFinder = new LongestSequenceFinder();
		char faceRed[][] = {{ 'G', 'B', 'C', 'D', 'E', 'F' }, 
							{ 'J', 'I', 'V', 'W', 'J', 'G' },
							{ 'N', 'B', 'M', 'N', 'I', 'H' } };
		
		char faceWhite[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
							  { 'J', 'I', 'V', 'W', 'X', 'Y' },
							  { 'N', 'B', 'M', 'N', 'O', 'A' } };
		
		char faceYellow[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
							   { 'J', 'I', 'V', 'W', 'X', 'Y' },
							   { 'N', 'B', 'M', 'N', 'O', 'A' } };
		
		char faceBlue[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
							 { 'J', 'I', 'V', 'W', 'X', 'Y' },
							 { 'N', 'B', 'M', 'N', 'O', 'A' } };
		
		char faceOrange[][] = {{ 'A', 'B', 'C' },
							   { 'J', 'I', 'H' },
							   { 'K', 'L', 'O' } };
		
		char faceGreen[][] = {{ 'D', 'E', 'A' },
							  { 'G', 'F', 'A' },
							  { 'N', 'O', 'A' } };

		Map<String, String> longestResults = rcPathFinder.findRubikCubeLongestSequence(faceYellow, faceWhite, faceGreen, faceOrange,
				faceBlue, faceRed);
		
		longestResults.keySet().stream()
			.forEach(key -> System.out.println("Start Position=" + key +" Path=" + longestResults.get(key)));
	}	
	
	// Test Rubiks cube with same arrangement on long faces more than 1 result from a face
		public static void testMultipleLongPathOnSingleFace() {
			LongestSequenceFinder rcPathFinder = new LongestSequenceFinder();
			char faceRed[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
								{ 'J', 'I', 'V', 'W', 'X', 'Y' },
								{ 'N', 'B', 'M', 'N', 'O', 'A' } };
			
			char faceWhite[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
								  { 'J', 'I', 'V', 'W', 'X', 'Y' },
								  { 'N', 'B', 'M', 'N', 'O', 'A' } };
			
			char faceYellow[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
								   { 'J', 'I', 'V', 'W', 'X', 'Y' },
								   { 'N', 'B', 'M', 'N', 'O', 'A' } };
			
			char faceBlue[][] = {{ 'A', 'B', 'C', 'D', 'E', 'Z' }, 
								 { 'J', 'I', 'V', 'W', 'X', 'Y' },
								 { 'N', 'B', 'M', 'N', 'O', 'A' } };
			
			char faceOrange[][] = {{ 'A', 'B', 'C' },
								   { 'J', 'I', 'H' },
								   { 'K', 'L', 'O' } };
			
			char faceGreen[][] = {{ 'D', 'E', 'A' },
								  { 'G', 'F', 'A' },
								  { 'N', 'O', 'A' } };

			Map<String, String> longestResults = rcPathFinder.findRubikCubeLongestSequence(faceYellow, faceWhite, faceGreen, faceOrange,
					faceBlue, faceRed);

			longestResults.keySet().stream()
				.forEach(key -> System.out.println("Start Position=" + key + " " + longestResults.get(key)));
		}

	// Test Rubiks cube with same arrangement on 4 longer sides
	public static void testSameDataOn4Faces() {
		LongestSequenceFinder rcPathFinder = new LongestSequenceFinder();
		char faceRed[][] = {{ 'A', 'B', 'C', 'D', 'E', 'A' }, 
							{ 'J', 'I', 'H', 'G', 'F', 'A' },
							{ 'K', 'L', 'M', 'N', 'O', 'A' } };
		
		char faceWhite[][] = {{ 'A', 'B', 'C', 'D', 'E', 'A' }, 
							  { 'J', 'I', 'H', 'G', 'F', 'A' },
							  { 'K', 'L', 'M', 'N', 'O', 'A' } };
		
		char faceYellow[][] = {{ 'A', 'B', 'C', 'D', 'E', 'A' },
							   { 'J', 'I', 'H', 'G', 'F', 'A' },
							   { 'K', 'L', 'M', 'N', 'O', 'A' } };
		
		char faceBlue[][] = {{ 'A', 'B', 'C', 'D', 'E', 'A' },
							 { 'J', 'I', 'H', 'G', 'F', 'A' },
							 { 'K', 'L', 'M', 'N', 'O', 'A' } };
		
		char faceOrange[][] = {{ 'A', 'B', 'C' },
							   { 'J', 'I', 'H' },
							   { 'K', 'L', 'M' } };
		
		char faceGreen[][] = {{ 'D', 'E', 'A' },
							  { 'G', 'F', 'A' },
							  { 'N', 'O', 'A' } };

		Map<String, String> longestResults = rcPathFinder.findRubikCubeLongestSequence(faceYellow, faceWhite, faceGreen, faceOrange,
				faceBlue, faceRed);

		longestResults.keySet().stream()
				.forEach(key -> System.out.println("Start Position=" + key + " " + longestResults.get(key)));
	}

}
