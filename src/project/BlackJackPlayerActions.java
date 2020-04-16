package project;

import java.util.ArrayList;
import java.util.Iterator;
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
     *
     * @param deck
     * @param user
     * @throws java.lang.Exception
     */
    public static void doubleDown(Deck deck, BlackJackPlayer user) throws Exception {
        if (user.getCurrentBet() < user.getMoney()) {
            user.setCurrentBet(user.getCurrentBet());
        }
        hit(deck, user);
        stand(user);
    }

    /**
     * Get all BlackJackPlayers with the closest hand to 21
     *
     * @param users
     * @return An ArrayList containing all the players with a hand that's value
     * is 21 or the number closest to it
     */
    public static ArrayList<BlackJackPlayer> getWinners(ArrayList<BlackJackPlayer> users) {
        ArrayList<BlackJackPlayer> winnerList = new ArrayList<>();
        // First find the player with the closest value to 21
        int closestValue = 0;
        for (BlackJackPlayer currPlayer : users) {
            if (calculateValue(currPlayer) <= 21 && calculateValue(currPlayer) >= closestValue) {
                closestValue = calculateValue(currPlayer);
                winnerList.add(currPlayer);
            }
        }
        // Remove any Players who don't have the highest hand value
        Iterator<BlackJackPlayer> itPlayer = winnerList.iterator();
        while (itPlayer.hasNext()) {
            BlackJackPlayer user = itPlayer.next();
            if (calculateValue(user) < closestValue) {
                itPlayer.remove();
            }
        }

        return winnerList;
    }
}
