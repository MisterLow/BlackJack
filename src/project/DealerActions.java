package project;

import project.cards.Deck;

/**
 *
 * @author Alexander
 */
public class DealerActions extends PlayerActions {

    /**
     *
     * @param dealer
     * @return A string representing the Dealer's hand, with the first card
     * hidden
     */
    public static String playerHandString(Player dealer) {
        String handString = "Dealer's hand contains: \n";
        for (int i = 0; i < dealer.getHand().getSize(); i++) {
            switch (i) {
                case 0:
                    handString += "Facedown Card\n";
                    break;
                default:
                    handString += dealer.getHand().getCards().get(i).toString() + "\n";
            }
        }
        return handString;
    }

    /**
     * The dealer will continuously hit while the Dealer's hand's value is under
     * 17
     *
     * @param deck
     * @param dealer
     * @throws Exception
     */
    public static void dealerPlay(Deck deck, Dealer dealer) throws Exception {
        while (calculateValue(dealer) <= 17) {
            hit(deck, dealer);
        }
    }
}
