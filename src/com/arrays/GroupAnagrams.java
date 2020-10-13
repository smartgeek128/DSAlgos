package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(input);
		for (List<String> listStr : result) {
			for (String str : listStr) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return null;

		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			List<String> listStr = map.getOrDefault(key, new ArrayList<String>());
			listStr.add(strs[i]);
			map.put(key, listStr);
		}

		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}
}
