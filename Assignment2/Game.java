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
public class Game {

    private Player player1;                      
    private Player player2;
    private Player nextPlayer;                  
    private Player previousPlayer;              
    private Board board;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1;
        this.previousPlayer = null;
        this.board = new Board();
    }

    public Player nextPlayer() {
        return nextPlayer;
    }

    public Player previousPlayer() {
        return previousPlayer;
    }

    public Player winner() {
        if (!board.winning()) {
            return otherPlayer(previousPlayer);
        } else {
            return previousPlayer;
        }
    }

    public void play() {
        if (!winning() && !draw()) {
            nextPlayer.takeTurn(board);
            previousPlayer = nextPlayer;
            nextPlayer = otherPlayer(nextPlayer);
            board.printBoard();
        }
    }

    public boolean stop() {
        return board.winning() || board.draw();
    }
    
    public boolean draw(){
        return board.draw();
    }
    
    public boolean winning(){
        return board.winning();
    }
    
    
    @Override
    public String toString() {
        return "Game with players: " + player1 + ", and "
                + player2;
    }

    private Player otherPlayer(Player player) {
        if (player == player1) {
            return player2;
        } else {
            return player1;
        }
    }

}
