import java.util.ArrayList;
import java.util.Scanner;

public class Poker {
    //variables
    private final String[] SUITS = {"C", "D", "H", "S"};
    private final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    private final Player player;
    private ArrayList<Card> Deck;
    private double chips = 0;
    private  double originalchips = 0;
    private int bet = 0;
    private int RoundCounter = 1;
    private boolean play = true;




    private final Scanner in;
    public Poker(){
        this.in = new Scanner(System.in);
        boolean j = true;
        while(j){
            System.out.println("How many chips would you like to buy?(>1)");
            chips = in.nextDouble();
            in.nextLine();
            if(chips % 1 == 0 && chips >=1) {
                j = false;
            } else {
                System.out.println("Please enter a valid number(must be a whole number greater then 1(and less then a very big number))");
            }
        }
        originalchips = chips;
        player = new Player(chips);
        play();
    }

    public void play(){
        while(play){
            boolean valid = false;
            System.out.println("///////////////////////////////////////////////ROUND " + RoundCounter++ + "///////////////////////////////////////////////\n");
            while(!valid){
                System.out.println("Your current balance is : " + player.getChips() + ".");
                System.out.println("How much many would you like to bet?(you can only bet full chips, it must be equal or less then your current balance, and it must be between 1-25)");
                bet = in.nextInt();
                in.nextLine();
                if(player.getChips() - bet >= 0 && bet >= 1 && bet <= 25){
                    valid = true;
                }
            }
            DeckCreation();
            player.setCards(randomCard(),randomCard(),randomCard(),randomCard(),randomCard());
            player.minusBet(bet);
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
            System.out.println("Your hand is " + player.getHand() + ". Your hand is (a) " + player.type(bet));
            player.reseter();

            if(player.hasMoney() == false){
                System.out.println("You are broke. GG EZ, Come back with more money next time");
                play = false;
            } else {
                boolean m = false;
                while(!m){
                    System.out.println("Would you like to play another round?");
                    String nextRound = in.nextLine().toLowerCase();
                    if(nextRound.equals("yes")){
                        m = true;
                        System.out.println("Alright, lets start a new round");
                    } else if(nextRound.equals("no")){
                        m = true;
                        play = false;
                        System.out.println("Alright time for you to withdraw.");
                        System.out.println("Today you came in with " + originalchips + "." );
                        System.out.println("You ended up with " + player.getChips() + ".");
                        if(player.getChips() > originalchips){
                            double k = player.getChips() - originalchips;
                            System.out.println("You made : $" + k + ".");
                            System.out.println("That great. Be sure to come back to play again");
                        } else if(player.getChips() == originalchips){
                            System.out.println("You made nothing, but atleast u didn't losing anything either.");
                            System.out.println("Be sure to come again.");
                        } else {
                            System.out.println("Damn you suck. Thanks for the money, adios!!!");

                        }
                    } else {
                        System.out.println("Please either yes or no");
                    }
                }

            }
        }
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
        System.out.println("/////////////////////////////POKER//////////////////////////////////");
        System.out.println("WOO!!!!!!!!!!!!!");
        System.out.println("GAMBLE AWAY ALL OF YOUR SAVINGS!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("WOO!!!!!!!!!!!!!!!");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" );
        System.out.println("/////////////////////////////POKER//////////////////////////////////");
        System.out.println();
        new Poker();
    }

}
