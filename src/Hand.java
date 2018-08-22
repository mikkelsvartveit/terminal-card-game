public class Hand extends CardStack {
    public Hand(Deck deck) {
        for(int i = 0; i < 7; i++) {
            cards.add(deck.draw());
        }
    }

    public Hand(Deck deck, int size) {
        for(int i = 0; i < size; i++) {
            cards.add(deck.draw());
        }
    }
}
