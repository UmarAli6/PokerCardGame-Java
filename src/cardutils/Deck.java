package cardutils;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Umar Ali
 */
public class Deck {
    private ArrayList<Card> theCards;
    
    public Deck() {
        this.theCards = new ArrayList<>();
        fill();
    }
    
    public int getSize() {
        return theCards.size();
    }
    
    public Card dealCard() {
        Card copy = theCards.get(0);
        theCards.remove(0);
        return copy;
    }
    
    public void shuffleCards() {
        if (theCards.isEmpty()) {
            fill();
            Collections.shuffle(theCards);
        } else {
            Collections.shuffle(theCards);
        }
    }
    
    public void fill() {
        theCards.clear();
        Rank[] ranks = Rank.values();
        Suit[] suites = Suit.values();
        
        for (int r = 0; r < ranks.length; r++) {
            for (int s = 0; s  < suites.length; s++) {
               theCards.add(new Card(ranks[r], suites[s])); 
            }
        }
    }
    
    @Override
    public String toString() {
        return "Size: " + getSize() +"\nCards: "+ theCards;
    }
}