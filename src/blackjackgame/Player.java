/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

import java.util.*;

abstract class Player {
    protected List<String> hand = new ArrayList<>();

    public void addCardToHand(String card) {
        hand.add(card);
    }

    public List<String> getHand() {
        return hand;
    }

    public abstract int calculateHandValue();
}