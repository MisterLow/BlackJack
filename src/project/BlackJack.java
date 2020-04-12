package project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.cards.CardActions;
import project.cards.Deck;

public class BlackJack extends Game {

    private Dealer dealer = Dealer.getInstance();
    private Deck deck;
    private final int payoutMultiplier = 2;
    private Scanner ln = new Scanner(System.in);

    public BlackJack() {
        super("BlackJack");
        initialSetup();
    }

    /**
     * The method to start the game up
     */
    @Override
    public void play() {
        //User's turn
        //Let all the users make a bet
        for (BlackJackPlayer user : getUsers()) {
            try {
                makeBet(user);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }

        //Let all the users make a move
        for (BlackJackPlayer user : getUsers()) {
            System.out.println("\n" + DealerActions.playerHandString(dealer));
            System.out.println(BlackJackPlayerActions.playerHandString(user));
            while (user.getInRound()) {
                userMove(user);
            }
        }

        //Dealer's turn
        System.out.println("\n" + DealerActions.dealerPlay(deck, dealer));

        declareWinner();
        endGame();
    }

    /**
     * The initial setup where the human playerNum are added
     */
    private void initialSetup() {
        System.out.println("Welcome to " + getGameName());
        String name = new String();
        int playerNum = 1;
        while (name != "") {
            name = "";
            String prompt = "\nPlease enter Player " + playerNum + "'s name";
            if (playerNum == 1) {
                prompt += ": ";
            } else {
                prompt += " (Type STOP or press enter to stop adding players): ";
            }
            System.out.println(prompt);

            name = ln.nextLine();
            if (name.isEmpty() && playerNum == 1) {
                name = "Default";
                addUser(new BlackJackPlayer(name));
                playerNum++;
                name = "";
            } else if ((name.isEmpty() || name.equalsIgnoreCase("STOP")) && playerNum > 1) {
                System.out.println("No more players have been added");
                name = "";
            } else {
                addUser(new BlackJackPlayer(name));
                playerNum++;
            }

        }

        // Add the starting amount
        for (BlackJackPlayer user : getUsers()) {
            user.addMoney(1000);
        }
        deck = new Deck(getUsers().size());
        setupRound();
    }

    /**
     *
     */
    public void setupRound() {
        deck.generateDeck();
        deck.shuffle();
        try {
            CardActions.moveCards(deck, dealer.getHand(), 2);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        for (BlackJackPlayer user : getUsers()) {
            try {
                CardActions.moveCards(deck, user.getHand(), 2);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }

    /**
     *
     * @param user
     * @throws java.lang.Exception
     */
    public void makeBet(BlackJackPlayer user) throws Exception {
        int bet;
        boolean validBet = false;
        do {
            printMoney(user);
            System.out.println("\nHow much would you like to bet " + user.getPlayerID() + "?: ");
            bet = ln.nextInt();
            ln.nextLine(); //Remove the input buffer
            if (bet > user.getMoney() || bet < 0) {
                System.out.println("Your bet is invalid, please try again.");
            } else {
                validBet = true;
            }
        } while (!validBet);
        user.setCurrentBet(bet);
        printMoney(user);
    }

    /**
     *
     * @param user
     */
    public void userMove(BlackJackPlayer user) {
        String prompt;
        do {
            prompt = "What would you like to do " + user.getPlayerID() + "? (";
            if (user.getHand().getSize() == 2 && (user.getCurrentBet() * 2) <= user.getMoney()) {
                prompt += "Double Down, ";
            }
            prompt += "Hit or Stand): ";
            System.out.println(prompt);

            String response = ln.nextLine();
            if (response.isEmpty()) {
                System.out.println("Enter something");
            } else {
                response = response.substring(0, 1);
            }
            if (response.equalsIgnoreCase("D") && user.getHand().getSize() == 2 && (user.getCurrentBet() * 2) <= user.getMoney()) {
                BlackJackPlayerActions.doubleDown(deck, user);
                System.out.println(BlackJackPlayerActions.playerHandString(user));
            } else if (response.equalsIgnoreCase("H")) {
                try {
                    BlackJackPlayerActions.hit(deck, user);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                System.out.println(BlackJackPlayerActions.playerHandString(user));
            } else if (response.equalsIgnoreCase("S")) {
                BlackJackPlayerActions.stand(user);
            }
            if ((BlackJackActions.calculateValue(user) > 21)) {
                BlackJackPlayerActions.stand(user);
            }
        } while (user.getInRound());
    }

    /**
     *
     * @param user
     */
    public void printMoney(BlackJackPlayer user) {
        System.out.println("\nYou currently have: " + user.getMoney());
    }

    /**
     * Find out who won the game and appropriately reward them
     */
    @Override
    public void declareWinner() {
        ArrayList<BlackJackPlayer> winnerList = BlackJackActions.getWinners(getUsers());
        int dealerHandValue = BlackJackActions.calculateValue(dealer);
        // If all Players have busted the Dealer will automatically win
        if (winnerList.isEmpty()) {
            System.out.println("The Dealer wins");
        } else if (BlackJackActions.calculateValue(winnerList.get(0)) == dealerHandValue) {
            System.out.println("It's a stand! Money will be returned to the players");
            for (BlackJackPlayer user : winnerList) {
                user.addMoney(user.getCurrentBet());
            }
        } else if (BlackJackActions.calculateValue(winnerList.get(0)) > dealerHandValue || dealerHandValue > 21) {
            if (winnerList.size() == 1) {
                System.out.println("We have a winner\n");
            } else {
                System.out.println("We have winners!\n");
            }
            for (BlackJackPlayer user : winnerList) {
                System.out.println(user.getPlayerID() + " has won $" + (user.getCurrentBet() * payoutMultiplier));
                user.addMoney(user.getCurrentBet() * payoutMultiplier);
                try {
                    user.setCurrentBet(0);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        } else {
            System.out.println("The Dealer wins");
        }
    }

    /**
     * Remove any users who have no money and ask any remaining users if they
     * want to continue playing
     */
    public void endGame() {
        Iterator<BlackJackPlayer> itPlayer = getUsers().iterator();
        while (itPlayer.hasNext()) {
            BlackJackPlayer user = itPlayer.next();
            if (user.getMoney() <= 0) {
                System.out.println(user.getPlayerID() + " you have run out of money."
                        + " You are no longer able to continue and have been removed from the game");
                itPlayer.remove();
            } else {
                System.out.println("\nWould you like to continue playing " + user.getPlayerID() + "? (Yes to continue)");
                String response = ln.nextLine();
                boolean userExit = false;
                if (response.isEmpty()) {
                    userExit = true;
                } else if (!response.substring(0, 1).equalsIgnoreCase("Y")) {
                    userExit = true;
                }
                if (userExit) {
                    System.out.println("\nThank you for playing " + user.getPlayerID() + ", goodbye.");
                    System.out.println(user.getPlayerID() + "made it out with $" + user.getMoney());
                    itPlayer.remove();
                }
            }
        }

        if (!getUsers().isEmpty()) {
            newGame();
        }
    }

    /**
     * Ready the game for a new round
     */
    public void newGame() {
        for (BlackJackPlayer user : this.getUsers()) {
            user.getHand().clearCards();
            user.setInRound(true);
        }
        dealer.getHand().clearCards();
        setupRound();
        play();
    }
}
