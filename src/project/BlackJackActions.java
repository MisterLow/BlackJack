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
     * Get the value of the Player's hand
     *
     * @param p The player whose hand you want to check the value of
     * @return the value of the hand in BlackJack
     */
    public static int calculateValue(Player p) {
        int hValue = 0;
        int aceCount = 0;
        for (Card c : p.getHand().showCards()) {
            int cValue = c.getRank().getValue();
            switch (cValue) {
                case 11:
                    cValue = 10;
                    break;
                case 12:
                    cValue = 10;
                    break;
                case 13:
                    cValue = 10;
                    break;
                case 1:
                    aceCount++;
                    break;
            }
            hValue += cValue;
        }
        while (aceCount > 0 && ((hValue+10) <= 21)) {
            hValue += 10;
            aceCount--;
        }
        return hValue;
    }

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
