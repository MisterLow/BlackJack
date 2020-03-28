package project;

import project.cards.Card;
import project.cards.Hand;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author megha,2020
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/27
 */
public abstract class Player {

    private String playerID; //the unique ID for this player
    private Hand hand = new Hand();

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        playerID = name;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    /**
     * Get the value of the player's hand
     *
     * @return the value of the hand in BlackJack
     */
    public int getValue() {
        int hValue = 0;
        int aceCount = 0;
        for (Card c : hand.showCards()) {
            int cValue = c.getRank().getValue();

            switch (cValue) {
                case 11:
                    cValue = 10;
                    break;
                case 12:
                    cValue = 10;
                    break;
                case 13:
                    cValue = 10;
                    break;
                case 1:
                    cValue = 11;
                    aceCount++;
                    break;
            }

            while (aceCount > 0 && hValue > 21) {
                hValue -= 10;
                aceCount--;
            }

            hValue += cValue;
        }
        return hValue;
    }

    public Hand getHand() {
        return this.hand;
    }

    /**
     *
     * @param hand
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

}
