package project;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import project.cards.Card;
import project.cards.Deck;
import project.cards.Rank;
import project.cards.Suit;

/**
 *
 * @author Alexander
 */
public class BlackJackPlayerActionsTest {

    public BlackJackPlayerActionsTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of stand method, of class BlackJackPlayerActions.
     */
    @Test
    public void testStandGood() {
        System.out.println("standGood");
        BlackJackPlayer user = new BlackJackPlayer("Tester");
        BlackJackPlayerActions.stand(user);
        boolean result = false;
        boolean expResult = user.getInRound();
        assertEquals(expResult, result);
    }

    /**
     * Test of doubleDown method, of class BlackJackPlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoubleDownGood() throws Exception {
        System.out.println("doubleDownGood");
        Deck deck = new Deck();
        BlackJackPlayer user = new BlackJackPlayer("Tester");
        user.addMoney(1000);
        user.setCurrentBet(200);
        BlackJackPlayerActions.doubleDown(deck, user);
        boolean result = true;
        boolean expResult = (user.getCurrentBet() == 400);
        assertEquals(expResult, result);
    }

    /**
     * Test of doubleDown method, of class BlackJackPlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoubleDownBad() throws Exception {
        System.out.println("doubleDownBad");
        Deck deck = new Deck();
        BlackJackPlayer user = new BlackJackPlayer("Tester");
        user.addMoney(1000);
        user.setCurrentBet(1000);
        BlackJackPlayerActions.doubleDown(deck, user);
        boolean result = false;
        boolean expResult = (user.getCurrentBet() == 2000);
        assertEquals(expResult, result);
    }

    /**
     * Test of doubleDown method, of class BlackJackPlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoubleDownBoundary() throws Exception {
        System.out.println("doubleDownBoundary");
        Deck deck = new Deck();
        BlackJackPlayer user = new BlackJackPlayer("Tester");
        user.addMoney(1000);
        user.setCurrentBet(500);
        BlackJackPlayerActions.doubleDown(deck, user);
        boolean result = true;
        boolean expResult = (user.getCurrentBet() == 1000);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class BlackJackPlayerActions.
     */
    @Test
    public void testGetWinnersGood() {
        System.out.println("getWinnersGood");
        ArrayList<BlackJackPlayer> users = new ArrayList<>();
        BlackJackPlayer u1 = new BlackJackPlayer("User1");
        BlackJackPlayer u2 = new BlackJackPlayer("User2");
        users.add(u1);
        users.add(u2);
        Card c1 = new Card(Rank.Six, Suit.Hearts);
        Card c2 = new Card(Rank.Queen, Suit.Spades);
        u1.getHand().getCards().add(c1);
        u1.getHand().getCards().add(c2);
        u2.getHand().getCards().add(c1);
        u2.getHand().getCards().add(c2);
        ArrayList<BlackJackPlayer> winners = BlackJackPlayerActions.getWinners(users);
        boolean expResult = true;
        boolean result = winners.contains(u1) && winners.contains(u2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class BlackJackPlayerActions.
     */
    @Test
    public void testGetWinnersBad() {
        System.out.println("getWinnersBad");
        ArrayList<BlackJackPlayer> users = new ArrayList<>();
        BlackJackPlayer u1 = new BlackJackPlayer("User1");
        BlackJackPlayer u2 = new BlackJackPlayer("User2");
        users.add(u1);
        users.add(u2);
        Card c1 = new Card(Rank.Six, Suit.Hearts);
        Card c2 = new Card(Rank.Queen, Suit.Spades);
        Card c3 = new Card(Rank.Ace, Suit.Spades);
        u1.getHand().getCards().add(c1);
        u1.getHand().getCards().add(c2);
        u2.getHand().getCards().add(c1);
        u2.getHand().getCards().add(c3);
        ArrayList<BlackJackPlayer> winners = BlackJackPlayerActions.getWinners(users);
        boolean expResult = false;
        boolean result = winners.contains(u1) && winners.contains(u2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class BlackJackPlayerActions.
     */
    @Test
    public void testGetWinnersBoundary() {
        System.out.println("getWinnersBoundary");
        ArrayList<BlackJackPlayer> users = new ArrayList<>();
        BlackJackPlayer u1 = new BlackJackPlayer("User1");
        BlackJackPlayer u2 = new BlackJackPlayer("User2");
        users.add(u1);
        users.add(u2);
        Card c1 = new Card(Rank.Six, Suit.Hearts);
        Card c2 = new Card(Rank.Queen, Suit.Spades);
        Card c3 = new Card(Rank.King, Suit.Spades);
        u1.getHand().getCards().add(c1);
        u1.getHand().getCards().add(c2);
        u2.getHand().getCards().add(c1);
        u2.getHand().getCards().add(c3);
        ArrayList<BlackJackPlayer> winners = BlackJackPlayerActions.getWinners(users);
        boolean expResult = true;
        boolean result = winners.contains(u1) && winners.contains(u2);
        assertEquals(expResult, result);
    }

}
