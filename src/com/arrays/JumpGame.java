package com.arrays;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array. Each element in the array represents your maximum
 * jump length at that position. Determine if you are able to reach the last index.
 *
 */

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
//		int[] nums = { 3,2,1,0,4 };
		System.out.println("Valid Jump Game:" + canJump2(nums));
	}

	private static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		int index = 1;
		while (index < nums.length && nums[index] != 0) {
			if (nums[index] == 0)
				return false;

			index += nums[index];
			if (index == nums.length - 1)
				return true;
		}

		return false;
	}

	private static boolean canJump2(int[] nums) {
		int last = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= last)
				last = i;
		}
		return last <= 0;
	}
	
}
