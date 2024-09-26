package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<Element> elements = new ArrayList<>();

    public Row() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            elements.add(new Element());
        }
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
