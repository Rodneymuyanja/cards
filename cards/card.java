package cards;

public class card{

    int weight = 0;
    int cardWeight = 0;
    String name = "";
    String color = "";
    int cardNumber = 0;
    String kind = "";

    public card(int number, String kind){
        
        this.name = assignCardName(number, kind);
        this.cardWeight = assignWeight(number, kind);
        this.cardNumber = number;
        
        if ((this.cardNumber != 14 ) && (this.cardNumber != 16 )) {

            if ((kind == "hearts") || ( kind == "diamonds")){
                this.color = "red";
            }

            if ((kind == "spades") || ( kind == "clubs")) {
                this.color = "black";
            }

        }
    }


    public card (String color, String kind) {
        this.color = color;
        this.kind = kind;
    }

   /**
    * the setters
    * @param number
    * @param kind
    * @return 
    */ 

    public String redJoker(int number) {
        if (number == 14) {
            this.weight = 50;
            this.color = "red";
        }

        return this.color+"_joker";
    }

    public String blackJoker(int number) {
        if (number == 16) {
            this.weight = 50;
            this.color = "black";
        }

        return this.color+"_joker";
    }

    private String assignCardName(int number, String kind) {

       
        switch (number) {
            case 11:
                return "jack_Of_"+kind;
            case 12:
                return "queen_Of_"+kind;
            case 13:
                return "king_Of_"+kind;
            case 14:
                return this.redJoker(number);    
            case 15:
                return "ace_Of_"+kind;  
            case 16:
                return this.blackJoker(number);         
            default:
                return number+"_Of_"+kind;       
        }
    }

    public int assignWeight(int number, String kind){
        switch (number) {
            case 2:
                this.weight = 20;
                break;
            case 3:
                this.weight = 30;
                break;
            case 4:
                this.weight = 4;
                break;
            case 5:
                this.weight = 5;
                break; 
            case 6:
                this.weight = 6;
                break;
            case 7:
                this.weight = 7;
                break;
            case 8:
                this.weight = 8;
                break;
            case 9:
                this.weight = 9;
                break;
            case 10:
                this.weight = 10;
                break;
            case 11://jack
                this.weight = 11;
                break;
            case 12://queen
                this.weight = 12;
                break;
            case 13://king
                this.weight = 13;
                break;
            case 14://joker
                //this.weight = 50;
                break;
            case 15:
                if (kind != "spades") {
                    this.weight = 15; 
                }else {
                    this.weight = 60;
                }                    
            default:
                break;
  
        }

        return this.weight;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    /**
     * the getters
     */
    public int getWeight(){
        return this.weight;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public int getNumber(){
        return this.cardNumber;
    }

    public String getKind(){
        return this.kind;
    }

    public void showCardDetails(){
        System.out.println("name "+this.getName());
        System.out.println("weight "+this.getWeight());
        System.out.println("color "+this.getColor());
    }

    public static void main(String[] args) {
        card card = new card(7, "spades");
        function f = new function();

        System.out.println("name "+card.getName());
        System.out.println("weight "+card.getWeight());
        System.out.println("color "+card.getColor());

        System.out.println(f.stopper(card));
        System.out.println(f.cutter(card));
    }
}