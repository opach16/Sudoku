package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Board extends Prototype<Board> {

    public final static int BOARD_SIZE = 9;
    private List<Row> board = new ArrayList<>();

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Row());
        }
    }

    public List<Row> getBoard() {
        return board;
    }

    public Element getCell(int row, int column) {
        return board.get(row).getElements().get(column);
    }

    public void setValue(ElementDto dto) {
        board.get(dto.row() - 1).getElements().get(dto.column() - 1).setValue(dto.value());
    }

    public void setValue(int row, int column, int value) {
        board.get(row).getElements().get(column).setValue(value);
    }

    public boolean isBoardFull() {
        return board.stream()
                .flatMap(n -> n.getElements().stream())
                .noneMatch(n -> n.getValue() == Element.EMPTY);
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonnedBoard = super.clone();
        clonnedBoard.board = new ArrayList<>();
        for (Row row : board) {
            Row clonnedRow = new Row();
            clonnedRow.setElements(new ArrayList<>());
            for (Element element : row.getElements()) {
                Element clonnedElement = new Element();
                clonnedElement.setPossibleValues(new ArrayList<>());
                for (Integer possibleValue : element.getPossibleValues()) {
                    clonnedElement.getPossibleValues().add(possibleValue);
                }
                clonnedElement.setValue(element.getValue());
                clonnedRow.getElements().add(clonnedElement);
            }
            clonnedBoard.board.add(clonnedRow);
        }
        return clonnedBoard;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < board.size(); row++) {
            if (row % 3 == 0 && row != 0) {
                builder.append("------+-------+-------").append("\n");
            }

            for (int col = 0; col < board.getFirst().getElements().size(); col++) {
                if (col % 3 == 0 && col != 0) {
                    builder.append("| ");
                }

                builder.append(board.get(row).getElements().get(col)).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
