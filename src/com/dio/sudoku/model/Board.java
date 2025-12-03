package com.dio.sudoku.model;

import java.util.List;

public class Board {
	
	private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";

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
                
                // --- LÓGICA DE CORES ---
                if (space.isFixed()) {
                    System.out.print(RED + value + RESET + " ");
                } else {
                    System.out.print(CYAN + value + RESET + " ");
                }
            }
            System.out.println();
        }
    }

	public boolean changeValue(int col, int row, int value) {

		var space = spaces.get(row).get(col);
		if (space.isFixed()) {
			return false;
		}

		if (rowHasValue(row, value) || columnHasValue(col, value) || boxHasValue(col, row, value)) {
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

	private boolean hasValue(List<Space> list, int value) {
		return list.stream().anyMatch(space -> space.getActual() != null && space.getActual().equals(value));
	}

	private boolean columnHasValue(int col, int value) {
		return spaces.stream().map(row -> row.get(col))
				.anyMatch(space -> space.getActual() != null && space.getActual().equals(value));
	}

	private boolean rowHasValue(int row, int value) {
		return hasValue(spaces.get(row), value);
	}

	private boolean boxHasValue(int col, int row, int value) {
		int rStart = row - (row % 3);
		int cStart = col - (col % 3);

		for (int r = rStart; r < rStart + 3; r++) {
			for (int c = cStart; c < cStart + 3; c++) {
				if (spaces.get(r).get(c).getActual() != null && spaces.get(r).get(c).getActual().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean gameIsFinished() {
		for (List<Space> col : spaces) {
			for (Space space : col) {
				if (space.getActual() == null) {
					return false;
				}
			}
		}
		return true;
	}
}
