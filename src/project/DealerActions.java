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
     * @return
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

    public static String dealerPlay(Deck deck, Dealer dealer) {
        while (BlackJackActions.calculateValue(dealer) <= 17) {
            hit(deck, dealer);
        }
        return PlayerActions.playerHandString(dealer);
    }
}
