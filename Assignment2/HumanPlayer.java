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
public class HumanPlayer implements Player {

    private int rowNumber;
    private int colNumber;
    private String name;               
    private PlayerController playerController;

    public HumanPlayer(String name) {
        this.name = name;
        playerController = new PlayerController(this);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void takeTurn(Board board) {
        playerController.update(this);
        board.setValueHuman(rowNumber, colNumber);
    }

    public void setRowNumber(int row) {
        this.rowNumber = row;
    }

    public void setColumnNumber(int column) {
        this.colNumber = column;
    }

}
