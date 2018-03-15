/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author s4792424
 */
public class TUI {

    private static final int NO_CHOICE = 0;
    private static final int PLAY_GAME = 1;
    private static final int EXIT = 2;

    private Player user;
    private Player computer;
    private Board board;
    private Game game;
    private Scanner in;

    public TUI() {
        this.user = new HumanPlayer("user");
        this.computer = new AutomatedPlayer("computer");
        this.game = null;
        this.in = new Scanner(System.in);
        this.board = new Board();
    }

    public void start() {
        int choice = NO_CHOICE;
        while (choice != EXIT) {
            displayMainMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }
    }

    private void playGame(boolean userPlaysFirst) {
        if (userPlaysFirst) {
            game = new Game(user, computer);
        } else {
            game = new Game(computer, user);
        }
        while (!game.stop()) {
            game.play();
        }
        if (game.winning()) {
            reportWinner(game.winner());
            System.out.println("winner!!!");
        }
        if (game.draw()) {
            reportDraw();
        }
        System.exit(0);
    }

    private void displayMainMenu() {
        System.out.println();
        System.out.println("Enter the number denoting the action to perform: ");
        System.out.println("Run game..............." + PLAY_GAME);
        System.out.println("Exit..................." + EXIT);
    }

    private void executeChoice(int choice) {
        System.out.println();
        if (choice == PLAY_GAME) {
            boolean userPlaysFirst = readYes("User plays first? (Key yes or no): ");
            playGame(userPlaysFirst);
        } else if (choice == EXIT) {
            System.out.println("Good-bye.");
        }
    }

    private boolean readYes(String prompt) {
        String input = "";
        while (!(input.equals("yes") || input.equals("no"))) {
            System.out.print(prompt);
            System.out.flush();
            input = in.next();
            input = input.toLowerCase();
            in.nextLine();
        }
        return input.equals("yes");
    }

    private void reportWinner(Player player) {
        System.out.println();
        System.out.println("Player " + player.name() + " wins.");
        System.out.println();
    }

    private String reportDraw() {
        return "It's a draw!";
    }

    private int readIntWithPrompt(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        while (!in.hasNextInt()) {
            in.nextLine();
            System.out.print(prompt);
            System.out.flush();
        }
        int input = in.nextInt();
        in.nextLine();
        return input;
    }

}
