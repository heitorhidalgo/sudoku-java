package com.dio.sudoku.model;

import java.util.List;

public class Board {

	private final List<List<Space>> spaces;

	public Board(List<List<Space>> spaces) {
		this.spaces = spaces;
	}

	public List<List<Space>> getSpaces() {
		return spaces;
	}

	public void show() {
		for (int i = 0; i < spaces.size(); i++) {
			var col = spaces.get(i);

			if (i > 0 && i % 3 == 0) {
				System.out.println("---------------------");
			}

			for (int j = 0; j < col.size(); j++) {

				if (j > 0 && j % 3 == 0) {
					System.out.print("| ");
				}

				var space = col.get(j);

				var value = space.getActual() != null ? space.getActual() : " ";
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	public boolean changeValue(int col, int row, int value) {

		var space = spaces.get(col).get(row);
		if (space.isFixed()) {
			return false;
		}

		space.setActual(value);
		return true;
	}

	public boolean clearValue(int col, int row) {
		var space = spaces.get(col).get(row);
		if (space.isFixed()) {
			return false;
		}

		space.clearActual();
		return true;
	}
}
