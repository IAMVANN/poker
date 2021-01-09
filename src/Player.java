

public class Player {
    private Card[] hand = new Card[5];
    private Card[] sortedHand = new Card[5];
    private String handType;
    private boolean isRoyal = false;

    private int[][] rankquantity = {
            {0,0,0,0,0},
            {0,0,0,0,0}
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
        for(int i = 0; i< sortedHand.length; i++){
            x += sortedHand[i].getCardrank() +" ";
            System.out.println(rankquantity[1][i]);
        }
        return x;
    }

    public void sortHand(){
        sortedHand = hand;
        for(int i = 0; i< sortedHand.length -1; i++){
            for(int b = 0; b< sortedHand.length - i -1; b++){
                if(sortedHand[b].getValue() > sortedHand[b+1].getValue() ){
                    Card temp = sortedHand[b];
                    sortedHand[b] = sortedHand[b+1];
                    System.out.println();
                    sortedHand[b+1] = temp;
                }
            }
        }
        counter();
    }

    public void counter(){
        int zMAX = 0;
        for(int i = 0; i < sortedHand.length; i++){
            boolean placed = false;

            int value = sortedHand[i].getValue();
            String suit = sortedHand[i].getCardsuit();
            for(int z = 0; z < zMAX; z++){
                if(value == rankquantity[0][z]){
                    rankquantity[1][z]++;
                    placed = true;
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
        boolean isTwoPair = true;
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
            return "Four of a kind : " + sortedHand[3].getCardrank();
        }
        if(isTriple && isPair){
            return "Full HOUSE!!!!";
        }
        if(isFlush){
            return "Flush of " + sortedHand[3].getCardrank();
        }
        if(isStraight){
            return "Straight";
        }
        if(isTriple){
            return "Triple";
        }
        if(isTwoPair){
            return "Two Pair";
        }
        if(isPair){
            if(isPairValue >= 11){
                return "Pair of " + Card.reverseSetValue(isPairValue);
            }
            return "Pair of " + Card.reverseSetValue(isPairValue);
        }
        return "You lost!";
    }
    public boolean isStraight(){
        if(sortedHand[4].getValue() == 14 && sortedHand[0].getValue() == 2 && sortedHand[1].getValue() == 3 && sortedHand[2].getValue() == 4 && sortedHand[3].getValue() == 5){
            return true;
        } else if(sortedHand[4].getValue() - sortedHand[3].getValue() == 1 && sortedHand[3].getValue() - sortedHand[2].getValue() == 1  &&
                    sortedHand[2].getValue() - sortedHand[1].getValue() == 1  && sortedHand[1].getValue() - sortedHand[0].getValue() == 1 ){
            if(sortedHand[4].getValue() == 14 && sortedHand[0].getValue() == 10){
                isRoyal = true;
            }
            return true;
        }
        return false;
    }
}
