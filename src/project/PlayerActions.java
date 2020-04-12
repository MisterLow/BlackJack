package project;

import project.cards.CardActions;
import project.cards.Deck;

/**
 *
 * @author Alexander
 */
public abstract class PlayerActions {

    /**
     *
     * @param deck
     * @param player
     */
    public static void hit(Deck deck, Player player) {
        CardActions.moveCard(deck, player.getHand());
    }
    
        /**
     *
     * @param player
     * @return
     */
    public static String playerHandString(Player player) {
        String handString = player.getPlayerID() + "'s hand contains: \n";
        for (int i = 0; i < player.getHand().getSize(); i++) {
            handString += player.getHand().getCards().get(i).toString() + "\n";
        }
        handString += "Which is a value of " + BlackJackActions.calculateValue(player) + "\n";
        return handString;
    }
}
