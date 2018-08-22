public class Card {
    private int suit;
    private int rank;

    public Card() {
        suit = (int) (Math.random() * 4);
        rank = (int) (Math.random() * 13 + 2);
    }

    public Card(int suit) {
        if(suit >= 0 && suit <= 3) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Suit value must be between 0 and 3");
        }

        rank = (int) (Math.random() * 13 + 1);
    }

    public Card(int suit, int rank) {
        if(suit >= 0 && suit <= 3) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Suit value must be between 0 (Clubs) and 3 (Spades)");
        }

        if(rank >= 2 && rank <= 14) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("Rank value must be between 1 (Ace) and 13 (King)");
        }
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        String name = "";

        switch(rank) {
            case 11:
                name += "Jack";
                break;

            case 12:
                name += "Queen";
                break;

            case 13:
                name += "King";
                break;

            case 14:
                name += "Ace";
                break;

            default:
                name += rank;
        }

        name += " of ";

        switch(suit) {
            case 0:
                name += "Clubs";
                break;

            case 1:
                name += "Diamonds";
                break;

            case 2:
                name += "Hearts";
                break;

            case 3:
                name += "Spades";
                break;
        }

        return name;
    }

    public int isHigherRanked(Card otherCard) {
        if(this.getRank() > otherCard.getRank()) {
            return 1;
        }
        else if(this.getRank() == otherCard.getRank()) {
            return 0;
        }
        else if(this.getRank() < otherCard.getRank()) {
            return -1;
        }

        return 0;
    }
}
