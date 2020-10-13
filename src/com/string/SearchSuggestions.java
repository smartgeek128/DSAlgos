package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/discuss/436151/JavaPython-3-Simple-Trie-and-Binary-Search-codes-w-comment-and-brief-analysis.
 */

public class SearchSuggestions {

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		List<List<String>> result = suggestedProducts(products, searchWord);
		for (List<String> list : result) {
			for (String product : list) {
				System.out.print(product + " ");
			}
			System.out.println();
		}
		
		System.out.println("=======================================================");
		List<List<String>> result2 = suggestedProductsTrie(products, searchWord);
		for (List<String> list : result2) {
			for (String product : list) {
				System.out.print(product + " ");
			}
			System.out.println();
		}
	}

	// Sort then Binary Search
	private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> ans = new ArrayList<>();
		Arrays.sort(products);
		
		for (int i = 1; i <= searchWord.length(); ++i) {
			String cur = searchWord.substring(0, i);
			int k = Arrays.binarySearch(products, cur);
			while (k > 0 && cur.equals(products[k - 1])) // in case there are more than 1 cur in products.
				--k; // find the first one.
			if (k < 0) // no cur in products.
				k = ~k; // find the first one larger than cur.
			List<String> suggestion = new ArrayList<>();
			for (int j = k + 3; k < products.length && k < j && products[k].startsWith(cur); ++k)
				suggestion.add(products[k]);
			ans.add(suggestion);
		}
		return ans;
	}
	
    private static List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        Arrays.sort(products); // sort products.
        Trie root = new Trie();
        for (String p : products) { // build Trie.
            Trie t = root;
            for (char c : p.toCharArray()) { // insert current product into Trie.
                if (t.sub[c - 'a'] == null)
                    t.sub[c - 'a'] = new Trie();
                t = t.sub[c - 'a'];
                if (t.suggestion.size() < 3) // maintain 3 lexicographically minimum strings.
                    t.suggestion.offer(p); // put products with same prefix into suggestion list.
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { // search product.
            if (root != null) // if there exist products with current prefix.
                root = root.sub[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.suggestion); // add it if there exist products with current prefix.
        }
        return ans;
    }
}

class Trie {
    Trie[] sub = new Trie[26];
    LinkedList<String> suggestion = new LinkedList<>();
}
