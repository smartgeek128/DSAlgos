package com.arrays;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
	Input: [2,7,4,1,8,1]
	Output: 1
	Explanation: 
	We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
	we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
	we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
	we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 */

public class LastStoneWeight {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 4, 1, 8, 1 };
//		int[] arr = { 2, 2 };
		System.out.println("Output:" + lastStoneWeight(arr));
	}

	private static int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length == 0)
			return 0;

		Queue<Integer> maxHeap = new PriorityQueue<>(stones.length, Collections.reverseOrder());
		for (int stone : stones)
			maxHeap.offer(stone);

		while (maxHeap.size() > 1) {
			int stone1 = maxHeap.poll();
			int stone2 = maxHeap.poll();

			int diffStone = stone1 - stone2;
			if (diffStone > 0)
				maxHeap.offer(diffStone);
		}

		if (maxHeap.size() == 0)
			return 0;

		return maxHeap.poll();
	}
}
