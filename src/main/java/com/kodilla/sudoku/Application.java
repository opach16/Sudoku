package com.kodilla.sudoku;

public class Application {

    public static void main(String[] args) {
        boolean gameFinished = false;
        while (!gameFinished) {
            Game theGame = new Game();
            theGame.playWithUserInput(new Board());
            gameFinished = theGame.resolveSudoku();
        }
    }
}
