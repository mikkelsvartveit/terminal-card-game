import java.util.LinkedList;

public class CardStack {
    LinkedList<Card> cards = new LinkedList<>();

    public int getSize() {
        return cards.size();
    }

    public Card draw() {
        int index = (int) (Math.random() * getSize());
        return cards.remove(index);
    }

    public Card draw(int index) {
        return cards.remove(index);
    }

    public void shuffle() {
        for(int i = 0; i < getSize(); i++) {
            int index = (int) (Math.random() * (getSize() - i));
            cards.add(cards.remove(index));
        }
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public LinkedList<Card> getAllCards() {
        return cards;
    }

    public String[] getCardNames() {
        String cardNames[] = new String[getSize()];

        for(int i = 0; i < getSize(); i++) {
            cardNames[i] = cards.get(i).getName();
        }

        return cardNames;
    }
}
