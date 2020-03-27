package project.cards;

/**
 * A class that represents a player's hand
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/25
 */
public class Hand extends GroupOfCards {

    public Hand() {
        super(12); // The maximum size of a hand with one deck of cards is 12
    }
    
    public void clearHand(){
        showCards().clear();
    }
    
}
