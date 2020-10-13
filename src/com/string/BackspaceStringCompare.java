package com.string;

public class BackspaceStringCompare {

	public static void main(String[] args) {
//		String S = "abc##c", T = "ad#c";
		String S = "bxj##tw", T = "bxo#j##tw";
		System.out.println(backspaceCompare(S, T));
	}

	private static boolean backspaceCompare(String S, String T) {
		if ((S == null || S.length() == 0) && (T == null || T.length() == 0))
			return true;

		if (S == null || S.length() == 0)
			return false;

		if (T == null || T.length() == 0)
			return false;

		int i = S.length() - 1;
		int j = T.length() - 1;
		int cnt1 = 0, cnt2 = 0;
		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					i--;
					cnt1++;
				} else if (cnt1 > 0) {
					cnt1--;
					i--;
				} else
					break;
			}
			while (j >= 0) {
				if (T.charAt(j) == '#') {
					j--;
					cnt2++;
				} else if (cnt2 > 0) {
					cnt2--;
					j--;
				} else
					break;
			}
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
				return false;

			if ((i >= 0) != (j >= 0))
				return false;
			i--;
			j--;
		}
		return true;
	}
}
