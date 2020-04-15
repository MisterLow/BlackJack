package project;

import java.util.ArrayList;
import java.util.Iterator;
import project.cards.Card;

/**
 *
 * @author Alexander
 */
public class BlackJackActions {

    /**
     * Get all users with the closest hand to 21
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
            if (PlayerActions.calculateValue(currPlayer) <= 21 && PlayerActions.calculateValue(currPlayer) >= closestValue) {
                closestValue = PlayerActions.calculateValue(currPlayer);
                winnerList.add(currPlayer);
            }
        }

        // Remove any Players who don't have the highest hand value
        Iterator<BlackJackPlayer> itPlayer = winnerList.iterator();
        while (itPlayer.hasNext()) {
            BlackJackPlayer user = itPlayer.next();
            if (PlayerActions.calculateValue(user) < closestValue) {
                itPlayer.remove();
            }
        }

        return winnerList;
    }

}
