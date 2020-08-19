package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ConvertBase {
  @EpiTest(testDataFile = "convert_base.tsv")

  public static String convertBase(String numAsString, int b1, int b2) {
    // TODO - you fill in here.
	  
	if (numAsString.equals("0")) return numAsString;
	  
	// convert to base ten int  
	boolean isNegative = numAsString.charAt(0) == '-' ? true : false;
	
	int baseTen = 0;
	int place = 0;

	int end = isNegative ? 1 : 0;
	
	for (int i = numAsString.length() - 1; i >= end; i--) {
		char current = numAsString.charAt(i);
		int digit = current - '0';
		
		switch (current) {
			case 'A': digit = 10;
				break;
			case 'B': digit = 11;
				break;
			case 'C': digit = 12;
				break;
			case 'D': digit = 13;
				break;
			case 'E': digit = 14;
				break;
			case 'F': digit = 15;
				break;
		}
		
		baseTen += digit * Math.pow(b1, place);
		place++;
	}
	
	
	// convert to b2 int
	
	StringBuilder baseB2 = new StringBuilder();
	
	while (baseTen > 0) {
		int remainder = baseTen % b2;
		String digit = "";
		
		switch (remainder) {
			case 10: digit = "A";
				break;
			case 11: digit = "B";
				break;
			case 12: digit = "C";
				break;
			case 13: digit = "D";
				break;
			case 14: digit = "E";
				break;
			case 15: digit = "F";
				break;
		}
		
		if (remainder < 10) baseB2.append(Integer.toString(remainder));
		else if (remainder >= 10) baseB2.append(digit); 
		
		baseTen /= b2;
	}
	
	if (isNegative) baseB2.append('-');
	baseB2.reverse();
	
	return baseB2.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
