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

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCurrentBet() {
        return this.currentBet;
    }

    /**
     *
     * @param currentBet
     */
    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public int getMoney() {
        return this.money;
    }

    /**
     *
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }

}
