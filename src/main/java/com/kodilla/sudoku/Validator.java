package com.kodilla.sudoku;

import java.util.List;

public class Validator {

    private final Board board;

    public Validator(final Board board) {
        this.board = board;
    }

    private boolean validateRow(ElementDto element) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .skip(element.row() - 1)
                .limit(1)
                .flatMap(e -> e.getElements().stream())
                .noneMatch(e -> e.getValue() == element.value());
    }

    private boolean validateRow(int row, int value) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .skip(row)
                .limit(1)
                .flatMap(e -> e.getElements().stream())
                .noneMatch(e -> e.getValue() == value);
    }

    private boolean validateColumn(ElementDto element) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .map(row -> row.getElements().get(element.column() - 1))
                .noneMatch(e -> e.getValue() == element.value());
    }

    private boolean validateColumn(int col, int value) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .map(row -> row.getElements().get(col))
                .noneMatch(e -> e.getValue() == value);
    }

    private boolean validateSection(ElementDto element) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .skip((element.row() - 1) / 3 * 3)
                .limit(3)
                .flatMap(e -> e.getElements().stream()
                        .skip((element.column() - 1) / 3 * 3)
                        .limit(3))
                .noneMatch(e -> e.getValue() == element.value());
    }

    private boolean validateSection(int row, int col, int value) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .skip(row / 3 * 3)
                .limit(3)
                .flatMap(e -> e.getElements().stream()
                        .skip(col / 3 * 3)
                        .limit(3))
                .noneMatch(e -> e.getValue() == value);
    }

    public boolean validate(ElementDto element) {
        return validateRow(element) && validateColumn(element) && validateSection(element);
    }

    public boolean validate(int row, int col, int value) {
        return validateRow(row, value) && validateColumn(col, value) && validateSection(row, col, value);
    }

    private boolean validatePossibleValueInRow(int row, int value) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .skip(row)
                .limit(1)
                .flatMap(e -> e.getElements().stream())
                .flatMap(element -> element.getPossibleValues().stream())
                .noneMatch(possibleValue -> possibleValue == value);
    }

    private boolean validatePossibleValueInColumn(int col, int value) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .flatMap(e -> e.getElements().stream())
                .flatMap(element -> element.getPossibleValues().stream())
                .noneMatch(possibleValue -> possibleValue == value);
    }

    private boolean validatePossibleValueInSection(int row, int col, int value) {
        List<Row> rows = board.getBoard();
        return rows.stream()
                .skip(row / 3 * 3)
                .limit(3)
                .flatMap(e -> e.getElements().stream()
                        .skip(col / 3 * 3)
                        .limit(3))
                .flatMap(element -> element.getPossibleValues().stream())
                .noneMatch(possibleValue -> possibleValue == value);
    }

    public boolean validatePossibleValue(int row, int col, int value) {
        return validatePossibleValueInRow(row, value) &&
                validatePossibleValueInColumn(col, value) &&
                validatePossibleValueInSection(row, col, value);
    }
}
