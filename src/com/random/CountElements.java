package com.random;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them separately.
 *
 */
public class CountElements {

	public static void main(String[] args) {
		int[] arr = { 1,1,2 };
		System.out.println(countElements(arr));
	}

	private static int countElements(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] + 1))
				res++;
		}
		return res;
	}
}
