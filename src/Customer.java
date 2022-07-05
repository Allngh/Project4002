import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    boolean rentOrOwn;//true for own and false for rent
    int debt = 0;
    House house;
    List<Payment> paymentsHistory = new ArrayList<>();

    public Customer(boolean rentOrOwn,String name,String lastName,House house) {
        this.rentOrOwn = rentOrOwn;
        super.name = name;
        super.lastName = lastName;
        this.house = house;
    }

    public List<Payment> timedPayments(){
        return paymentsHistory.stream().sorted((a1,a2) -> (a1.date.compare(a2.date))).toList();
    }

    public List<Payment> filteredPaymentList(PaymentReson paymentReson){
        return paymentsHistory.stream().filter(p -> p.paymentReson.equals(paymentReson)).toList();
    }

}
