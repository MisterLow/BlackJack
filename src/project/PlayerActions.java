package project;

import project.cards.Card;
import project.cards.CardActions;
import project.cards.Deck;

/**
 *
 * @author Alexander
 */
public abstract class PlayerActions {

    /**
     * Get the value of the Player's hand
     *
     * @param p The player whose hand you want to check the value of
     * @return the value of the hand in BlackJack
     */
    public static int calculateValue(Player p) {
        int hValue = 0;
        int aceCount = 0;
        for (Card c : p.getHand().showCards()) {
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
                    aceCount++;
                    break;
            }
            hValue += cValue;
        }
        while (aceCount > 0 && ((hValue + 10) <= 21)) {
            hValue += 10;
            aceCount--;
        }
        return hValue;
    }

    /**
     * Remove a card from the Deck and add it to the Player
     *
     * @param deck
     * @param player
     * @throws java.lang.Exception
     */
    public static void hit(Deck deck, Player player) throws Exception {
        CardActions.moveCard(deck, player.getHand());
    }

    /**
     * Return the Player's hand as a String
     *
     * @param player
     * @return
     */
    public static String playerHandString(Player player) {
        String handString = player.getPlayerID() + "'s hand contains:\n";
        for (int i = 0; i < player.getHand().getSize(); i++) {
            handString += player.getHand().getCards().get(i).toString() + "\n";
        }
        handString += "Which is a value of " + calculateValue(player) + "\n";
        return handString;
    }
}
