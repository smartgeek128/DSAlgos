package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		System.out.println("MajorityElementII");

		int[] nums = {1,1,1,3,3,2,2,2};
//		int[] nums = { 8, 8, 7, 7, 7 };
		List<Integer> result = majorityElement(nums);
		System.out.println(result);
	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int c1 = 0, c2 = 0;
		Integer n1 = null, n2 = null;

		if (nums == null || nums.length == 0)
			return result;

		for (int num : nums) {
			if (n1 != null && num == n1.intValue()) {
				c1++;
			} else if (n2 != null && num == n2.intValue()) {
				c2++;
			} else if (c1 == 0) {
				n1 = num;
				c1 = 1;
			} else if (c2 == 0) {
				n2 = num;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}

		c1 = c2 = 0;
		for (int num : nums) {
			if (num == n1)
				c1++;
			else if (num == n2)
				c2++;
		}

		if (c1 > nums.length / 3)
			result.add(n1);
		if (c2 > nums.length / 3)
			result.add(n2);

		return result;
	}
}
