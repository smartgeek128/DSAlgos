package com.arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		System.out.println(search(nums, 9));
	}

	private static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[start] <= nums[mid]) {
				if (target >= nums[start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}
}
