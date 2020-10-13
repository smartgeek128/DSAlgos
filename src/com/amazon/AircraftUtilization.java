package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Amazon | Online Assessment 2019 | Optimal Aircraft Utilization
//https://leetcode.com/discuss/interview-question/318918/Amazon-or-Online-Assessment-2019-or-Optimal-Aircraft-Utilization

//Java O(NlogN) solution with Playground to test.

// In my thought, we can sort forwardRouteList and returnRouteList by its second element as first. 
// What we really care is the sum of route dist must be smaller than maxTravelDist and as large as possible. 
// We can set two pointers and traverse two sorted arrays to find the max value (and the combination of course). 
// Since the sorting part complexity is O(MlogM + NlogN) and two-pointer traversal is O(M + N), the final complexity 
// can be regarded as O(KlogK) where K is the longest input array.

public class AircraftUtilization {
	
	public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
		List<List<Integer>> res = new ArrayList<>();
		int len1 = forwardRouteList.length, len2 = returnRouteList.length;
		if (len1 == 0 || len2 == 0)
			return res;
		Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
		Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
		int left = 0, right = len2 - 1, maxVal = -1;
		HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
		while (left < len1 && right >= 0) {
			int sum = forwardRouteList[left][1] + returnRouteList[right][1];
			if (sum > maxTravelDist) {
				--right;
				continue;
			}
			if (sum >= maxVal) {
				int r = right;
				map.putIfAbsent(sum, new ArrayList<>());
				// check the duplicates
				while (r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]) {
					List<Integer> list = new ArrayList<>();
					list.add(forwardRouteList[left][0]);
					list.add(returnRouteList[r][0]);
					map.get(sum).add(list);
					--r;
				}
				maxVal = sum;
			}
			++left;
		}
		return map.get(maxVal);
	}

	public static void main(String[] args) {
		AircraftUtilization main = new AircraftUtilization();
		int[] maxTravelDists = { 7000, 10000, 10000 };
		
		int[][][] forwardRouteLists = { { { 1, 2000 }, { 2, 4000 }, { 3, 6000 } },
				{ { 1, 2000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } },
				{ { 1, 3000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } } };
		
		int[][][] returnRouteLists = { { { 1, 2000 } }, { { 1, 2000 }, { 2, 3000 }, { 3, 4000 }, { 4, 5000 } },
				{ { 1, 2000 }, { 2, 2000 }, { 3, 4000 }, { 4, 4000 } } };
		
		for (int i = 0; i < maxTravelDists.length; ++i) {
			System.out.println(main.aircraftUtilization(maxTravelDists[i], forwardRouteLists[i], returnRouteLists[i]));
		}
	}
}