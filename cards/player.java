package cards;

import java.util.ArrayList;

public class player {
    String name = "";
    ArrayList<card> cards = new ArrayList<card>();
    boolean win = false;
    boolean turn = true;

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void showCards(ArrayList<card> card, int plays){
        System.out.println(this.getName()+"'s cards");
        System.out.println("................................");
        for (int i = 0; i < plays; i++ ) {
           System.out.println(card.get(i).getName());
        }
        
        System.out.println("................................");
    }
}
