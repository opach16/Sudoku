package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuElement {

    private int value;
    public final static int EMPTY = -1;
    private List<Integer> possibleValue = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public SudokuElement() {
        this.value = EMPTY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValue() {
        return possibleValue;
    }

    @Override
    public String toString() {
        return value == EMPTY ? " " : String.valueOf(value);
    }
}
