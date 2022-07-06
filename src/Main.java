import java.util.*;

public class Main {
    static List<Manager> managers = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static Person logedIn;
    static List<House> houses = new ArrayList<>();//optional can be deleted
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("if you want to log in as admin write a \nand if you want to login as customer write c");
        while (true){
            command = scanner.next();
            if (command.equals("a")) {break;
            } else if (command.equals("c")) {break;
            } else {
                System.out.println("invalid command");
            }
        }
        String firstName,lastName,password;
        outer:while(true){
            System.out.println("enter your first name");
            firstName = scanner.next();
            System.out.println("enter your last name");
            lastName = scanner.next();
            System.out.println("enter your password");
            password = scanner.next();
            if(command.equals("a")){
                inner:for (Manager m : managers) {
                    if ((m.name.equals(firstName)) && (m.lastName.equals(lastName)) && (m.password.equals(password))) {
                        logedIn = m;
                        break outer;
                    }
                }
            }else {
                for(Customer m:customers){
                    if ((m.name.equals(firstName)) && (m.lastName.equals(lastName)) && (m.password.equals(password))) {
                        logedIn = m;
                        break outer;
                    }
                }
            }
            System.out.println("your name or password is wrong");

        }
    }

}
