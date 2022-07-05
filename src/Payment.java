public class Payment {
    private final int price;
    private final PaymentReson paymentReson;
    private final Date date;

    public Payment(int price, PaymentReson paymentReson, Date date) {
        this.price = price;
        this.paymentReson = paymentReson;
        this.date = date;
    }
}


enum PaymentReson{
    elecBill,waterBill,gasBill,rent,apartmentCharge,mortgage
}

class Date{
    int day,month,year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}