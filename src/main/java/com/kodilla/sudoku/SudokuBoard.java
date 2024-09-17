package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    public final static int NUM_ROWS = 9;
    private final List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < NUM_ROWS; i++) {
            rows.add(new SudokuRow());
        }
    }

    public void setValue(ElementDto dto) {
        rows.get(dto.row() - 1).getElements().get(dto.column() - 1).setValue(dto.value());
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < rows.size(); row++) {
            if (row % 3 == 0 && row != 0) {
                builder.append("------+-------+-------").append("\n");
            }

            for (int col = 0; col < rows.getFirst().getElements().size(); col++) {
                if (col % 3 == 0 && col != 0) {
                    builder.append("| ");
                }

                builder.append(rows.get(row).getElements().get(col)).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
