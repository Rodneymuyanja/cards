package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Mode implements rules {

    public int min = 0;
    public int max = 51;

    ArrayList<card> playerOne = new ArrayList<card>();
    ArrayList<card> playerTwo = new ArrayList<card>();

    game game = new game();

    public String mode = "normal";

    public String getMode(){
        return this.mode;
    }

   /* public Mode(){
        start();
    }*/

    @Override
    public boolean repeat(boolean turn) {
        return turn = true;  
    }

    @Override
    public void pick() {   
         
    }

    @Override
    public boolean hasJokers() {
        return false;
    }

    @Override
    public void changeColor(game game) {
        card card = game.currentCard();
       // card.getColor();
        game.setColor(card);
    }

    public boolean checkForChop(ArrayList<card> set, card card) {
        int weight = 0;
        for (int i = 0; i< set.size(); i++) {
            weight =+ set.get(i).getWeight();
        }

        if (weight < 20) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<card> deck() {
        card card ;

        int [] numbers  = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15};
        String [] kind  = {"spades", "clubs", "hearts", "diamonds"};

        ArrayList<card> NormalDeck = new ArrayList<card>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < kind.length; j++) {
                card = new card(numbers[i], kind[j]);
                NormalDeck.add(card); 
               
            }
        }
        return NormalDeck;
    }
    
    public static void main(String[] args) {
        Mode p = new Mode();

        ArrayList<card> deck = p.deck();
        ArrayList<card> one = new ArrayList<card>();
        ArrayList<card> two = new ArrayList<card>();
        Collections.shuffle(deck);
        p.serve(deck, one, two, 8);
      

    }

    public void setPlayerOne(ArrayList<card> c){
        this.playerOne = c;
    }

    public void setPlayerTwo(ArrayList<card> c){
        this.playerTwo = c;
    }

    public ArrayList<card> getplayerOne(){
        return this.playerOne;
    }

    public ArrayList<card> getplayerTwo(){
        return this.playerTwo;
    }

    @Override
    public boolean checkForRepeats() { 
       return false;
    }

    @Override
    public boolean checkForRepeatsWithIn(ArrayList<card> set) {
        return false;
    }

    public ArrayList<card> increase(ArrayList<card> set, int pickables, ArrayList<card> dec) {
        int max = pickables;
        int min = 0;
        //ArrayList<card> newdeck

        for (int i = 0; i < pickables; i++) {
            int h = ThreadLocalRandom.current().nextInt(min, max);
            
            card c = dec.get(h);
            dec.remove(h);
            game.setDeck(dec);
            set.add(c);
        }

        return set;
    }
    
    public card makeAplay(ArrayList<card> space, player player, card choice, int plays) {
        card c = null;

        for(int i = 0; i < player.cards.size(); i++){
            if ((player.cards.get(i).getKind() == choice.getKind()) && 
                    (player.cards.get(i).getNumber() == choice.getNumber())) {
                c = player.cards.get(i);
                player.cards.remove(i);
                space.add(player.cards.get(i));
            }
        }

        return c;
    }

    public void serve(ArrayList<card> deck, ArrayList<card> one, ArrayList<card> two, int plays){
        int servables = plays*2;
        for (int i = 0; i < servables; i++) {
            if (i%2 == 0) {
                deck.remove(i);
                one.add(deck.get(i));
            }else{
                deck.remove(i);
                two.add(deck.get(i));
            }
        }

        setPlayerOne(one);
        setPlayerTwo(two);


        for (int i = 0; i < plays; i++) {
            System.out.println("Mode.serve()one......"+one.get(i).getName());

        }
        System.out.println("..................................");
        for (int i = 0; i < plays; i++) {
            System.out.println("Mode.serve()two....."+two.get(i).getName());
        }
        System.out.println("..................................");
        for (int i = 0; i < deck.size(); i++) {
            System.out.println("deck....."+deck.get(i).getName());
            
        }
        System.out.println("decksize"+deck.size());
    }

    
    public boolean hasCard(ArrayList<card> cards, card card) {
        for (int i = 0; i < cards.size(); i++ ) {
            if ((cards.get(i).getNumber() == card.getNumber()) 
                    && (cards.get(i).getKind() == card.getKind())) {
                        return true;
            }
        }
        return false;
    }
    
}
