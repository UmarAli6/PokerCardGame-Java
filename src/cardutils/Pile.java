package cardutils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umar Ali
 */
public class Pile {
    private ArrayList<Card> theCards;
    
    public Pile() {
        this.theCards = new ArrayList<>();
    }
    
    public int getSize() {
        return theCards.size();
    }
    
    public void clear() {
        theCards.clear();
    }
    
    public void add(Card c) {
        theCards.add(c);
    }
    
    public void add(List<Card> cards) {
        theCards.addAll(cards);
    }
    
    public Card get(int position) {
        return theCards.get(position);
    }
    
    @SuppressWarnings("unchecked")
        public List<Card> getCards() {
            return (List<Card>) theCards.clone();
        }
    
    public Card remove(int position) {
        Card copy = theCards.get(position);
        theCards.remove(position);
        return copy;
    }
    
    public boolean contains(Card c) {
        Boolean check = false;
        int counter = 0;
        
        while(check == false && counter < theCards.size()) {
            if (theCards.get(counter).equals(c)) {
                check = true;
            } else{
                counter++;
            }
        }
        
        return check;
    }
    
    public boolean remove (Card c) {
        Boolean check = contains(c);
        Boolean cont = false;
        int counter = 0;
        
        if (check == true) {
            while(cont == false && counter < theCards.size()) {
                if (theCards.get(counter).equals(c)) {
                    cont = true;
                    theCards.remove(counter);
                } else{
                    counter++;
                }
            }
        }
        
        return check;
    }
    
    public int noOfSuit(Suit suit) {
        int counter = 0;
        Rank[] ranks = Rank.values();
        Card copy;
        
        for (int i = 0; i < ranks.length; i++) {
            copy = new Card(ranks[i], suit);
                if (contains(copy)){
                    counter++;
                }
        }
        return counter;
    }
    
    public int noOfRank(Rank rank) {
        int counter = 0;
        Suit[] suites = Suit.values();
        Card copy;
        
        for (int i = 0; i < suites.length; i++) {
            copy = new Card(rank, suites[i]);
                if (contains(copy)){
                    counter++;
                }
        }
        
        return counter;
    }
    
    @Override
    public String toString() {
        return "Size: " + getSize() +"\nCards: "+ theCards;
    }
    
}
