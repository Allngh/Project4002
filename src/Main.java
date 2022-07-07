import java.util.*;

public class Main {
    static List<Manager> managers = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    //static {customers.add(new Customer("a","b",1,"1234"));}
    static Person logedIn;
    static List<House> houses = new ArrayList<>();//optional can be deleted
    static {
        houses.add(new House(1,1,100,2,4));
        houses.add(new House(2,1,70,1,2));
        houses.add(new House(3,2,100,2,3));
        houses.add(new House(4,2,70,1,1));
            }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("*Apartment Management System*\nif you want to log in as admin write \"a\" " +
                "\nand if you want to login as customer write \"c\"");

        while (true) {
            command = scanner.next();
            if (command.equals("a")) {
                break;
            } else if (command.equals("c")) {
                break;
            } else {
                System.out.println("invalid command");
            }
        }
        String firstName, lastName, password;
        outer:
        while (true) {
            System.out.println("enter your first name");
            firstName = scanner.next();
            System.out.println("enter your last name");
            lastName = scanner.next();
            System.out.println("enter your password");
            password = scanner.next();
            if (command.equals("a")) {
                inner:
                for (Manager m : managers) {
                    if ((m.name.equals(firstName)) && (m.lastName.equals(lastName)) && (m.password.equals(password))) {
                        logedIn = m;
                        break outer;
                    }
                }
            } else {
                for (Customer m : customers) {
                    if ((m.name.equals(firstName)) && (m.lastName.equals(lastName)) && (m.password.equals(password))) {
                        logedIn = m;
//                        System.out.println("1.Require to admin");
//                        System.out.println("2.Payment history");
//                        System.out.println("3.Debt options");
//                        System.out.println("4.Profile");
//                        System.out.println("0.Exit");
//                        Scanner scan = new Scanner(System.in);
//                        switch (scan.nextInt()) {
//                            case (1): {
//                                System.out.println();
//                            }
//                        }
                        break outer;
                    }
                }
            }
            System.out.println("your name or password is wrong");

        }
        if(command.equals("c")){
            Customer customer = (Customer) logedIn;
            String command1,filterco;
            int day1,day2,mon1,mon2,yr1,yr2;
            outer:while(true){
                System.out.println("for show debts insert d,\nfor show payments insert p\nfor show filtered patments insert fp" +
                        "\nfor show payments between 2 date insert dp\nexit e");
                command1 = scanner.next();
                switch (command1){
                    case "d":
                        System.out.println((Customer)customer.debts());
                        break;
                    case "p":
                        System.out.println(customer.timedPayments());
                        break;
                    case "fp":
                        filterco = scanner.next();
                        System.out.println("eb for elecbil,gb for gasbill,wb for water bill," +
                                "r for rent,c for charge,m for motgage");
                        switch (filterco){
                            case "eb":
                                System.out.println(customer.filteredPaymentList(PaymentReson.elecBill));
                                break ;
                            case "gb":
                                System.out.println(customer.filteredPaymentList(PaymentReson.gasBill));
                                break ;
                            case "wb":
                                System.out.println(customer.filteredPaymentList(PaymentReson.waterBill));
                                break ;
                            case "r":
                                System.out.println(customer.filteredPaymentList(PaymentReson.rent));
                                break ;
                            case "c":
                                System.out.println(customer.filteredPaymentList(PaymentReson.apartmentCharge));
                                break ;
                            case "m":
                                System.out.println(customer.filteredPaymentList(PaymentReson.mortgage));
                                break ;
                            default:
                                System.out.println("wrong command");
                                break ;
                        }
                        break ;
                    case "dp":
                        day1 = scanner.nextInt();mon1 = scanner.nextInt();yr1 = scanner.nextInt();
                        day2 = scanner.nextInt();mon2 = scanner.nextInt();yr2 = scanner.nextInt();
                        System.out.println(customer.timeFilterPaymentList(new Date(day1,mon1,yr1),new Date(day2,mon2,yr2)));
                    case "e":
                        break outer;
                }
            }
        }
    }
}