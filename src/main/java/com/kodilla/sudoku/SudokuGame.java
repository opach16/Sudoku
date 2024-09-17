package com.kodilla.sudoku;

public class SudokuGame {

    private final IOController ioController = new IOController();


    public void play() {
        SudokuBoard board = new SudokuBoard();
        Validator validator = new Validator(board);
        while (true) {
            System.out.println(board);
            ElementDto elementDto = ioController.getElement();
            if(validator.validateRowCols(elementDto)) {
                board.setValue(elementDto);
            }
        }
    }

    public boolean resolveSudoku() {
        return true;
    }
}
