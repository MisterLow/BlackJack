package project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public int getSize(){
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
     * @param drawLocation The GroupOfCards that you wish to move a Card into
     */
    public void moveCard(GroupOfCards drawLocation){
        moveCard(drawLocation,0);
    }
    
    /**
     * Move a card from this Grouping to another Grouping
     * @param drawLocation The GroupOfCards that you wish to move a Card into
     * @param cardLocation The location in the current GroupOfCards that you 
     *          wish to remove the card from.
     */
    public void moveCard(GroupOfCards drawLocation,int cardLocation){
        drawLocation.cards.add(this.cards.get(cardLocation));
        this.cards.remove(cardLocation);
    }
    
    /**
     * 
     */
    public void clearCards(){
        this.cards.clear();
    }
}//end class
