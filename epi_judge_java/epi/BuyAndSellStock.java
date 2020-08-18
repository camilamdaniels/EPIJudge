package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    // TODO - you fill in here.
	Double minSoFar = prices.get(0);
	Double maxProfit = Double.MIN_VALUE;
	
	
	for (int i = 1; i < prices.size(); i++) {
		if (prices.get(i) > minSoFar) {
			maxProfit = Math.max(maxProfit, prices.get(i) - minSoFar);
		}
		
		else if (prices.get(i) < minSoFar) minSoFar = prices.get(i);
	}
	
    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
