package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    // TODO - you fill in here.
	  
	int currIndex = A.size() - 1; 
	int currDigit = A.get(currIndex);
	
	if (currDigit != 9) {
		A.set(currIndex, currDigit + 1);
		return A;
	}

	
	while (currDigit == 9 && currIndex >= 0) {
		A.set(currIndex, 0);
		
		if (currIndex == 0) break;
		
		int prevDigit = A.get(currIndex - 1); 
		if (prevDigit != 9) {
			A.set(currIndex - 1, prevDigit + 1);
			break;
		}
		
		currIndex --;
	}
	
	
	if (A.get(0) == 0) A.add(0, 1);
	
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
