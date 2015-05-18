public class CardTest{
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("\nNew Deck\n" + deck);
        deck.shuffle();
        System.out.println("\nNew Shuffle\n" + deck);
        deck.shuffle();
        System.out.println("\nNew Shuffle\n" + deck);
    }
}

class Deck {
    Card[] deck;      //creates the deck as an array of card objects

    Deck() {                      //creates the card array, with all 4 suits
        deck = new Card[52];
        Suit suit = Suit.spades;
        Rank rank = Rank.ace;

        for(int i = 0; i < deck.length; i++){
            if (i %13 == 0) {
                suit = suit.next();
                rank = Rank.ace;
            }

            deck[i] = new Card(suit, rank);
            rank = rank.next();
        }
    }

    void shuffle() {
        for(int i = 0; i < deck.length; i++) {
            int k = (int)(Math.random() * 52);
            Card t = deck[i];
            deck[i] = deck[k];
            deck [k] = t;
        }
    }

    /*Pseudocode for "Shuffle":
        randomly select one card from the deck
            and swap it with the first card
        randomly select another card from the deck
            and swap it with the second card
        continue until this has been done 52 times*/

    public String toString() {
        String t = "";
        for(int i = 0; i < 52; i++) {
            if ((i + 1) % 4 == 0)    //prints new line for each four card values
                t = t + deck[i] + "\n";
            else                    
                t = t + deck[i] + " ";
        }

        return t + "\n";
    }
}

//class card gives each card a suit and a rank
class Card {
    Suit suit;
    Rank rank;

    Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }
    Card(Card c) {
        suit = c.suit;
        rank = c.rank;
    }

    public String toString() {
        return rank + ":" + suit;
    }
}

//below enum keeps track of the suit of card, with a method to change suit
enum Suit {
    clubs, diamonds, hearts, spades;

    Suit next() {
        switch(this) {
            case clubs: return diamonds;
            case diamonds: return hearts;
            case hearts: return spades;
            default: return clubs;
        }
    }
}

//keeps track of rank of cards as well as going to next rank
enum Rank {
    joker, ace, two, three, four, five, six, seven, eight, nine, ten, jack,
    queen, king;

    Rank next() {
        switch(ordinal()) {
            case 0: return ace;
            case 1: return two;
            case 2: return three;
            case 3: return four;
            case 4: return five;
            case 5: return six;
            case 6: return seven;
            case 7: return eight;
            case 8: return nine;
            case 9: return ten;
            case 10: return jack;
            case 11: return queen;
            case 12: return king;
            default: return joker;
        }
    }
}