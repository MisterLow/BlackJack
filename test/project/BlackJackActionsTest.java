package project;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import project.cards.Card;
import project.cards.Rank;
import project.cards.Suit;

/**
 *
 * @author Alexander
 */
public class BlackJackActionsTest {

    public BlackJackActionsTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of getWinners method, of class BlackJackActions.
     */
    @Test
    public void testGetWinnersAll() {
        System.out.println("getWinners");
        Card c1 = new Card(Rank.Ace, Suit.Clubs);
        Card c2 = new Card(Rank.Jack, Suit.Diamonds);

        BlackJackPlayer p1 = new BlackJackPlayer("Test");
        p1.getHand().getCards().add(c1);
        p1.getHand().getCards().add(c2);

        BlackJackPlayer p2 = new BlackJackPlayer("Test2");
        p2.getHand().getCards().add(c1);
        p2.getHand().getCards().add(c2);

        ArrayList<BlackJackPlayer> users = new ArrayList<>();
        users.add(p1);
        users.add(p2);

        boolean expResult = true;

        ArrayList<BlackJackPlayer> result = BlackJackActions.getWinners(users);
        boolean match = result.containsAll(users);
        assertEquals(expResult, match);
    }

    /**
     * Test of getWinners method, of class BlackJackActions.
     */
    @Test
    public void testGetWinnersOne() {
        System.out.println("testGetWinnersOne");
        Card c1 = new Card(Rank.Ace, Suit.Clubs);
        Card c2 = new Card(Rank.Jack, Suit.Diamonds);
        Card c3 = new Card(Rank.Two, Suit.Diamonds);

        BlackJackPlayer p1 = new BlackJackPlayer("Test");
        p1.getHand().getCards().add(c1);
        p1.getHand().getCards().add(c2);

        BlackJackPlayer p2 = new BlackJackPlayer("Test2");
        p2.getHand().getCards().add(c1);
        p2.getHand().getCards().add(c3);

        ArrayList<BlackJackPlayer> users = new ArrayList<>();
        users.add(p1);
        users.add(p2);

        ArrayList<BlackJackPlayer> result = BlackJackActions.getWinners(users);
        assertEquals(true, result.contains(p1));
        assertEquals(false, result.contains(p2));
    }

    /**
     * Test of getWinners method, of class BlackJackActions.
     */
    @Test
    public void testGetWinnersNone() {
        System.out.println("testGetWinnersNone");
        Card c1 = new Card(Rank.Ace, Suit.Clubs);
        Card c2 = new Card(Rank.Jack, Suit.Diamonds);

        BlackJackPlayer p1 = new BlackJackPlayer("Test");
        p1.getHand().getCards().add(c2);
        p1.getHand().getCards().add(c2);
        p1.getHand().getCards().add(c2);

        BlackJackPlayer p2 = new BlackJackPlayer("Test2");
        p2.getHand().getCards().add(c2);
        p2.getHand().getCards().add(c2);
        p2.getHand().getCards().add(c2);

        ArrayList<BlackJackPlayer> users = new ArrayList<>();
        users.add(p1);
        users.add(p2);

        ArrayList<BlackJackPlayer> result = BlackJackActions.getWinners(users);
        assertEquals(false, result.contains(p1));
        assertEquals(false, result.contains(p2));
    }

}
