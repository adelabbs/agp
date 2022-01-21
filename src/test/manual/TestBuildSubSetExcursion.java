package test.manual;

import java.util.ArrayList;
import java.util.List;

public class TestBuildSubSetExcursion {
	private static List<List<Integer>> siteSubsets = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		findIndexSubsets(20,1, 2);
		for(List<Integer> tmp : siteSubsets) {
			System.out.println(tmp.toString());
		}
	}
	
	public static void findIndexSubsets(int n, int minSize, int maxSize) {
		for(int k = minSize; k <= maxSize; k++) {
	        recSubsetBuilder(n, k, 0, siteSubsets, new ArrayList<>());
		}
    }

    public static void recSubsetBuilder(int n, int k, int startIndex, List<List<Integer>> subsets, List<Integer> subset) {
        if (k == subset.size()) {
        	subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
        	subset.add(i);
            recSubsetBuilder(n, k, i + 1, subsets, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
