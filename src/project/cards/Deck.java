package project.cards;

/**
 * A class that represents a deck of cards
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/23
 */
public class Deck extends GroupOfCards {

    private int deckAmount;

    /**
     * The default constructor that will generate 1 deck of cards
     */
    public Deck() {
        this(1);
    }

    /**
     * Generate as many Decks as needed
     * @param deckAmount
     */
    public Deck(int deckAmount) {
        super(deckAmount * 52);
        this.deckAmount = deckAmount;
        generateDeck();
    }

    /**
     * Generate a standard deck of cards
     */
    public void generateDeck() {
        for (int i = 0; i < deckAmount; i++) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    showCards().add(new Card(r, s));
                }
            }
        }
    }

    /**
     * Reset the deck to default
     */
    public void resetDeck() {
        clearCards();
        generateDeck();
    }
}
