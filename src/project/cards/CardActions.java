package project.cards;

/**
 * A class for the interactions between GroupOfCards 
 * @author Alexander
 */
public class CardActions {

    /**
     * Move a card from the first place in this Grouping to another Grouping
     *
     * @param oldLocation
     * @param newLocation The GroupOfCards that you wish to move a Card into
     */
    public static void moveCard(GroupOfCards oldLocation, GroupOfCards newLocation) {
        moveCard(oldLocation, newLocation, 0);
    }

    /**
     * Move a card from this Grouping to another Grouping
     *
     * @param oldLocation
     * @param newLocation The GroupOfCards that you wish to move a Card into
     * @param cardLocation The location in the current GroupOfCards that you
     * wish to remove the card from.
     */
    public static void moveCard(GroupOfCards oldLocation, GroupOfCards newLocation, int cardLocation) {
        newLocation.getCards().add(oldLocation.getCards().get(cardLocation));
        oldLocation.getCards().remove(cardLocation);
    }

    /**
     * Move cards from the beginning of the Grouping to another Grouping
     *
     * @param oldLocation
     * @param amount The amount of cards you wish to move
     * @param newLocation The GroupOfCards that you wish to move a Card into
     */
    public static void moveCards(GroupOfCards oldLocation, GroupOfCards newLocation, int amount) {
        for (int i = 0; i < amount; i++) {
            moveCard(oldLocation, newLocation);
        }
    }

}
