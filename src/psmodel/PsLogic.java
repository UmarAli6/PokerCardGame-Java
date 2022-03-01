package psmodel;

import cardutils.Card;
import cardutils.Pile;
import cardutils.Deck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umar Ali
 */
public class PsLogic implements IPsLogic {
    private Card nextCard;
    private Deck deck;
    private ArrayList<Pile> piles;
    
    public PsLogic() {
        deck = new Deck();
        initNewGame();
        for (int i = 0; i < piles.size(); i++) {
            pickNextCard();
            addCardToPile(i);
        }
    }
    
    @Override
    public void initNewGame() {
    nextCard = null;
    piles = new ArrayList<>();
    
    for (int i = 0; i < 5; i++) {
        Pile pile = new Pile();
        piles.add(pile);
    }
    
    for(int i = 0; i < piles.size();i++) {
        piles.get(i).clear();
    }

    deck.fill();
    deck.shuffleCards();
    
    }
    
    @Override
    public int getCardCount() {
        return 52 - deck.getSize();
    }
    
    //checks if nextCard is empty (has been added to pile)
    @Override
    public Card pickNextCard() throws IllegalStateException {
        if (nextCard == null) {
            return nextCard = deck.dealCard();
        } else {
            throw new IllegalStateException();
        }
    }
    
    //checks if pile is between 1-5, nextcard is not empy, game is not over and
    //the pile has less than 5 cards (full)
    @Override
    public void addCardToPile(int pile) throws IllegalStateException {
        if (piles.get(pile).getSize() < 5 && pile >= 0 && pile < 5 && nextCard != null && isGameOver() == false) {
            piles.get(pile).add(nextCard);
            nextCard = null;
        } else if (getCardCount() == 25) {
            piles.get(pile).add(nextCard);
            nextCard = null;
        } else {
            throw new IllegalStateException();
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
        public List<Pile> getPiles() {
            ArrayList<Pile> copy = (ArrayList<Pile>) piles.clone();
            return copy;
        }
    
    @Override
    public boolean isGameOver() {
        return getCardCount() == 25;
    }
    
    @Override
    public int getPoints() {
        int points = 0;
        for (int i = 0; i < piles.size(); i++) {
            points += PokerHands.getPokorCombo(piles.get(i)).getIndex();
        }
        return points;
    }
    
    @Override
    public String toString() {
        String info = "CardCount: " + getCardCount();
        return info;
    }
}
