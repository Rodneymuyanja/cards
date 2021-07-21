package cards;

import java.util.ArrayList;

public interface rules {
    public boolean repeat(boolean turn);
    public void pick();
    public boolean hasJokers();
    public void changeColor(game game);
    public ArrayList<card> deck();
    public boolean checkForRepeats();
    public boolean checkForRepeatsWithIn(ArrayList<card> set);
}
