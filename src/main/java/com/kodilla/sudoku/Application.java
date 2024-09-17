package com.kodilla.sudoku;

public class Application {

    public static void main(String[] args) {

        boolean gameFinished = false;
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            theGame.play();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
