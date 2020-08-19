package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.ArrayList;
public class SpiralOrdering {
  @EpiTest(testDataFile = "spiral_ordering.tsv")

  public static List<Integer>
  matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
    // TODO - you fill in here.
	  
	if (squareMatrix.size() == 1) return squareMatrix.get(0);
	
	if (squareMatrix.size() == 0) return new ArrayList<Integer>();
	  
	// iteratively print out boundaries over and over again
	List<Integer> spiral = new ArrayList<Integer>();  
	
	int i = 0;
	int j = squareMatrix.size();
	
	while (i <= j) {
		spiral.addAll(spiralOrderHelper(squareMatrix, i, j));
		i++;
		j--;
	}
	
    return spiral;
  }
  
  public static List<Integer> spiralOrderHelper(List<List<Integer>> squareMatrix, int start, int end) {
	  
	  List<Integer> boundary = new ArrayList<Integer>();
	  
	  // top row 
	  for (int i = start; i < end; i++) {
		  boundary.add(squareMatrix.get(start).get(i));
	  }
	  
	  // rightmost column, minus first element
	  for (int i = start + 1; i < end; i++) {
		  boundary.add(squareMatrix.get(i).get(end - 1));
	  }
	  
	  // bottom row, minus rightmost element
	  for (int i = end - 2; i >= start; i--) {
		  boundary.add(squareMatrix.get(end - 1).get(i));
	  }
	  
	  // leftmost column, minus first and last element
	  for (int i = end - 2; i >= start + 1; i--) {
		  boundary.add(squareMatrix.get(i).get(start));
	  }
	  
	  return boundary;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpiralOrdering.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
