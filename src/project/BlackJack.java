package project;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.cards.CardActions;
import project.cards.Deck;

public class BlackJack extends Game {

    private Dealer dealer = Dealer.getInstance();
    private Deck deck = new Deck();
    private final int payoutMultiplier = 2;

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
        // Add the starting amount
        getUsers().get(0).addMoney(1000);

        setupRound();
        //User's turn
        try {
            makeBet(getUsers().get(0));
        } catch (Exception ex) {
            Logger.getLogger(BlackJack.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (getUsers().get(0).getInRound()) {
            break;//to add
        }

        //Dealer's turn
        while (dealer.play()) {
            hit(dealer);
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
        CardActions.moveCards(deck, this.dealer.getHand(), 2);
        for (User u : this.getUsers()) {
            CardActions.moveCards(deck, u.getHand(), 2);
        }
    }

    /**
     *
     * @param user
     * @throws java.lang.Exception
     */
    public void makeBet(User user) throws Exception {
        Scanner in = new Scanner(System.in);
        int bet;
        do {
            printMoney(user);
            System.out.println("How much would you like to bet?: ");
            bet = in.nextInt();
        } while (bet > user.getMoney());
        user.setCurrentBet(bet);
    }
    
    /**
     * 
     * @param user 
     */
    public void printMoney(User user) {
        System.out.println("You currently have: " + user.getMoney());
    }

    /**
     *
     * @param player
     */
    public void hit(Player player) {

    }

    /**
     *
     * @param user
     */
    public void stand(User user) {
        user.setInRound(false);
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
        hit(user);
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
