package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

public class SudokuTestSuite {

    @Test
    public void sudokuTest() {
        //given
        Game game = new Game();
        Board board = new Board();

        board.getBoard().get(0).getElements().get(1).setValue(2);
        board.getBoard().get(0).getElements().get(3).setValue(5);
        board.getBoard().get(0).getElements().get(5).setValue(1);
        board.getBoard().get(0).getElements().get(7).setValue(9);

        board.getBoard().get(1).getElements().get(0).setValue(8);
        board.getBoard().get(1).getElements().get(3).setValue(2);
        board.getBoard().get(1).getElements().get(5).setValue(3);
        board.getBoard().get(1).getElements().get(8).setValue(6);

        board.getBoard().get(2).getElements().get(1).setValue(3);
        board.getBoard().get(2).getElements().get(4).setValue(6);
        board.getBoard().get(2).getElements().get(7).setValue(7);

        board.getBoard().get(3).getElements().get(2).setValue(1);
        board.getBoard().get(3).getElements().get(6).setValue(6);

        board.getBoard().get(4).getElements().get(0).setValue(5);
        board.getBoard().get(4).getElements().get(1).setValue(4);
        board.getBoard().get(4).getElements().get(7).setValue(1);
        board.getBoard().get(4).getElements().get(8).setValue(9);

        board.getBoard().get(5).getElements().get(2).setValue(2);
        board.getBoard().get(5).getElements().get(6).setValue(7);

        board.getBoard().get(6).getElements().get(1).setValue(9);
        board.getBoard().get(6).getElements().get(4).setValue(3);
        board.getBoard().get(6).getElements().get(7).setValue(8);

        board.getBoard().get(7).getElements().get(0).setValue(2);
        board.getBoard().get(7).getElements().get(3).setValue(8);
        board.getBoard().get(7).getElements().get(5).setValue(4);
        board.getBoard().get(7).getElements().get(8).setValue(7);

        board.getBoard().get(8).getElements().get(1).setValue(1);
        board.getBoard().get(8).getElements().get(3).setValue(9);
        board.getBoard().get(8).getElements().get(5).setValue(7);
        board.getBoard().get(8).getElements().get(7).setValue(6);

        //when
        System.out.println("*** Initial board ***");
        System.out.print(board);
        System.out.println("*********************");
        game.play(board);

    }
}
