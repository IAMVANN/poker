public class Card {
    private String rank;
    private String suit;
    private String cardString;
    private int value = 0;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
        this.cardString = rank + suit;
        setValue();
    }
    public String getCardString(){
        return cardString;
    }
    public String getCardrank(){
        return rank;
    }
    public String getCardsuit(){
        return suit;
    }
    public int getValue(){
        return value;
    }
    public void setValue(){
        switch (rank) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                value = Integer.parseInt(rank);
                break;
            case "T":
                value = 10;
                break;
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K" :
                value = 13;
                break;
            case "A":
                value = 14;
                break;
        }

    }
    public static String reverseSetValue(int x){
        String cardRank = "SOMETHING MESSED UP";
        switch (x){
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                cardRank = Integer.toString(x);
                break;
            case 10:
                cardRank = "T";
                break;
            case 11:
                cardRank = "J";
                break;
            case 12:
                cardRank = "Q";
                break;
            case 13:
                cardRank = "K";
                break;
            case 14:
                cardRank = "A";
                break;
        }
        return cardRank;
    }

}
