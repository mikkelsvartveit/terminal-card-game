public class Deck extends CardStack{
    public Deck() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 2; j <= 14; j++) {
                cards.add(new Card(i, j));
            }
        }
    }

    public Deck(int numberOfDecks) {
        for(int k = 0; k < numberOfDecks; k++) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 2; j <= 14; j++) {
                    cards.add(new Card(i, j));
                }
            }
        }
    }
}
