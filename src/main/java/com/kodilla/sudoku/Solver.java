package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solver {

    private final Board board;
    private final Validator validator;
    private final Deque<GameStateDto> backtrack = new ArrayDeque<>();

    public Solver(Board board) {
        this.board = board;
        this.validator = new Validator(board);
    }

    public boolean solve() {
        boolean isSolved = false;

        while (!isSolved) {
            boolean progress = false;

            for (int row = 0; row < Board.BOARD_SIZE; row++) {
                for (int col = 0; col < Board.BOARD_SIZE; col++) {
                    Element element = board.getCell(row, col);
                    if (element.getValue() != Element.EMPTY) continue;
                    try {
                        if (validateElements(element, row, col)) progress = true;
                    } catch (SudokuException e) {
                        //obsługa wyjątku do implementacji
                    }
                    System.out.println(board);
                }
            }
            if (!progress) {
                if (!guess()) {
                    System.out.println("UNABLE TO SOLVE");
                }
            }
            if (board.isBoardFull()) {
                isSolved = true;
                System.out.println("SUCESS!");
                System.out.println(board);
            }
        }
        return isSolved;
    }

    private boolean validateElements(Element element, int row, int col) throws SudokuException {
        boolean progress = false;
        List<Integer> possibleValues = element.getPossibleValues();

        for (int i = 0; i < possibleValues.size(); i++) {
            int possibleValue = possibleValues.get(i);

            if (!validator.validate(row, col, possibleValue)) {
                element.removePossibleValue(possibleValue);
                progress = true;
                i--;
                if (possibleValues.size() == 1) {
                    element.setValue(possibleValues.getFirst());
                    break;
                }
            }

            if (validator.validate(row, col, possibleValue) && !validator.validatePossibleValue(row, col, possibleValue)) {
                element.setValue(possibleValue);
                progress = true;
                break;
            }

            if (!validator.validate(row, col, possibleValue) && possibleValues.size() == 1) {
                throw new SudokuException("Unable to solve");
            }
        }
        return progress;
    }

    private boolean guess() {
        boolean isEmptyCellFound = false;

        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                Element element = board.getCell(i, j);

                if (element.getValue() == Element.EMPTY) {
                    int possibleValue = element.getPossibleValues().getFirst();
                    GameStateDto gameState = new GameStateDto(board, i, j, possibleValue);
                    backtrack.push(gameState);
                    element.setValue(possibleValue);
                    isEmptyCellFound = true;
                    break;
                }
            }
            if (isEmptyCellFound) break;
        }
        return isEmptyCellFound;
    }
}
