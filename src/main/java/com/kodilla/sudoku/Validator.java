package com.kodilla.sudoku;

import java.util.List;

public class Validator {

    private SudokuBoard board;

    public Validator(SudokuBoard board) {
        this.board = board;
    }

    public boolean validateRows(ElementDto element) {
        List<SudokuRow> rows = board.getRows();

       return rows.stream()
                .skip(element.row() - 1)
                .limit(1)
                .flatMap(n -> n.getElements().stream())
                .noneMatch(e -> e.getValue() == element.value());
    }

    public boolean validateColumns(ElementDto element) {
        List<SudokuRow> rows = board.getRows();

        return rows.stream()
                .flatMap(n -> n.getElements().stream()
                        .skip(element.column() - 1)
                        .limit(1))
                .noneMatch(e -> e.getValue() == element.value());
    }

    public boolean validateRowCols(ElementDto element) {
        List<SudokuRow> rows = board.getRows();

        return validateRows(element) && validateColumns(element);
    }
}
