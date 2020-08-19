package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class ReverseWords {

  public static void reverseWords(char[] input) {
    // TODO - you fill in here.
	
	int start = 0;
	int end = 0;
	
	reverseWord(input, 0, input.length - 1);
	  
	for(int i = 0; i < input.length; i++) {
		if (input[i] == ' ') {
			end = i - 1;
			reverseWord(input, start, end);
			start = i + 1;
		}
	}
	
	reverseWord(input, start, input.length - 1);
	
    return;
  }
  
  public static void swap(char[] arr, int i, int j) {
	  char temp = arr[i];
	  arr[i] = arr[j];
	  arr[j] = temp;
  }
  
  public static void reverseWord(char[] sentence, int start, int end) {
	  while (start < end) {
		  swap(sentence, start, end);
		  start++;
		  end--;
	  }
  }
  @EpiTest(testDataFile = "reverse_words.tsv")
  public static String reverseWordsWrapper(TimedExecutor executor, String s)
      throws Exception {
    char[] sCopy = s.toCharArray();

    executor.run(() -> reverseWords(sCopy));

    return String.valueOf(sCopy);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseWords.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
