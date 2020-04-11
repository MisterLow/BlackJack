package project;

/**
 * A class to represent the Dealer. There can only be one Dealer in a game.
 *
 * @author Alexander
 */
public class Dealer extends Player {

    public static Dealer dealer = null;

    private Dealer() {
        super("Dealer");
    }

    public boolean play() {
        if (getValue() < 17) {
            return true;
        }
        return false;
    }

    public Dealer getInstance() {
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

}
