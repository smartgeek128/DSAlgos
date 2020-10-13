package com.graph;

public class NumberOfIslands {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1, 0 }, 
						 { 1, 1, 0, 0, 0 }, 
						 { 1, 1, 0, 1, 0 }, 
						 { 0, 0, 1, 0, 1 } 
					   };
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					DFSMarking(grid, i, j);
					res++;
				}
			}
		}
		System.out.println("Number of Islands:" + res);
	}

	private static void DFSMarking(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
			return;

		grid[i][j] = 0;
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j - 1);
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i, j + 1);
	}
}
