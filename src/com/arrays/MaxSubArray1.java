package com.arrays;

public class MaxSubArray1 {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		int[] nums = { -2,-3,-1 };
		System.out.println(maxSubArray(nums));

	}

	private static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

//		int[] dp = new int[nums.length];
//		dp[0] = nums[0];
//		int max = dp[0];
		int sum = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
//			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			sum = (sum + nums[i] >= nums[i] ? sum+nums[i] : nums[i]);
//			max = Math.max(max, nums[i]);
			max = Math.max(sum, max);
		}
		return max;
	}
}
