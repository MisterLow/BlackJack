package project.cards;

/**
 * A class to model a standard playing card
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/23
 */
public class Card {
    //default modifier for child classes

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }
}
