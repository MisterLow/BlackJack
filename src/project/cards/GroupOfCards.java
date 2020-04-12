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
public abstract class GroupOfCards {

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
        return getCards();
    }

    public void shuffle() {
        Collections.shuffle(getCards());
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return this.getCards().size();
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    private void setSize(int givenSize) {
        size = givenSize;
    }

    /**
     * Remove all cards from the grouping
     */
    public void clearCards() {
        this.getCards().clear();
    }

    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
}
