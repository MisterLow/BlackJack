package project;

/**
 * A class to represent the Dealer in BlackJack. There can only be one Dealer in
 * a game.
 *
 * @author Alexander
 */
public class Dealer extends Player {

    public static Dealer dealer = null;

    private Dealer() {
        super("Dealer");
    }

    /**
     *
     * @return
     */
    public static Dealer getInstance() {
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

}
