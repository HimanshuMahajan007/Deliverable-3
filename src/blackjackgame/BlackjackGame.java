/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

import java.util.InputMismatchException;
import java.util.Scanner;


public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!`");

        while (true) {
            Deck deck = new Deck();
            PlayerHuman player = new PlayerHuman();
            PlayerDealer dealer = new PlayerDealer();

            player.addCardToHand(deck.drawCard());
            player.addCardToHand(deck.drawCard());
            dealer.addCardToHand(deck.drawCard());
            dealer.addCardToHand(deck.drawCard());

            // Display hands
            System.out.println("Your hand: " + player.getHand());
            System.out.println("Dealer's hand: [Hidden, " + dealer.getHand().get(1) + "]");

            // Check for Blackjack (21)
            if (player.calculateHandValue() == 21) {
                System.out.println("Blackjack! You win!");
            } else {
                // Player's turn
                while (true) {
                    System.out.print("Do you want to hit or stand? (h/s): ");
                    String choice = scanner.next();

                    try {
                        if (choice.equalsIgnoreCase("h")) {
                            player.addCardToHand(deck.drawCard());
                            System.out.println("Your hand: " + player.getHand());

                            if (player.calculateHandValue() > 21) {
                                System.out.println("Bust! You lose!");
                                break;
                            }
                        } else if (choice.equalsIgnoreCase("s")) {
                            // Dealer's turn
                            while (dealer.calculateHandValue() < 17) {
                                dealer.addCardToHand(deck.drawCard());
                            }

                            // Display hands
                            System.out.println("Your hand: " + player.getHand());
                            System.out.println("Dealer's hand: " + dealer.getHand());

                            // Determine the winner
                            int playerValue = player.calculateHandValue();
                            int dealerValue = dealer.calculateHandValue();

                            if (dealerValue > 21 || playerValue > dealerValue) {
                                System.out.println("You win!");
                            } else if (playerValue < dealerValue) {
                                System.out.println("You lose!");
                            } else {
                                System.out.println("It's a tie!");
                            }

                            break;
                        } else {
                            throw new InputMismatchException("Invalid choice. Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        scanner.nextLine(); // Clear the invalid input from the scanner buffer
                    }
                }
            }

            // Ask to play again
            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Thank you for playing Blackjack!");
        scanner.close();
    }
}