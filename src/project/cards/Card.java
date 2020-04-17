package project.cards;

/**
 * A class to model a standard playing card
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/23
 */
public class Card {

    private final Rank rank;
    private final Suit suit;

    /**
     *
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return the rank
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * A method to turn a Card object into a String representation of itself
     * @return A string approximation of the Card
     */
    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }

    public boolean equals(Card c) {
        return this.getRank() == c.getRank() && this.getSuit() == c.getSuit();
    }
}
