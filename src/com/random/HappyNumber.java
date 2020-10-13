package com.random;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}

	public static boolean isHappy(int n) {
		Set<Integer> squaresSet = new HashSet<>();
		int squareSum, remain;

		while (squaresSet.add(n)) {
			squareSum = 0;
			while (n > 0) {
				remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			n = squareSum;
		}

		return false;
	}
}
