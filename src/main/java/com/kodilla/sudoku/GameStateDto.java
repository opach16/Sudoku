package com.kodilla.sudoku;

public record GameStateDto(Board board, int row, int col, int guessValue) {
}
