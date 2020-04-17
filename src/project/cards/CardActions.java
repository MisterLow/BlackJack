package project.cards;

import project.cards.Card;
import project.cards.GroupOfCards;

/**
 * A class for the interactions between different GroupOfCards objects
 *
 * @author Alexander
 */
public class CardActions {

    /**
     * Move a card from the first place in this Grouping to another Grouping
     *
     * @param oldLocation
     * @param newLocation The GroupOfCards that you wish to move a Card into
     * @throws java.lang.Exception
     */
    public static void moveCard(GroupOfCards oldLocation, GroupOfCards newLocation) throws Exception {
        if (oldLocation.getSize() == 0) {
            throw new Exception("You cannot move cards from an empty group");
        }
        Card c = oldLocation.getCards().get(0);
        newLocation.getCards().add(c);
        oldLocation.getCards().remove(c);
    }

    /**
     * Move cards from the beginning of the Grouping to another Grouping
     *
     * @param oldLocation Thee GroupOfCards that you are moving a Card from
     * @param amount The amount of cards you wish to move
     * @param newLocation The GroupOfCards that you wish to move a Card into
     * @throws java.lang.Exception
     */
    public static void moveCards(GroupOfCards oldLocation, GroupOfCards newLocation, int amount) throws Exception {
        for (int i = 0; i < amount; i++) {
            moveCard(oldLocation, newLocation);
        }
    }
}
