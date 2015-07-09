//Повторно качване на задачата след направени промени.
package homework7a;

public class DeckOfCardsTest {

    // execute application
    public static void main(String args[]) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        // deal and print 5 Cards
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",
                myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
                myDeckOfCards.dealCard(), myDeckOfCards.dealCard(), myDeckOfCards.dealCard());
        System.out.println("Single Pair: " + myDeckOfCards.onePair());
        System.out.println("Two Pair: " + myDeckOfCards.twoPair());
        System.out.println("Three Of A Kind: " + myDeckOfCards.threeOfAKind());
        System.out.println("Straight: " + myDeckOfCards.straight());
        System.out.println("Flush: " + myDeckOfCards.flush());
        System.out.println("Full House: " + myDeckOfCards.fullHouse());
        System.out.println("Four Of A Kind: " + myDeckOfCards.fourOfAKind());
        System.out.println("Straight Flush: " + myDeckOfCards.straightFlush());
    } // end main
} // end class DeckOfCardsTest
