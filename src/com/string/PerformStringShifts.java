package com.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 *
 */

public class PerformStringShifts {

	public static void main(String[] args) {
		String s = "abc";
		int[][] shift = { { 0, 1 }, { 1, 2 } };
		System.out.println(stringShift(s, shift));
	}

	private static String stringShift(String s, int[][] shift) {
		if (s == null || s.length() == 0)
			return "";

		Deque<Character> deque = new ArrayDeque<>();
		for (char c : s.toCharArray())
			deque.add(c);

		for (int[] item : shift) {
			int time = 0;
			if (item[0] == 0) {
				while (time < item[1]) {
					deque.addLast(deque.pollFirst());
					time++;
				}
			} else {
				while (time < item[1]) {
					deque.addFirst(deque.pollLast());
					time++;
				}
			}
		}

		StringBuffer sf = new StringBuffer();
		while (!deque.isEmpty())
			sf.append(deque.poll());

		return sf.toString();
	}
}
