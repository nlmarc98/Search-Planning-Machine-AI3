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
public class AutomatedPlayer implements Player {

    private String name;       // this Player's name.
    private Board board = new Board();
    private int rowNumber;
    private int colNumber;

    public AutomatedPlayer(String name) {
        this.name = name;
    }

    /**
     * This Player's name.
     */
    public String name() {
        return name;
    }

    public void takeTurn(Board board) {
        Valuex[][] fieldCopy = board.copy();
        //block fork
        if (fieldCopy[0][0] == Valuex.KRUISJE && (fieldCopy[0][1] == Valuex.EMPTY && fieldCopy[0][2] == Valuex.EMPTY && fieldCopy[1][0] == Valuex.EMPTY && fieldCopy[1][1] == Valuex.EMPTY && fieldCopy[1][2] == Valuex.EMPTY && fieldCopy[2][0] == Valuex.EMPTY && fieldCopy[2][1] == Valuex.EMPTY && fieldCopy[2][2] == Valuex.EMPTY)) {
            board.setValueComputer(1, 1);
        } else if (fieldCopy[0][2] == Valuex.KRUISJE && (fieldCopy[0][1] == Valuex.EMPTY && fieldCopy[0][0] == Valuex.EMPTY && fieldCopy[1][0] == Valuex.EMPTY && fieldCopy[1][1] == Valuex.EMPTY && fieldCopy[1][2] == Valuex.EMPTY && fieldCopy[2][0] == Valuex.EMPTY && fieldCopy[2][1] == Valuex.EMPTY && fieldCopy[2][2] == Valuex.EMPTY)) {
            board.setValueComputer(1, 1);
        } else if (fieldCopy[2][0] == Valuex.KRUISJE && (fieldCopy[0][1] == Valuex.EMPTY && fieldCopy[0][2] == Valuex.EMPTY && fieldCopy[1][0] == Valuex.EMPTY && fieldCopy[1][1] == Valuex.EMPTY && fieldCopy[1][2] == Valuex.EMPTY && fieldCopy[0][0] == Valuex.EMPTY && fieldCopy[2][1] == Valuex.EMPTY && fieldCopy[2][2] == Valuex.EMPTY)) {
            board.setValueComputer(1, 1);
        } else if (fieldCopy[2][2] == Valuex.KRUISJE && (fieldCopy[0][1] == Valuex.EMPTY && fieldCopy[0][2] == Valuex.EMPTY && fieldCopy[1][0] == Valuex.EMPTY && fieldCopy[1][1] == Valuex.EMPTY && fieldCopy[1][2] == Valuex.EMPTY && fieldCopy[2][0] == Valuex.EMPTY && fieldCopy[2][1] == Valuex.EMPTY && fieldCopy[0][0] == Valuex.EMPTY)) {
            board.setValueComputer(1, 1);
        } //block
        else if (checkValues(fieldCopy[0][0], fieldCopy[0][1], fieldCopy[0][2]) == true) {
            board.setValueComputer(0, 2);
        } else if (checkValues(fieldCopy[0][1], fieldCopy[0][2], fieldCopy[0][0]) == true) {
            board.setValueComputer(0, 0);
        } else if (checkValues(fieldCopy[1][0], fieldCopy[1][1], fieldCopy[1][2]) == true) {
            board.setValueComputer(1, 2);
        } else if (checkValues(fieldCopy[0][2], fieldCopy[2][2], fieldCopy[1][2]) == true) {
            board.setValueComputer(1, 2);
        } else if (checkValues(fieldCopy[1][1], fieldCopy[1][2], fieldCopy[1][0]) == true) {
            board.setValueComputer(1, 0);
        } else if (checkValues(fieldCopy[0][0], fieldCopy[0][2], fieldCopy[0][1]) == true) {
            board.setValueComputer(0, 1);
        } else if (checkValues(fieldCopy[1][0], fieldCopy[1][2], fieldCopy[1][1]) == true) {
            board.setValueComputer(1, 1);
        } else if (checkValues(fieldCopy[2][0], fieldCopy[2][2], fieldCopy[2][1]) == true) {
            board.setValueComputer(2, 1);
        } else if (checkValues(fieldCopy[0][0], fieldCopy[2][0], fieldCopy[1][0]) == true) {
            board.setValueComputer(1, 0);
        } else if (checkValues(fieldCopy[0][1], fieldCopy[2][1], fieldCopy[1][1]) == true) {
            board.setValueComputer(1, 1);
        } else if (checkValues(fieldCopy[0][2], fieldCopy[1][2], fieldCopy[2][2]) == true) {
            board.setValueComputer(2, 2);
        } else if (checkValues(fieldCopy[2][0], fieldCopy[2][1], fieldCopy[2][2]) == true) {
            board.setValueComputer(2, 2);
        } else if (checkValues(fieldCopy[2][1], fieldCopy[2][2], fieldCopy[2][0]) == true) {
            board.setValueComputer(2, 0);
        } else if (checkValues(fieldCopy[0][0], fieldCopy[1][0], fieldCopy[2][0]) == true) {
            board.setValueComputer(2, 0);
        } else if (checkValues(fieldCopy[1][0], fieldCopy[2][1], fieldCopy[0][0]) == true) {
            board.setValueComputer(0, 0);
        } else if (checkValues(fieldCopy[0][1], fieldCopy[1][1], fieldCopy[2][1]) == true) {
            board.setValueComputer(2, 1);
        } else if (checkValues(fieldCopy[1][1], fieldCopy[2][1], fieldCopy[0][2]) == true) {
            board.setValueComputer(0, 2);
        } else if (checkValues(fieldCopy[0][2], fieldCopy[1][2], fieldCopy[2][2]) == true) {
            board.setValueComputer(2, 2);
        } else if (checkValues(fieldCopy[1][2], fieldCopy[2][2], fieldCopy[0][2]) == true) {
            board.setValueComputer(0, 2);
        } else if (checkValues(fieldCopy[1][1], fieldCopy[0][0], fieldCopy[2][2]) == true) {
            board.setValueComputer(2, 2);
        } else if (checkValues(fieldCopy[1][1], fieldCopy[2][2], fieldCopy[0][0]) == true) {
            board.setValueComputer(0, 0);
        } else if (checkValues(fieldCopy[1][1], fieldCopy[2][0], fieldCopy[0][2]) == true) {
            board.setValueComputer(0, 2);
        } else if (checkValues(fieldCopy[1][1], fieldCopy[0][2], fieldCopy[2][0]) == true) {
            board.setValueComputer(2, 0);
        } //win
        else if (fieldCopy[0][0] == Valuex.EMPTY) {
            board.setValueComputer(0, 0);
        } else if (fieldCopy[2][0] == Valuex.EMPTY) {
            board.setValueComputer(2, 0);
        } else if (fieldCopy[0][2] == Valuex.EMPTY) {
            board.setValueComputer(0, 2);
        } else if (fieldCopy[2][2] == Valuex.EMPTY) {
            board.setValueComputer(2, 2);
        } else if (fieldCopy[2][2] == Valuex.EMPTY && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][0] == Valuex.RONDJE) {
            board.setValueComputer(2, 2);
        } else if (fieldCopy[2][0] == Valuex.EMPTY && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[0][2] == Valuex.RONDJE) {
            board.setValueComputer(2, 0);
        } else if (fieldCopy[0][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[0][1] == Valuex.EMPTY) {
            board.setValueComputer(0, 1);
        } else if (fieldCopy[0][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[1][1] == Valuex.EMPTY) {
            board.setValueComputer(1, 1);
        } else if (fieldCopy[0][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[1][2] == Valuex.EMPTY) {
            board.setValueComputer(1, 2);
        } else if (fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][0] == Valuex.RONDJE && fieldCopy[1][0] == Valuex.EMPTY) {
            board.setValueComputer(1, 0);
        } else if (fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][0] == Valuex.RONDJE && fieldCopy[2][1] == Valuex.EMPTY) {
            board.setValueComputer(2, 1);
        } else if (fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][0] == Valuex.RONDJE && fieldCopy[1][1] == Valuex.EMPTY) {
            board.setValueComputer(1, 1);
        } else if (fieldCopy[2][2] == Valuex.RONDJE && fieldCopy[0][0] == Valuex.RONDJE && fieldCopy[2][0] == Valuex.RONDJE && fieldCopy[1][1] == Valuex.EMPTY) {
            board.setValueComputer(1, 1);
        }
    }

    public boolean checkValues(Valuex v1, Valuex v2, Valuex v3) {
        return ((v1 == Valuex.KRUISJE) && (v2 == Valuex.KRUISJE) && (v3 == Valuex.EMPTY));
    }
}