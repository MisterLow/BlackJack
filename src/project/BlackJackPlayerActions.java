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
     * Let the Player double down if they have enough money from
     * @param deck
     * @param user
     */
    public static void doubleDown(Deck deck, BlackJackPlayer user) throws Exception {
        if (user.getCurrentBet() < user.getMoney()) {
            user.setCurrentBet(user.getCurrentBet());
        }
        hit(deck, user);
        stand(user);
    }

}
