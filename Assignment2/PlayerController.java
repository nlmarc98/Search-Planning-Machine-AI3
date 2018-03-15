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
public class PlayerController {

    private Scanner in;

    public PlayerController(HumanPlayer player) {
        this.in = new Scanner(System.in);
    }

    public void update(HumanPlayer player) {
        int row = readRow();
        int column = readColumn();
        player.setRowNumber(row);
        player.setColumnNumber(column);
    }

    public int readRow() {
        int number = 0;
        System.out.println("Enter the number of which row");
        if (in.hasNextInt()) {
            number = in.nextInt();
            in.nextLine();
        }
        return number;
    }

    public int readColumn() {
        int number = 0;
        System.out.println("Enter the number of which column");
        if (in.hasNextInt()) {
            number = in.nextInt();
            in.nextLine();
        }
        return number;
    }
}
