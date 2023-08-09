/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

import java.util.Collections;
import java.util.List;

class PlayerDealer extends Player {
    @Override
    public int calculateHandValue() {
        int value = 0;
        for (String card : hand) {
            String cardValue = card.split(" ")[0];
            if (!cardValue.equals("A")) {
                if (cardValue.equals("K") || cardValue.equals("Q") || cardValue.equals("J")) {
                    value += 10;
                } else {
                    value += Integer.parseInt(cardValue);
                }
            }
        }
        return value;
    }
}