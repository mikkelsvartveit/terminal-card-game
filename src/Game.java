import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private int numberOfCards;
    private Deck deck;
    private int playerScore;
    private int cpuScore;
    private Hand playerHand;
    private Hand cpuHand;
    private Scanner scanner;

    public Game(int numberOfCards) {
        this.numberOfCards = numberOfCards;

        deck = new Deck();
        playerHand = new Hand(deck, numberOfCards);
        cpuHand = new Hand(deck, numberOfCards);
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException, InterruptedException {
        System.out.println("Welcome to this card game! \n\n" +
                "The game works like this: \n" +
                "You and the CPU each get 7 random cards from the deck.\n" +
                "Both of you pick a card from your respective hands. \n" +
                "Whoever picks the highest card wins that round and gets one point. \n" +
                "When all the cards are played, the player with the most points win!");

        System.out.println("\nReady? Press enter to start the game.");
        System.in.read();

        while(playerHand.getSize() > 0) {
            try {
                System.out.println("\n\n---------------------------------------\n\n");
                System.out.println("This is your hand:\n");

                for (int i = 0; i < playerHand.getSize(); i++) {
                    Card card = playerHand.getCard(i);
                    System.out.println(i + 1 + ": " + card.getName());
                }

                System.out.print("\nType a number to pick your card: ");
                int input = scanner.nextInt();

                Card playerCard = playerHand.draw(input - 1);
                Card cpuCard = cpuHand.draw();

                TimeUnit.SECONDS.sleep(1);
                System.out.println("\nYou picked: " + playerCard.getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("CPU picked: " + cpuCard.getName());
                TimeUnit.SECONDS.sleep(2);

                if (playerCard.isHigherRanked(cpuCard) == 1) {
                    System.out.println("You win!");
                    playerScore++;
                } else if (playerCard.isHigherRanked(cpuCard) == 0) {
                    System.out.println("It's a tie!");
                    playerScore++;
                    cpuScore++;
                } else if (playerCard.isHigherRanked(cpuCard) == -1) {
                    System.out.println("You lose!");
                    cpuScore++;
                }

                TimeUnit.SECONDS.sleep(2);
            } catch(Exception e) {
                System.out.println("\nWhoops! That's not a valid number!");
                scanner.nextLine();
                TimeUnit.SECONDS.sleep(2);
            }
        }
        System.out.println("\n\n---------------------------------------");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("---------------------------------------");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("---------------------------------------\n\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("GAME OVER!");
        TimeUnit.SECONDS.sleep(2);

        System.out.println("\nYour score: " + playerScore);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("CPU's score: " + cpuScore);
        TimeUnit.SECONDS.sleep(2);

        if(playerScore > cpuScore) {
            System.out.println("YOU WON THE GAME!");
        }
        else if(playerScore < cpuScore) {
            System.out.println("YOU LOST THE GAME!");
        }
        else if(playerScore == cpuScore) {
            System.out.println("THE GAME IS TIED!");
        }

        TimeUnit.SECONDS.sleep(2);


        System.out.println("\nThanks for playing. Press enter to close the program.");
        System.in.read();
    }
}
