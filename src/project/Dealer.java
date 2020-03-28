package project;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public boolean play() {
        if (getValue() < 17) {
            return true;
        }
        return false;
    }
}
