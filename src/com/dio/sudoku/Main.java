package com.dio.sudoku;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, informe a definição do tabuleiro nos argumentos.");
            return;
        }

        var gameConfig = Stream.of(args).collect(Collectors.joining(" "));
        System.out.println("Configuração recebida: " + gameConfig);
    }
}