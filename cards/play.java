package cards;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//driver clas
public class play extends Thread{
    public static void main(String[] args) {

        game game = new game();
       // card card;
        Mode mode = new Mode();
        int plays = 3;
        boolean gameON = true;
        card current ;
        int number = 0;
        String kind = null;
        card chosen = null;

        player playerOne = new player();
        player playerTwo = new player();

        PrintWriter pw = new PrintWriter(System.out, true);
        Scanner sn = new Scanner(System.in);

        //player names
        pw.println("enter playerone name:");
        playerOne.setName(sn.next());
        pw.println("enter playertwo name:");
        playerTwo.setName(sn.next());
       // sn.close();

        ArrayList<card>cards = mode.deck();
        //serve the cards 
        
        Collections.shuffle(cards);
        mode.serve(cards, playerOne.cards, playerTwo.cards, plays);

        playerOne.cards = mode.getplayerOne();
        playerOne.showCards(playerOne.cards, plays);
        playerTwo.cards = mode.getplayerTwo();
        playerTwo.showCards(playerTwo.cards, plays);
        
        checks checks = new checks(playerOne.cards, playerTwo.cards);
        Thread th = new Thread(checks);

       // th.start();

        card expected = null;

        while(gameON) {

            playerOne.turn = true;
            playerTwo.turn = true;

            while(playerOne.turn) {
                System.out.println(playerOne.name + "'s turn");
                pw.println("card number");
                number = sn.nextInt();
                pw.println("card kind");
                kind = sn.next();
                chosen = new card(number, kind);
                if (mode.hasCard(playerOne.cards, chosen) == false) {
                    System.out.println(playerOne.name + "' doesnt have such a card... fine!!!!!");
                    break;
                }
                expected = chosen;

                if (expected != null) {
                    
                   if (expected.getKind() == chosen.getKind()){
                    current = mode.makeAplay(game.getSpace(), playerOne, chosen, plays);
                    game.setCurrentCard(current);
                    expected = game.expectedCard();
                    System.out.println("exepected"+ expected.getKind());
                   }
                }
                
                playerOne.turn = false;
                if (game.checkForWin(playerOne.cards)) {
                    gameON = false;
                }
            }

            while(playerTwo.turn) {
                System.out.println(playerTwo.name + "'s turn");
                pw.println("card number");
                number = sn.nextInt();
                pw.println("card kind");
                kind = sn.next();
                chosen = new card(number, kind);
                if (mode.hasCard(playerTwo.cards, chosen) == false) {
                    System.out.println(playerTwo.name + " doesnt have such a card... fine!!!!!");
                    break;
                }
                if (expected != null) {
                   if (expected.getKind() == chosen.getKind()){
                    current = mode.makeAplay(game.getSpace(), playerTwo, chosen, plays);
                    game.setCurrentCard(current);
                    expected = game.expectedCard();
                    System.out.println("exepected"+ expected.getKind());
                   }
                }
                
                playerTwo.turn = false;
                if (game.checkForWin(playerTwo.cards)) {
                    gameON = false;
                }
            }
            
        }

        sn.close();
    }

    
}
