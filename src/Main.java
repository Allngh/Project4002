import java.util.*;

public class Main {
    static List<House> houses = new ArrayList<>();//List of houses

    static {
        houses.add(new House(1, 1, 100, 2, 4));
        houses.add(new House(2, 1, 70, 1, 2));
        houses.add(new House(3, 2, 100, 2, 3));
        houses.add(new House(4, 2, 70, 1, 1));
    }

    static List<Manager> managers = new ArrayList<>();

    static {
        managers.add(new Manager("admin", "a", "1234"));
    }

    static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("a", "b", houses.get(0), "1234"));
        customers.add(new Customer("Alireza", "Naghavi", houses.get(1), "1881"));
        customers.add(new Customer("Bagher", "Soroush", houses.get(2), "4000"));
        customers.add(new Customer("Navid", "Mahjoob", houses.get(1), "1111"));
    }

    static Person logedIn;


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
            System.out.println("*** Complete the form ***");
            System.out.print("enter your first name: ");
            firstName = scanner.next();
            System.out.print("enter your last name: ");
            lastName = scanner.next();
            System.out.print("enter your password: ");
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

                        break outer;
                    }
                }
            }
            System.out.println("your name or password is wrong");

        }
        if (command.equals("c")) {
            Customer customer = (Customer) logedIn;
            String command1, filterco;
            int day1, day2, mon1, mon2, yr1, yr2;
            outer:
            while (true) {
                System.out.println("............................................");
                System.out.println("for show debts insert \"d\"\nfor show payments insert \"p\"\nfor show filtered patments insert \"fp\"" +
                        "\nfor show payments between 2 date insert \"dp\"\nexit \"e\"");
                System.out.println("............................................");
                command1 = scanner.next();
                switch (command1) {
                    case "d":
                        //if (customer.debts().equals((Customer) customer.debts())) {
                          //  System.out.println((Customer) customer.debts());
                        //} else {
                            System.out.println("No debts found!");
                       // }
                        break;
                    case "p":
                        System.out.println(customer.timedPayments());
                        break;
                    case "fp": //show payments by fiter
                        System.out.println("eb for elecbil, gb for gasbill, wb for water bill," +
                                " r for rent, c for charge, m for mortgage");
                        filterco = scanner.next();
                        switch (filterco) {
                            case "eb":
                                System.out.println(customer.filteredPaymentList(PaymentReson.elecBill));
                                break;
                            case "gb":
                                System.out.println(customer.filteredPaymentList(PaymentReson.gasBill));
                                break;
                            case "wb":
                                System.out.println(customer.filteredPaymentList(PaymentReson.waterBill));
                                break;
                            case "r":
                                System.out.println(customer.filteredPaymentList(PaymentReson.rent));
                                break;
                            case "c":
                                System.out.println(customer.filteredPaymentList(PaymentReson.apartmentCharge));
                                break;
                            case "m":
                                System.out.println(customer.filteredPaymentList(PaymentReson.mortgage));
                                break;
                            default:
                                System.out.println("wrong command");
                                break;
                        }
                        break;
                    case "dp": // show payments by date filter
                        System.out.println("Enter start day, month and year:");
                        day1 = scanner.nextInt();
                        mon1 = scanner.nextInt();
                        yr1 = scanner.nextInt();
                        System.out.println("Enter the end day, month and year:");
                        day2 = scanner.nextInt();
                        mon2 = scanner.nextInt();
                        yr2 = scanner.nextInt();
                        System.out.println(customer.timeFilterPaymentList(new Date(day1, mon1, yr1),
                                new Date(day2, mon2, yr2)));
                            break;
                    case "e":
                        break outer;
                }
            }
        } else if (command.equals("a")) {
            Manager manager = (Manager) logedIn;
            String command1;
            outer:
            while (true) {
                System.out.println("for show house information with ID insert \"i\"\n" +
                        "for show customers payment history insert \"h\"\n" +
                        "for show profiles information insert \"p\"\n" +
                        "for show request insert \"r\"\n" +
                        "for show list of houses insert \"l\"\n" +
                        "and for Exit insert \"e\"");

                command1 = scanner.next();
                switch (command1) {
                    case "e":{
                        break outer;
                    }
                }
            }
        }
    }
}