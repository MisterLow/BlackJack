package project;

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
