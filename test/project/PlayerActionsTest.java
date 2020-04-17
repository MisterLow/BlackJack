package project;

import org.junit.After;
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
public class PlayerActionsTest {

    public PlayerActionsTest() {
    }

    @After
    public void tearDown() {
        Dealer.getInstance().getHand().clearCards();
    }
    

    /**
     * Test of calculateValue method, of class PlayerActions.
     */
    @Test
    public void testCalculateValueReg() {
        System.out.println("testCalculateValueReg");
        Card c1 = new Card(Rank.Eight, Suit.Clubs);
        Card c2 = new Card(Rank.Ten, Suit.Diamonds);
        BlackJackPlayer p = new BlackJackPlayer("Test");
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        int expResult = 18;
        assertEquals(expResult, PlayerActions.calculateValue(p));
    }

    /**
     * Test of calculateValue method, of class BlackJackActions.
     */
    @Test
    public void testCalculateValueFace() {
        System.out.println("testCalculateValueFace");
        Card c1 = new Card(Rank.Queen, Suit.Clubs);
        Card c2 = new Card(Rank.Ten, Suit.Diamonds);
        BlackJackPlayer p = new BlackJackPlayer("Test");
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        int expResult = 20;
        assertEquals(expResult, PlayerActions.calculateValue(p));
    }

    /**
     * Test of calculateValue method, of class BlackJackActions.
     */
    @Test
    public void testCalculateValueAce() {
        System.out.println("testCalculateValueAce");
        Card c1 = new Card(Rank.Ace, Suit.Clubs);
        Card c2 = new Card(Rank.Jack, Suit.Diamonds);
        BlackJackPlayer p = new BlackJackPlayer("Test");
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        int expResult = 21;
        assertEquals(expResult, PlayerActions.calculateValue(p));
    }

    /**
     * Test of calculateValue method, of class PlayerActions.
     */
    @Test
    public void testCalculateValueAces() {
        System.out.println("testCalculateValueAces");
        BlackJackPlayer p = new BlackJackPlayer("Test");
        Card c1 = new Card(Rank.Ace, Suit.Clubs);
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c1);
        int expResult = 13;
        assertEquals(expResult, PlayerActions.calculateValue(p));
    }

    /**
     * Test of hit method, of class PlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHit() throws Exception {
        System.out.println("hit");
        Deck deck = new Deck();
        BlackJackPlayer p = new BlackJackPlayer("Test");
        Dealer d = Dealer.getInstance();
        PlayerActions.hit(deck, p);
        PlayerActions.hit(deck, d);
        int result = deck.getSize();
        int expResult = 50;
        assertEquals(expResult, result);
    }

    /**
     * Test of hit method, of class PlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = Exception.class)
    public void testHitException() throws Exception {
        System.out.println("hitException");
        Deck deck = new Deck();
        deck.clearCards();
        BlackJackPlayer p = new BlackJackPlayer("Test");
        Dealer d = Dealer.getInstance();
        PlayerActions.hit(deck, p);
        PlayerActions.hit(deck, d);
    }

    /**
     * Test of hit method, of class PlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHitDealer() throws Exception {
        System.out.println("hitDealer");
        Deck deck = new Deck();
        Dealer d = Dealer.getInstance();
        PlayerActions.hit(deck, d);
        int result = deck.getSize();
        int expResult = 51;
        assertEquals(expResult, result);
    }

    /**
     * Test of hit method, of class PlayerActions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHitPlayer() throws Exception {
        System.out.println("hitPlayer");
        Deck deck = new Deck();
        BlackJackPlayer p = new BlackJackPlayer("Test");
        PlayerActions.hit(deck, p);
        int result = deck.getSize();
        int expResult = 51;
        assertEquals(expResult, result);
    }

    /**
     * Test of playerHandString method, of class PlayerActions.
     */
    @Test
    public void testPlayerHandStringBJPlayer() {
        System.out.println("playerHandStringBJPlayer");
        Card c1 = new Card(Rank.Six, Suit.Hearts);
        Card c2 = new Card(Rank.Queen, Suit.Spades);
        BlackJackPlayer p = new BlackJackPlayer("Test");
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        String expResult = "Test's hand contains:\nSix of Hearts\nQueen of Spades\nWhich is a value of 16\n";
        String result = PlayerActions.playerHandString(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of playerHandString method, of class PlayerActions.
     */
    @Test
    public void testPlayerHandStringDealer() {
        System.out.println("playerHandStringDealer");
        Card c1 = new Card(Rank.Eight, Suit.Hearts);
        Card c2 = new Card(Rank.Four, Suit.Spades);
        Dealer p = Dealer.getInstance();
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        String expResult = "Dealer's hand contains:\nEight of Hearts\nFour of Spades\nWhich is a value of 12\n";
        String result = PlayerActions.playerHandString(p);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
