package project.cards;

/**
 * A class that represents a deck of cards
 *
 * @author megha,2020
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/23
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52);
    }

    public void generateDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                showCards().add(new Card(r, s));
            }
        }
    }

    public void drawCard(Hand h) {
        h.showCards().add(this.showCards().get(this.showCards().size() - 1));
        this.showCards().remove(this.showCards().size() - 1);
    }
}
