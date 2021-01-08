import java.util.ArrayList;
import java.util.Scanner;

public class Poker {
    //variables
    private final String[] SUITS = {"C", "D", "H", "S"};
    private final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    private final Player player;
    private ArrayList<Card> Deck;

    private final Scanner in;
    public Poker(){
        this.in = new Scanner(System.in);
        player = new Player();
        play();
    }

    public void play(){
        DeckCreation();
        player.setCards(randomCard(),randomCard(),randomCard(),randomCard(),randomCard());





    }

    private void DeckCreation(){
         Deck = new ArrayList<>();
        for(String suit: SUITS){
            for(String rank: RANKS){
                Card current = new Card(rank, suit);
                Deck.add(current);
            }
        }
    }
    private Card randomCard(){
        int x = (int)(Math.random() * Deck.size());
        Card current = Deck.get(x);
        Deck.remove(x);
        return current;
    }

    public static void main(String[] args) {
        System.out.println("/////////////////////////////POKERRRRRRRRRRRR//////////////////////////////////");
        System.out.println("WOO!!!!!!!!!!!!!");
        System.out.println("GAMBLE AWAY ALL OF YOUR SAVINGS!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("WOO!!!!!!!!!!!!!!!");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" );
        System.out.println("/////////////////////////////BLACKJACK//////////////////////////////////");
        System.out.println();
        new Poker();
    }

}
