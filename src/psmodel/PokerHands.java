package psmodel;

import cardutils.Pile;
import cardutils.Rank;
import cardutils.Suit;

/**
 *
 * @author Umar Ali
 */
public class PokerHands {

    private PokerHands() {
        ;
    }

    public static PokerCombo getPokorCombo(Pile hand) {
        if (isFourOfAKind(hand)) {
            return PokerCombo.FOUR_OF_A_KIND;
        } else if (isThreeOfAKind(hand)) {
            return PokerCombo.THREE_OF_A_KIND;
        } else if (isFlush(hand)) {
            return PokerCombo.FLUSH;
        } else if (isTwoPairs(hand)) {
            return PokerCombo.TWO_PAIRS;
        } else if (isPair(hand)) {
            return PokerCombo.PAIR;
        } else {
            return PokerCombo.NONE;
        }
    }

    //Private helper methods
    private static Boolean isFourOfAKind (Pile hand) {
        return checkRank (hand, 4);
    }
    
    private static Boolean isThreeOfAKind (Pile hand) {
        return checkRank (hand, 3);
    }
    
    private static Boolean isFlush(Pile hand) {
        return checkSuit(hand, 5);
    }
    
    private static Boolean isTwoPairs (Pile hand) {
        int check = 0;
        for (Rank r: Rank.values()) {
            if (hand.noOfRank(r) == 2) {
                check++;
                if (check == 2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static Boolean isPair (Pile hand) {
        return checkRank (hand, 2);
    }    
    private static Boolean checkRank(Pile hand, int index) {
        Boolean check = false;

        if (hand.getSize() == 5) {
            if (hand.noOfRank(Rank.ACE) == index) {
                check = true;
            } else if ((hand.noOfRank(Rank.TWO) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.THREE) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.FOUR) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.FIVE) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.SIX) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.SEVEN) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.EIGHT) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.NINE) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.TEN) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.JACK) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.QUEEN) == index)) {
                check = true;
            } else if ((hand.noOfRank(Rank.KING) == index)) {
                check = true;
            }
        }
        return check;
    }
    
    private static Boolean checkSuit(Pile hand, int index) {
        Boolean check = false;

        if (hand.getSize() == 5) {
            if (hand.noOfSuit(Suit.DIAMONDS) == index) {
                check = true;
            } else if ((hand.noOfSuit(Suit.CLUBS) == index)) {
                check = true;
            } else if ((hand.noOfSuit(Suit.HEARTS) == index)) {
                check = true;
            } else if ((hand.noOfSuit(Suit.SPADES) == index)) {
                check = true;
            }
        }
        return check;
    }
}
