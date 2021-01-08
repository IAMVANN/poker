public class Card {
    private String rank;
    private String suit;
    private String cardString;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
        this.cardString = rank + suit;
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
}
