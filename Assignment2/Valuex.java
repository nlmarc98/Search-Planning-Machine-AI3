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
public enum Valuex {

    RONDJE, KRUISJE, EMPTY;

    public String toString() {
        switch (this) {
            case RONDJE:
                return "O";
            case KRUISJE:
                return "X";
            case EMPTY:
                return " ";
            default:
                break;
        }
        return " ";
    }
}
