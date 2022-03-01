package cardutils;

import java.util.Arrays;

/**
 *
 * @author Umar Ali
 */
public class MainTest {
    public static void main(String[] args) {
        Deck deck1 = new Deck();
        
        Pile pile1 = new Pile();
        
        Card card1 = new Card(Rank.ACE, Suit.SPADES);        
        
        System.out.println(deck1.toString());
        
        pile1.add(deck1.dealCard());
        pile1.add(deck1.dealCard());
        pile1.add(deck1.dealCard());
        pile1.add(deck1.dealCard());
        deck1.shuffleCards();
        pile1.add(deck1.dealCard());
        pile1.add(deck1.dealCard());
        pile1.add(deck1.dealCard());
        pile1.add(deck1.dealCard()); 
        
        System.out.println(pile1.getCards());
        
        System.out.println(pile1.remove(0));
        
        System.out.println(pile1.remove(card1));
        
        System.out.println(pile1.getCards());
        
        
        System.out.println(pile1.noOfSuit(Suit.HEARTS));
        System.out.println(pile1.noOfRank(Rank.THREE));
        //System.out.println(pile1.toString());
        
        /*System.out.println(deck1.getSize());
        
        for (int i = 0; i < 8; i++) {
            System.out.println(deck1.dealCard());
        }
        
        System.out.println(deck1.getSize());
        
        //deck1.shuffleCards();
        
        int max = deck1.getSize();
        
        for (int i = 0; i < max; i++) {
            System.out.println(deck1.dealCard());
        }
        
        System.out.println(deck1.getSize());
        
        deck1.fill();
        System.out.println(deck1.getSize());
        
        max = deck1.getSize();
        
        for (int i = 0; i < max; i++) {
            System.out.println(deck1.dealCard());
        }*/
        
        
        
    }
}