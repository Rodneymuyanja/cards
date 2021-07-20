package cards;

import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

public class Mode implements rules {

    public int min = 0;
    public int max = 55;

    game game = new game();

    public String mode = "normal";

    public String getMode(){
        return this.mode;
    }

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
                
                System.out.println("............");
                card.showCardDetails();
                System.out.println("............");
               
            }
        }
        System.out.println("......purge mode deck......");
        for (int k = 0; k < NormalDeck.size(); k++) {
            System.out.println(NormalDeck.get(k).getName());
        }
        System.out.println("......purge mode deck size......"+NormalDeck.size());

        return NormalDeck;
    }
    
    public static void main(String[] args) {
        Mode p = new Mode();

        p.deck();
        ArrayList<card> one = null;
        ArrayList<card> two  = null;

       /* one = p.servePlayerOne(cards, 8);
        two = p.servePlayerTwo(cards, 8);

        System.out.println(" repeats:  "+p.checkForRepeats(one, two));
        System.out.println(" repeats within one:  "+p.checkForRepeatsWithIn(one)); 

        System.out.println(" repeats within two:  "+p.checkForRepeatsWithIn(two)); 

        System.out.println("......playerone .....");
        for (int k = 0; k < one.size(); k++) {
            System.out.println(one.get(k).getName());
        }
        System.out.println("......purge mode deck size......"+one.size());

        System.out.println("......playertwo .....");
        for (int k = 0; k < two.size(); k++) {
            System.out.println(two.get(k).getName());
        }
        System.out.println("......purge mode deck size......"+two.size());*/

    }

    @Override
    public ArrayList<card> servePlayerOne(ArrayList<card> cards, int plays) {

        ArrayList<card> set = new ArrayList<card>();

        for (int i = 0; i < plays; i++) {
            int h = ThreadLocalRandom.current().nextInt(min, max);
            
            card c = cards.get(h);
            set.add(c);
        }

        return set;
    }

    @Override
    public ArrayList<card> servePlayerTwo(ArrayList<card> cards, int plays) {
        ArrayList<card> set = new ArrayList<card>();

        for (int i = 0; i < plays; i++) {
            int h = ThreadLocalRandom.current().nextInt(min, max);
            
            card c = cards.get(h);
            set.add(c);
        }

        return set;
    }

    @Override
    public boolean checkForRepeats(ArrayList<card> playerOneSet, ArrayList<card> playerTwoSet) { 
        for (int i = 0; i<playerOneSet.size(); i++) {
            if (playerOneSet.get(i).getNumber() == playerTwoSet.get(i).getNumber()) {
               
                System.out.println(" repeats:  "+playerOneSet.get(i).getName()); 
                return true;    
            }
        }   
        return false;
    }

    @Override
    public boolean checkForRepeatsWithIn(ArrayList<card> set) {
        for (int i = 0; i<set.size(); i++) {
            for (int j = i+1; j <set.size(); j++) {
                if (i!=j && set.get(i).getName() == set.get(j).getName()) {
                    System.out.println(" repeats within one i:  "+set.get(i).getName()); 
                    System.out.println(" repeats within one j:  "+set.get(j).getName()); 
                    return true;
                }
            }
        }
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
    
}
