package project.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 *
 * @author megha,2020
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/27
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        setSize(givenSize);
        cards = new ArrayList(size);
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return this.cards.size();
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    private void setSize(int givenSize) {
        size = givenSize;
    }

    /**
     * Move a card from the first place in this Grouping to another Grouping
     *
     * @param newLocation The GroupOfCards that you wish to move a Card into
     */
    public void moveCard(GroupOfCards newLocation) {
        moveCard(newLocation, 0);
    }

    /**
     * Move a card from this Grouping to another Grouping
     *
     * @param newLocation The GroupOfCards that you wish to move a Card into
     * @param cardLocation The location in the current GroupOfCards that you
     * wish to remove the card from.
     */
    public void moveCard(GroupOfCards newLocation, int cardLocation) {
        newLocation.cards.add(this.cards.get(cardLocation));
        this.cards.remove(cardLocation);
    }

    /**
     * Move cards from the beginning of the Grouping to another Grouping
     *
     * @param amount The amount of cards you wish to move
     * @param newLocation The GroupOfCards that you wish to move a Card into
     */
    public void moveCards(GroupOfCards newLocation,int amount) {
        for (int i = 0; i < amount; i++) {
            moveCard(newLocation);
        }
    }

    /**
     *
     */
    public void clearCards() {
        this.cards.clear();
    }
}
