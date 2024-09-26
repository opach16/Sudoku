package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

public class BoardTestSuite {

    @Test
    void testDeepCopy() throws CloneNotSupportedException {
        //given
        Board board = new Board();
        board.getBoard().get(0).getElements().get(1).setValue(2);
        board.getBoard().get(0).getElements().get(3).setValue(5);
        board.getBoard().get(0).getElements().get(5).setValue(1);
        board.getBoard().get(0).getElements().get(7).setValue(9);
        board.getBoard().get(1).getElements().get(0).setValue(8);
        board.getBoard().get(1).getElements().get(3).setValue(2);
        board.getBoard().get(1).getElements().get(5).setValue(3);
        board.getBoard().get(1).getElements().get(8).setValue(6);

        //when
        Board clonnedBoard = board.deepCopy();
        clonnedBoard.getBoard().get(0).getElements().get(1).setValue(0);
        clonnedBoard.getBoard().get(1).getElements().get(0).setValue(0);

        //then
        System.out.println(board);
        System.out.println("ClonnedBoard:");
        System.out.println(clonnedBoard);
    }
}
