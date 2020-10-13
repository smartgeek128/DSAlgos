package com.arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		System.out.println("https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/");
		int[] nums = { 0, 1, 0, 3, 12 };
//		int[] nums = { 1, 0, 1 };

		moveZeroes(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
			i++;
		}
	}
}
