package project;

/**
 * An class that represents the human player
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/25
 */
public class User extends Player {

    private int currentBet;
    private int money;

    public User(String name) {
        super(name);
    }

    /**
     * @return The current bet amount
     */
    public int getCurrentBet() {
        return this.currentBet;
    }

    /**
     *
     * @param bet The bet the user wishes to make
     * @throws java.lang.Exception If the bet is too high
     */
    public void setCurrentBet(int bet) throws Exception {
        if (bet > money) {
            throw new Exception("Bet can not be greater than the User's current"
                    + " amount of money");
        }
        removeMoney(bet);
        this.currentBet += bet;
    }

    public void resetBet() {
        this.currentBet = 0;
    }

    public int getMoney() {
        return this.money;
    }

    /**
     *
     * @param money
     */
    public void addMoney(int money) {
        this.money += money;
    }

    /**
     *
     * @param money
     * @throws java.lang.Exception
     */
    public void removeMoney(int money) throws Exception {
        if ((this.money - money) < 0) {
            throw new Exception("Money can not go into the negatives");
        }
        this.money -= money;
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
