package cards;

public class function {
    public boolean cutter(card card) {
        if (card.getNumber() == 7 ) {
            return true;
        }
        return false;
    }

    public boolean repeater(card card) {
        if ((card.getNumber() == 8) || (card.getNumber() == 12)) {
            return true;
        }

        return false;
    }

    public boolean stresser(card card, String mode) {

        if (mode == "purge"){
            if ((card.getNumber() == 14) || (card.getNumber() == 2) || (card.getNumber() == 16) || (card.getNumber() == 3)) {
                return true;
            }
        }

        if ( mode != "purge") {
            if ((card.getNumber() == 2)) {
                return true;
            }
        }

        return false;

    }

    public boolean requester (card card) {
        if (card.getNumber() == 15) {
            return true;
        }
        return false;
    }

    public boolean stopper(card card) {
        if ((card.getNumber() == 15) && (card.getWeight() == 60)) {
            return true;
        }

        return false;
    }

}
