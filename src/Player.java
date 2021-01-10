

public class Player {
    private Card[] hand = new Card[5];
    private String handType;
    private boolean isRoyal = false;

    private int[][] rankquantity = {
            {0,0,0,0,0}, // [0] is cards
            {0,0,0,0,0}  //[1] is how much cards
    };

    private int[] suitquantity=
             // 0- CLUBS, 1- DIAMOND, 2- HEART, 3 Spades
            {0,0,0,0}
    ;


    public void setCards(Card one, Card two, Card three, Card four, Card five){
        hand[0] = one;
        hand[1] = two;
        hand[2] = three;
        hand[3] = four;
        hand[4] = five;
        sortHand();
    }
    public int findCard(Card card){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].getCardString().equals(card.getCardString())){
                return i;
            }
        }
        return -1;
    }

    public void replaceCard(int position, Card newCard){
        hand[position] = newCard;
    }

    public String getHand(){
        sortHand();
        String x="";
        for(int i = 0; i< hand.length; i++){
            x += hand[i].getCardString() +" ";
        }
        return x;
    }

    public void sortHand(){

        for(int i = 0; i< hand.length -1; i++){
            for(int b = 0; b< hand.length - i -1; b++){
                if(hand[b].getValue() > hand[b+1].getValue() ){
                    Card temp = hand[b];
                    hand[b] = hand[b+1];
                    hand[b+1] = temp;
                }
            }
        }
    }

    public void counter(){
        int zMAX = 0;
        for(int i = 0; i < hand.length; i++){
            boolean placed = false;

            int value = hand[i].getValue();
            String suit = hand[i].getCardsuit();
            for(int z = 0; z < zMAX; z++){
                if(value == rankquantity[0][z]){
                    rankquantity[1][z]++;//biggest ssuspect
                    placed = true;
                    z = zMAX;
                }
            }
            if(placed == false){
                rankquantity[0][zMAX] = value;
                rankquantity[1][zMAX]++;
                placed = true;
                zMAX++;
            }
            // 0- CLUBS, 1- DIAMOND, 2- HEART, 3 Spades
            if(suit.equals("C")){
                suitquantity[0]++;
            } else if(suit.equals("D")){
                suitquantity[1]++;
            } else if(suit.equals("H")){
                suitquantity[2]++;
            } else {
                suitquantity[3]++;
            }


        }
    }




    public String type(){
        boolean isPair = false;
        int isPairValue = -1;
        boolean isTwoPair = false;
        int isTwoPairValue = -1;
        boolean isTriple = false;
        boolean isFour = false;
        boolean isFlush = false;
        boolean isStraight = false;
        for(int i  = 0; i < 5; i++){
            if(rankquantity[1][i] == 2){
                if(isPair == true){
                    isTwoPair = true;
                    isTwoPairValue = rankquantity[0][i];
                }
                isPair = true;
                isPairValue = rankquantity[0][i];
            } else if(rankquantity[1][i] == 3){
                isTriple = true;
            } else if(rankquantity[1][i] == 4){
                isFour = true;
            }
        }
        for(int i = 0; i <4; i++){
            if(suitquantity[i] == 5 ){
                isFlush = true;
            }
        }
        if(!(isPair || isTriple || isFour)){
            isStraight = isStraight();
        }
        if(isRoyal && isFlush){
            return "Royal Flush";
        }
        if(isStraight && isFlush){
            return "Straight Flush";
        }
        if(isFour){
            return "Four of a kind : " + hand[2].getCardrank();
        }
        if(isTriple && isPair){
            return "Full HOUSE!!!!";
        }
        if(isFlush){
            return "Flush of " + hand[3].getCardsuit();
        }
        if(isStraight){
            return "Straight";
        }
        if(isTriple){
            return "Triple of " + hand[2].getCardrank();
        }
        if(isTwoPair){
            return "Two Pair";
        }
        if(isPair){
            if(isPairValue >= 11){
                return "Pair of " + Card.reverseSetValue(isPairValue) ;
            }
            return "LOSS!!!! Pair of " + Card.reverseSetValue(isPairValue);
        }
        return "You lost!";
    }
    public boolean isStraight(){
        if(hand[4].getValue() == 14 && hand[0].getValue() == 2 && hand[1].getValue() == 3 && hand[2].getValue() == 4 && hand[3].getValue() == 5){
            return true;
        } else if(hand[4].getValue() - hand[3].getValue() == 1 && hand[3].getValue() - hand[2].getValue() == 1  &&
                hand[2].getValue() - hand[1].getValue() == 1  && hand[1].getValue() - hand[0].getValue() == 1 ){
            if(hand[4].getValue() == 14 && hand[0].getValue() == 10){
                isRoyal = true;
            }
            return true;
        }
        return false;
    }
}
