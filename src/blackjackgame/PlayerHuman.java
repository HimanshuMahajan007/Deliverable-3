/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

class PlayerHuman extends Player {
    @Override
    public int calculateHandValue() {
        int value = 0;
        int aces = 0;

        for (String card : hand) {
            String cardValue = card.split(" ")[0];
            if (cardValue.equals("A")) {
                aces++;
                value += 11;
            } else if (cardValue.equals("K") || cardValue.equals("Q") || cardValue.equals("J")) {
                value += 10;
            } else {
                value += Integer.parseInt(cardValue);
            }
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }
}