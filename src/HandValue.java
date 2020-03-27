
import project.cards.Card;
import project.cards.Hand;

/**
 *
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/27
 */
public class HandValue {

    /**
     *
     * @param hand the hand you wish to check;
     * @return the value of the hand in BlackJack
     */
    public static int check(Hand hand) {
        int hValue = 0;
        int aceCount = 0;
        for (Card c : hand.showCards()) {
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
                    cValue = 11;
                    aceCount++;
                    break;
            }

            while (aceCount > 0 && hValue > 21) {
                hValue -= 10;
                aceCount--;
            }

            hValue += cValue;
        }
        return hValue;
    }
}
