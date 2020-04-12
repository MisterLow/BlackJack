package project;

import project.cards.Deck;

/**
 *
 * @author Alexander
 */
public class BlackJackPlayerActions extends PlayerActions {

    /**
     *
     * @param user
     */
    public static void stand(BlackJackPlayer user) {
        user.setInRound(false);
    }

    /**
     *
     * @param deck
     * @param user
     */
    public static void doubleDown(Deck deck, BlackJackPlayer user) {
        try {
            if (user.getCurrentBet() < user.getMoney()) {
                user.setCurrentBet(user.getCurrentBet());
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        hit(deck, user);
        stand(user);
    }

}
