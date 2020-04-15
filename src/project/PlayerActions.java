package project;

import project.cards.CardActions;
import project.cards.Deck;

/**
 *
 * @author Alexander
 */
public abstract class PlayerActions {

    /**
     * Remove a card from the Deck and add it to the Player
     * @param deck
     * @param player
     * @throws java.lang.Exception
     */
    public static void hit(Deck deck, Player player) throws Exception{
        CardActions.moveCard(deck, player.getHand());
    }

    /**
     * Return the Player's hand as a String
     * @param player
     * @return
     */
    public static String playerHandString(Player player) {
        String handString = player.getPlayerID() + "'s hand contains:\n";
        for (int i = 0; i < player.getHand().getSize(); i++) {
            handString += player.getHand().getCards().get(i).toString() + "\n";
        }
        handString += "Which is a value of " + BlackJackActions.calculateValue(player) + "\n";
        return handString;
    }
}
