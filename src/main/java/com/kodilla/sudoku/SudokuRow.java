package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    public final static int NUM_COLUMNS = 9;
    private final List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < NUM_COLUMNS; i++) {
            elements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }
}
