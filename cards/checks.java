package cards;

import java.util.ArrayList;



public class checks implements Runnable, rules {

    Mode mode = new Mode();
    ArrayList<card> pOne = null;
    ArrayList<card> pTwo = null;

    public checks(ArrayList<card> pOne,ArrayList<card> pTwo){
        this.setOne(pOne);
        this.setTwo(pTwo);
    }

    public void setOne(ArrayList<card> o ) {
        this.pOne = o;
    }

    public void setTwo(ArrayList<card>  t) {
        this.pTwo = t;
    }

    public ArrayList<card> getOne(){
        return this.pOne;
    }

    public ArrayList<card> getTwo(){
        return this.pTwo;
    }
    
    @Override
    public void run() {
        System.out.println("checks.run()");
       // this.checkForRepeatsWithIn(set);
        boolean re = this.checkForRepeats();
        System.out.println(re);
        boolean inOne = this.checkForRepeatsWithIn(this.getOne());
        boolean inTwo = this.checkForRepeatsWithIn(this.getTwo());
        System.out.println("one "+inOne);
        System.out.println("Two "+inTwo);

    }

    @Override
    public boolean repeat(boolean turn) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void pick() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean hasJokers() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void changeColor(game game) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<card> deck() {
        // TODO Auto-generated method stub
        return null;
    }

   

    @Override
    public boolean checkForRepeats() {
        
        System.out.println("checks.checkForRepeats()"+this.getTwo());

        for (int i = 0; i <this.getOne().size(); i++) {
            for (int j = 1; j < this.getTwo().size(); j++) {
                if (this.getOne().get(i).getName() ==  this.getTwo().get(j).getName()){
                    
                    return true;
                }
            }
        }
        return false;
        
    }

    @Override
    public boolean checkForRepeatsWithIn(ArrayList<card> set) {
        for (int i = 0; i<set.size(); i++) {
            for (int j = i+1; j <set.size(); j++) {
                if (i!=j && set.get(i).getName() == set.get(j).getName()) {
                   // System.out.println(" repeats within one i:  "+set.get(i).getName()); 
                    //System.out.println(" repeats within one j:  "+set.get(j).getName()); 
                    
                    return true;
                }
            }
        }
        return false;
    }

    
    
}
