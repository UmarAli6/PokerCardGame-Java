package psmodel;

/**
 *
 * @author Umar_Ali
 */
public enum PokerCombo {
    NONE(0), PAIR(1), TWO_PAIRS(3), FLUSH(5), THREE_OF_A_KIND(6), FOUR_OF_A_KIND(16);

    private final int index;
    
    private PokerCombo(int index) {
        this.index = index;
    }
            
    public int getIndex() {
        return index;
    }
}
