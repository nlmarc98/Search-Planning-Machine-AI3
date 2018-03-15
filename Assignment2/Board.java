/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author s4792424
 */
public class Board {

    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private Valuex[][] field = new Valuex[ROWS][COLUMNS];

    public Board() {
        this.field = field;
        init();
    }

    public Valuex[][] init() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                field[row][col] = Valuex.EMPTY;
            }
        }
        return field;
    }

    public void setValueHuman(int x, int y) {
        field[x][y] = Valuex.KRUISJE;
    }

    public void setValueComputer(int x, int y) {
        field[x][y] = Valuex.RONDJE;
    }

    public void printBoard() {
        System.out.println("----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }

    private boolean checkWinning(Valuex v1, Valuex v2, Valuex v3) {
        return ((v1 != Valuex.EMPTY) && (v1 == v2) && (v2 == v3));
    }

    public boolean winning() {
        for (int i = 0; i < 3; i++) {
            if (checkWinning(field[0][i], field[1][i], field[2][i]) == true) {
                return true;
            }
            if (checkWinning(field[i][0], field[i][1], field[i][2]) == true) {
                return true;
            }
            if (checkWinning(field[0][0], field[1][1], field[2][2]) == true || checkWinning(field[0][2], field[1][1], field[2][0]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean draw() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == Valuex.EMPTY) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public Valuex[][] copy() {
        return field;
    }
}
