package com.kodilla.sudoku;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOController {

    private final static Scanner SCANNER = new Scanner(System.in);

    private int getValueFromUser() {
        int userInput;
        while (true) {
            System.out.print("Your choice: ");
            try {
                userInput = SCANNER.nextInt();
                if (userInput > 99 && userInput < 1000) {
                    break;
                } else {
                    System.out.println("Please enter a number between 100 and 999");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 100 and 999");
                SCANNER.next();
            }
        }
        return userInput;
    }

    public ElementDto getElement() {
        int userInput = getValueFromUser();
        int row = (userInput / 100) % 10;
        int col = (userInput / 10) % 10;
        int value = userInput % 10;
        return new ElementDto(row, col, value);
    }

    public boolean playAgain() {
        while (true) {
            System.out.println("Press enter to play again or 'X' to exit ");
            try {
                String userInput = SCANNER.nextLine();
                if (userInput.equalsIgnoreCase("X")) {
                    System.exit(1);
                } else if (userInput.isEmpty()) {
                    return true;
                }
            } catch (InputMismatchException ignored) {
                System.out.println("Please press enter or 'X' to exit ");
            }
        }
    }
}
