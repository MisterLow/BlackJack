package project;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.cards.Card;
import project.cards.Deck;
import project.cards.Hand;

public class BlackJack extends Game {

    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();

    public BlackJack() {
        super("BlackJack");
    }

    /**
     *
     */
    @Override
    public void play() {
        System.out.println("Welcome to " + getGameName());
        this.addUser(new User(getUserName()));

        setupRound();
        //User's turn
        while (this.getUsers().get(0).getInRound()) {
            break;//to add
        }
        //Dealer's turn
        while (dealer.getInRound()) {
            break;//to add
        }

        declareWinner();
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        String name;
        Scanner ln = new Scanner(System.in);
        do {
            System.out.println("Please enter your name: ");
            name = ln.nextLine();
        } while (name.isEmpty());

        return name;
    }

    /**
     *
     */
    public void setupRound() {
        this.deck.generateDeck();
        this.deck.moveCards(this.dealer.getHand(), 2);
        for (User u : this.getUsers()) {
            this.deck.moveCards(u.getHand(), 2);
        }
    }

    /**
     *
     */
    public void makeBet() {

    }

    /**
     *
     */
    public void hit() {

    }

    /**
     *
     * @param player
     */
    public void stand(Player player) {
        player.setInRound(false);
    }

    /**
     *
     * @param user
     */
    public void doubleDown(User user) {
        try {
            if (user.getCurrentBet() < user.getMoney()) {
                user.setCurrentBet(user.getCurrentBet());
            }
        } catch (Exception ex) {
            Logger.getLogger(BlackJack.class.getName()).log(Level.SEVERE, null, ex);
        }
        hit();
        stand(user);
    }

    /**
     *
     */
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    public void endGame() {

    }

    /**
     *
     */
    public void newGame() {
        setupRound();
    }
}
