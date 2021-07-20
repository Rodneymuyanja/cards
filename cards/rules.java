package cards;

import java.util.ArrayList;

public interface rules {
    public boolean repeat(boolean turn);
    public void pick();
    public boolean hasJokers();
    public void changeColor(game game);
    public ArrayList<card> deck();
    public ArrayList<card> servePlayerOne(ArrayList<card> cards, int plays);
    public ArrayList<card> servePlayerTwo(ArrayList<card> cards, int plays);
    public boolean checkForRepeats(ArrayList<card> playerOneSet, ArrayList<card> playerTwoSet);
    public boolean checkForRepeatsWithIn(ArrayList<card> set);
}
