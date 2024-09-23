package com.kodilla.sudoku;

import java.util.List;

public class Validator {

    private final SudokuBoard board;

    public Validator(final SudokuBoard board) {
        this.board = board;
    }

    private boolean validateRow(ElementDto element) {
        List<SudokuRow> rows = board.getRows();
        return rows.stream()
                .skip(element.row() - 1)
                .limit(1)
                .flatMap(e -> e.getElements().stream())
                .noneMatch(e -> e.getValue() == element.value());
    }

    private boolean validateColumn(ElementDto element) {
        List<SudokuRow> rows = board.getRows();
        return rows.stream()
                .map(row -> row.getElements().get(element.column() - 1))
                .noneMatch(e -> e.getValue() == element.value());
    }

    private boolean validateSection(ElementDto element) {
        List<SudokuRow> rows = board.getRows();
        return rows.stream()
                .skip((element.row() -1) / 3 * 3)
                .limit(3)
                .flatMap(e -> e.getElements().stream()
                        .skip((element.column() -1) / 3 * 3)
                        .limit(3))
                .noneMatch(e -> e.getValue() == element.value());
    }

    public boolean validate(ElementDto element) {
        return validateRow(element) && validateColumn(element) && validateSection(element);
    }
}
