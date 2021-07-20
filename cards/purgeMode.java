package cards;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class purgeMode extends Mode{

    function function = new function();

    game game = new game();

    public purgeMode(){
        super.mode = "purge";
    }

    public int pick(card card) {
        boolean stresser = function.stresser(card, mode);
        int numberToPick = 0;
        if (stresser) {
           if ((card.getNumber() == 14) || ( card.getNumber() == 16 )) {
               //respecting the joker 
               numberToPick = 5;
           }else {
               numberToPick = card.getNumber();
           }
        }
        return numberToPick;
    }

    @Override
    public boolean hasJokers() {
       // super.hasJokers();
       return true;
    }

    @Override
    public boolean checkForChop(ArrayList<card> set, card card) { 
        //no chopping in purgeMOde
        return false;
    }

   
    @Override
    public ArrayList<card> deck() {
        card card ;

        int [] numbers  = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        String [] kind  = {"spades", "clubs", "hearts", "diamonds"};

       // card [] purgeModeDeck = new card [54];

        ArrayList<card> purgeModeDeck = new ArrayList<card>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < kind.length; j++) {
                card = new card(numbers[i], kind[j]);
                
                if (card.getWeight() == 50){
                   // card.showCardDetails();
                    purgeModeDeck.add(card); 
                    break;//adding a joker once..
                }
             /*   System.out.println("............");
                card.showCardDetails();
                System.out.println("............");*/
                purgeModeDeck.add(card); 
            }
        }
        System.out.println("......purge mode deck......");
        for (int k = 0; k < purgeModeDeck.size(); k++) {
            System.out.println(purgeModeDeck.get(k).getName());
        }
        System.out.println("......purge mode deck size......"+purgeModeDeck.size());

        return purgeModeDeck;

    }

    @Override
    public ArrayList<card> increase(ArrayList<card> set, int pickables, ArrayList<card> dec) {
        return super.increase(set, pickables, dec);
    }
}
