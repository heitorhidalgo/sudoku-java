package com.dio.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dio.sudoku.model.Board;
import com.dio.sudoku.model.Space;

public class Main {

	private final static int BOARD_LIMIT = 9;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Por favor, informe a definição do tabuleiro nos argumentos.");
			return;
		}

		var gameConfig = Stream.of(args).collect(Collectors.joining(" "));
		System.out.println("Configuração recebida: " + gameConfig);

		var board = new Board(parseBoard(gameConfig));

		System.out.println("Tabuleiro criado com sucesso!");
		System.out.println("Iniciando o jogo...");

		board.show();

		runGame(board);

	}

	private static List<List<Space>> parseBoard(String gameConfig) {
		List<List<Space>> spaces = new ArrayList<>();
		Map<String, Space> spacesMap = new HashMap<>();

		String[] cells = gameConfig.split("\\s");

		for (String cell : cells) {
			String[] parts = cell.split(";");
			String position = parts[0];
			int expected = Integer.parseInt(parts[1]);
			boolean fixed = Boolean.parseBoolean(parts[2]);

			Space space = new Space(expected, fixed);
			spacesMap.put(position, space);
		}

		for (int r = 0; r < BOARD_LIMIT; r++) {
			List<Space> row = new ArrayList<>();
			for (int c = 0; c < BOARD_LIMIT; c++) {
				String key = r + "," + c;

				Space space = spacesMap.getOrDefault(key, new Space(0, false));
				row.add(space);
			}
			spaces.add(row);
		}

		return spaces;
	}

	private static void runGame(Board board) {
		try (var scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Informe a jogada (linha,coluna,valor) ou 'sair' para encerrar:");
				var input = scanner.next();

				if ("sair".equalsIgnoreCase(input)) {
					return;
				}

				try {
					var values = input.split(",");
					var r = Integer.parseInt(values[0]);
					var c = Integer.parseInt(values[1]);
					var v = Integer.parseInt(values[2]);

					if (board.changeValue(c, r, v)) {
						board.show();
						if (board.gameIsFinished()) {
				            System.out.printf("Parabéns! Você completou o Sudoku!%n");
				            return;
				        }	
					} else {
						System.out.printf("A jogada em [%s,%s] é inválida! (Posição fixa ou valor já existente)%n", r, c);
					}
				} catch (Exception e) {
					System.out.println("Entrada inválida! Use o formato: 0,0,5");
				}
			}
		}
	}
}