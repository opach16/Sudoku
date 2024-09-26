package com.kodilla.sudoku;

public class Game {

    private final IOController ioController = new IOController();

    public void play(Board board) {
        Solver solver = new Solver(board);
        try {
            solver.solve();
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%%%%%    ERROR    %%%%%%%%%%%%%%%%%%");
        }
    }

    public void playWithUserInput(Board board) {
        Solver solver = new Solver(board);
        Validator validator = new Validator(board);

        while (true) {
            System.out.println(board);
            ElementResponse response = ioController.getElement();
            if (!response.isSudoku()) {
                ElementDto elementDto = response.elementDto();
                if (validator.validate(elementDto)) {
                    board.setValue(elementDto);
                }
            } else if (solver.solve()) {
                break;
            }
        }
    }

    public boolean resolveSudoku() {
        return ioController.playAgain();
    }
}
