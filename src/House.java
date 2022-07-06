import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class House {
    final int ID;
    final int floor;
    final int meterage;
    final int numOfRooms;int numOfUser;

    List<PaymentReson> paymentResonList;
    Map<Integer,PaymentReson> debtReson = new HashMap<>();
    List<Payment> paymentsHistory = new ArrayList<>();
    Situation situation;

    public void changeSituation(Situation situation){
        this.situation = situation;
    }

    public House(int ID, int floor, int meterage, int numOfRooms, int numOfUser) {
        this.ID = ID;
        this.floor = floor;
        this.meterage = meterage;
        this.numOfRooms = numOfRooms;
        this.numOfUser = numOfUser;
    }
}

enum Situation{
    empty,rent,bought
}