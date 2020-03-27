package project.cards;

/**
 * A class that represents a player's hand
 *
 * @author Christopher Lewis 991585051
 * @author Alexander Low 991266865
 * @version 2020/03/27
 */
public enum Rank {
    Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
    
    private final int value;

    private Rank(int value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
}