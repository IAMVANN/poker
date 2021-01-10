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
        Card uno = new Card("A", "S");
        Card dos = new Card("2", "S");
        Card tres = new Card("4", "H");
        Card cautro = new Card("10", "S");
        Card cinco = new Card("10", "S");
        player.setCards(uno, dos, tres, cautro, cinco);
        player.sortHand();
        player.counter();
        System.out.println(player.type());
        /* DeckCreation();
        player.setCards(randomCard(),randomCard(),randomCard(),randomCard(),randomCard());

        System.out.println("This is your hand " + player.getHand());
        System.out.println("How many cards would you like to trade? 0-3");
        boolean validcards = false;
        int tradeAmount = 0;
        while(!validcards){
            int i = Integer.parseInt(in.nextLine());
            if(i >= 0 && i <=3){
                tradeAmount = i;
                validcards = true;
            } else {
                System.out.println("PLease enter a valid amount 0-3" );
            }
        }


        if(tradeAmount >0){
            System.out.println("Which card(s) would you like to trade?(Please put a comma inbetween each card and no spaces Ex.7D,JH,KC. ");
            boolean cardAmount = false;
            boolean cardTypes = false;
            boolean isInHand = false;
            Card[] cardTrade;
            int[] cardPosition;
            while(!cardAmount || !cardTypes){
                String cardSwitch = in.nextLine().toUpperCase();
                int count = cardSwitch.length() - cardSwitch.replace(",", "").length() + 1;//STACKOVERFLOW!!!!!!!! THANKS
                if(count == tradeAmount){
                    cardAmount = true;
                    cardTrade=  new Card[count];
                    cardPosition = new int[count];
                    cardTypes = true;
                    for(int i = 0; i < count; i++){
                        cardTrade[i] = new Card(cardSwitch.substring(i * 3, i*3+1),cardSwitch.substring(i * 3+1, i*3+2));
                        int cardpos = player.findCard(cardTrade[i]);
                        if( cardpos == -1){
                            cardTypes = false;
                            System.out.println("Please enter valid Cards.");
                        } else {
                            cardPosition[i] = cardpos;
                        }
                    }
                    if(cardTypes == true){
                        for(int i = 0; i < count; i++){
                            player.replaceCard(cardPosition[i], randomCard());
                        }
                    }

                } else {
                    System.out.println("Please enter the correct amount of cards");
                }
            }
        }
        player.sortHand();
        player.counter();
        System.out.println("");
        System.out.println("Your hand is " + player.getHand() + ". Your type is " + player.type());*/





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
