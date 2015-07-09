package homework7a;

import java.util.Random;

public class DeckOfCards {

    private Card deck[]; // array of Card objects
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private Random randomNumbers; // random number generator

    // constructor fills deck of Cards
    public DeckOfCards() {
        String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
        randomNumbers = new Random(); // create random number generator

        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    } // end DeckOfCards constructor

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0; // reinitialize currentCard

        // for each Card, pick another random Card and swap them
        for (int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        } // end for
    } // end method shuffle

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // return current Card in array
        } else {
            return null; // return null to indicate that all 5 Cards were dealt
        }
    } // end method dealCard

    private Card[] hand() {
        Card hand[] = new Card[5];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = deck[currentCard++];
        }
        return hand;
    }

    private int[] totalHandFace() {
        int totalHand[] = new int[13];
        Card hand[] = this.hand();
        for (int i = 0; i < totalHand.length; i++) {
            totalHand[i] = 0;
        }
        for (int i = 0; i < hand.length; i++) {
            switch (hand[i].getFace()) {
                case "Ace":
                    totalHand[0]++;
                    break;
                case "Deuce":
                    totalHand[1]++;
                    break;
                case "Three":
                    totalHand[2]++;
                    break;
                case "Four":
                    totalHand[3]++;
                    break;
                case "Five":
                    totalHand[4]++;
                    break;
                case "Six":
                    totalHand[5]++;
                    break;
                case "Seven":
                    totalHand[6]++;
                    break;
                case "Eight":
                    totalHand[7]++;
                    break;
                case "Nine":
                    totalHand[8]++;
                    break;
                case "Ten":
                    totalHand[9]++;
                    break;
                case "Jack":
                    totalHand[10]++;
                    break;
                case "Queen":
                    totalHand[11]++;
                    break;
                case "King":
                    totalHand[12]++;
                    break;
            }
        }
        return totalHand;
    }

    private int[] totalHandSuit() {
        int totalHand[] = new int[4];
        Card hand[] = this.hand();
        for (int i = 0; i < totalHand.length; i++) {
            totalHand[i] = 0;
        }
        for (int i = 0; i < hand.length; i++) {
            switch (hand[i].getSuit()) {
                case "Hearts":
                    totalHand[0]++;
                    break;
                case "Diamonds":
                    totalHand[1]++;
                    break;
                case "Clubs":
                    totalHand[2]++;
                    break;
                case "Spades":
                    totalHand[3]++;
                    break;
            }
        }
        return totalHand;
    }

    public boolean onePair() {
        int totalHand[] = this.totalHandFace();
        int numberOfPairs = 0;
        for (int i = 0; i < totalHand.length; i++) {
            if (totalHand[i] == 2) {
                numberOfPairs++;
            }
        }
        if (numberOfPairs == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean twoPair() {
        int totalHand[] = this.totalHandFace();
        int numberOfPairs = 0;
        for (int i = 0; i < totalHand.length; i++) {
            if (totalHand[i] == 2) {
                numberOfPairs++;
            }
        }
        if (numberOfPairs == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean threeOfAKind() {
        int totalHand[] = this.totalHandFace();
        int threeOfAKind = 0;
        for (int i = 0; i < totalHand.length; i++) {
            if (totalHand[i] == 3) {
                threeOfAKind++;
            }
        }
        if (threeOfAKind == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean straight() {
        int totalHand[] = this.totalHandFace();
        boolean straight = false;
        for (int i = 0; i < totalHand.length - 4; i++) {
            if (totalHand[i] == 1 && totalHand[i + 1] == 1 && totalHand[i + 2] == 1 && totalHand[i + 3] == 1 && totalHand[i + 4] == 1) {
                straight = true;
            }
        }
        if (totalHand[0] == 1 && totalHand[9] == 1 && totalHand[10] == 1 && totalHand[11] == 1 && totalHand[12] == 1) {
            straight = true;
        }
        return straight;
    }

    public boolean flush() {
        int totalHand[] = this.totalHandSuit();
        boolean flush = false;
        for (int i = 0; i < totalHand.length; i++) {
            if (totalHand[i] == 5) {
                flush = true;
            }
        }
        return flush;
    }

    public boolean fullHouse() {
        if (this.onePair() == true && this.twoPair() == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fourOfAKind() {
        int totalHand[] = this.totalHandFace();
        int fourOfAKind = 0;
        for (int i = 0; i < totalHand.length; i++) {
            if (totalHand[i] == 4) {
                fourOfAKind++;
            }
        }
        if (fourOfAKind == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean straightFlush() {
        if (this.straight() == true && this.flush() == true) {
            return true;
        } else {
            return false;
        }
    }
} // end class DeckOfCards
