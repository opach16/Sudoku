package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Element {

    private int value;
    public final static int EMPTY = -1;
    private List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public Element() {
        this.value = EMPTY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public void removePossibleValue(int value) {
        possibleValues.remove(Integer.valueOf(value));
    }

    @Override
    public String toString() {
        return value == EMPTY ? " " : String.valueOf(value);
    }
}
