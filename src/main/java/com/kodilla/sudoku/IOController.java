package com.kodilla.sudoku;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOController {

    private final static Scanner SCANNER = new Scanner(System.in);

    private String getValueFromUser() {
        String userInput;
        while (true) {
            System.out.print("Your choice: ");
            userInput = SCANNER.nextLine();
            if (userInput.equalsIgnoreCase("SUDOKU")) {
                return userInput;
            }
            try {
                int userNumericInput = Integer.parseInt(userInput);
                if (userNumericInput > 99 && userNumericInput < 1000) {
                    break;
                } else {
                    System.out.println("Please enter a number between 100 and 999!");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a number between 100 and 999 or 'SUDOKU'!");
            }
        }
        return userInput;
    }


    public ElementResponse getElement() {
        String valueFromUser = getValueFromUser();
        if (valueFromUser.equalsIgnoreCase("SUDOKU")) {
            return new ElementResponse(true, null);
        }
        int userInput = Integer.parseInt(valueFromUser);
        int row = (userInput / 100) % 10;
        int col = (userInput / 10) % 10;
        int value = userInput % 10;
        return new ElementResponse(false, new ElementDto(row, col, value));
    }

    public boolean playAgain() {
        while (true) {
            System.out.println("Press enter to play again or 'X' to exit ");
            try {
                String userInput = SCANNER.nextLine();
                if (userInput.equalsIgnoreCase("X")) {
                    System.exit(0);
                } else if (userInput.isEmpty()) {
                    return false;
                }
            } catch (InputMismatchException ignored) {
                System.out.println("Please press enter or 'X' to exit ");
            }
        }
    }
}
