import java.util.List;

public class House {
    private int ID;
    private int floor;
    private int metrage;
    List<PaymentReson> paymentResonList;
    Situation situation;

    public void changeSituation(Situation situation){
        this.situation = situation;
    }

    public House(int ID, int floor, int metrage) {
        this.ID = ID;
        this.floor = floor;
        this.metrage = metrage;
    }
}

enum Situation{
    empty,rent,bought
}