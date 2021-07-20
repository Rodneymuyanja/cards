package cards;

import java.util.ArrayList;


public class game {
    card playedCard;
    boolean turn = true;
    String currentColor = "";
    ArrayList<card> deck = new ArrayList<card>();
    

    public card currentCard(){
        return this.playedCard;
    }

    public String getCurrentColor(){
        return this.currentColor;
    }

    public void setColor(card card) {
        this.currentColor = card.getColor();
    }

    public card expectedCard(){
        card c = this.currentCard();
        String color = c.getColor();
        String kind = c.getKind();

        card expected = new card(color, kind);
        return expected;
    }

    public boolean changeColor(card current, card played) {
        int currentNumber = current.getNumber();
        int playedNumber = played.getNumber();

        if (currentNumber == playedNumber ) {
            return true;
        }

        return false;
    }

    public boolean warning(ArrayList<card> set) {
        if (set.size() == 2) {
            return true;
        }
        return false;
    }

    public boolean kard (ArrayList<card> set) {
        if (set.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean checkForWin(ArrayList<card> set) {
        if (set.size() == 0) {
            return true;
        }
        return false;
    }

    public void countAfterChop(ArrayList<card> setOne, ArrayList<card> setTwo) {
        player player = new player();

        int weightOne = 0;
        int weightTwo = 0;
        for (int i = 0; i< setOne.size(); i++) {
            weightOne =+ setOne.get(i).getWeight();
        }

        for (int i = 0; i< setTwo.size(); i++) {
            weightTwo =+ setTwo.get(i).getWeight();
        }

        if (weightTwo > weightOne) {
            player.win = true;
        }
    }

    void setDeck(ArrayList<card> dec){
        this.deck = dec;
    }

    
}
