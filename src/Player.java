

public class Player {
    private Card[] hand = new Card[5];

    public void setCards(Card one, Card two, Card three, Card four, Card five){
        hand[0] = one;
        hand[1] = two;
        hand[2] = three;
        hand[3] = four;
        hand[4] = five;
    }

}
