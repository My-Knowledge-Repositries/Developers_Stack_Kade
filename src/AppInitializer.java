import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AppInitializer {
    //==========Database area========= (access all around the project)
    static String[][] users = new String[3][2];
    static String[][] customers = new String[100][4];

    // step 1 => create a new array and it's length = users.length+???
    // step 2 => for loop copy users array to the new array
    // that created new array assign to the users reference

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitState = false;

        // program initialization
        String[] initializePageQuestions =
                {
                        "1) Do you want to login?",
                        "2) Are you new to here?",
                        "3) Do you want to exit the page?"
                };


        while (!exitState) {
            for (String question : initializePageQuestions) {
                System.out.println(question);
            }

            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    // just for our testing process
                    users[0][0] = "hasika@gmail.com";
                    users[0][1] = "1234";
                    // just for our testing process
                    if (login()) {
                        printUi("Dashboard");
                        openDashboard();
                    }
                    printUi("Application");
                    break;
                case 2:
                    if (register()) {
                        printUi("Dashboard");
                        openDashboard();
                    }
                    printUi("Application");
                    break;
                case 3:
                    System.out.println("Good bye!.");
                    return;
                default:
                    System.out.println("Idiot!.. Wrong input..\uD83D\uDE14");
                    return;
            }
        }
    }


    // login process
    public static boolean login() {
        printUi("Login");
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the email");
        String email = input.nextLine();
        System.out.println("Please Enter the password");
        String password = input.nextLine();
        //==============
        for (int i = 0; i < users.length; i++) {
            if (users[i][0] != null && users[i][0].equals(email)) { // & vs && // []??
                if (users[i][1].equals(password)) {
                    System.out.println("Welcome again!");
                    return true;
                } else {
                    System.out.println("Wrong Password!");
                    return false;
                }
            }
        }
        System.out.println("404 email Not Found");
        return false;
    }

    // register process
    public static boolean register() {
        Scanner input = new Scanner(System.in);
        if (users[users.length - 1][0] != null) {
            System.out.println("User database is full!");
            return false;
        }
        System.out.println("Insert Your Email!");
        String email = input.nextLine();
        System.out.println("Insert Your Password!");
        String password = input.nextLine();


        for (int x = 0; x < users.length; x++) {
            if (users[x][0] == null) {
                users[x][0] = email;
                users[x][1] = password;
                return true;
            } else {
                if (users[x][0].equalsIgnoreCase(email)) { // just ignore // ==,equals,equalsIgnoreCase
                    System.out.println("Email is already exists!");
                    return false;
                }
            }
        }
        return false;
    }

    // dashboard process
    public static void openDashboard() {
        Scanner input = new Scanner(System.in);
        String[] dashboardQuestions = {
                "1) Customer Management",
                "2) Item Management",
                "3) Order Management",
                "4) Logout"
        };
        while (true) {
            for (String question : dashboardQuestions
            ) {
                System.out.println(question);
            }
            int userInput = input.nextInt();


            switch (userInput) {
                case 1:
                    customerManagement();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    return;
            }
        }
    }

    // Customer process
    public static void customerManagement() {
        Scanner input = new Scanner(System.in);
        String[] customerQuestions = {
                "1) Save Customer",
                "2) Find Customer",
                "3) Update Customer",
                "4) Delete Customer",
                "5) Find All Customers",
                "6) Back to Home"
        };

        while (true) {
            for (String question : customerQuestions) {
                System.out.println(question);
            }
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    saveCustomer();
                    break;
                case 2:
                    findCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }
    }

    // update customer
    public static void updateCustomer() {
    }

    //find customer
    public static void findCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Nic");
        String nic = input.nextLine();

        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0]!=null){
                if (customers[i][0].equals(nic)){
                    System.out.println("=======================Customer==================");
                    System.out.println("Nic:" +customers[i][0]);
                    System.out.println("Name:" +customers[i][1]);
                    System.out.println("Address:" +customers[i][2]);
                    System.out.println("Salary:" +customers[i][3]);
                    System.out.println("=======================Customer==================");
                    return;
                }
            }
        }
        System.out.println("Customer Not Found");
    }

    //save customer
    public static void saveCustomer() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String nic, name, address;
            double salary;
            System.out.println("Insert Customer NIC");
            nic = input.nextLine();
            System.out.println("Insert Customer Name");
            name = input.nextLine();
            System.out.println("Insert Customer Address");
            address = input.nextLine();
            System.out.println("Insert Customer Salary");
            salary = input.nextDouble();
            //=========================
            customerForLoop:
            for (int i = 0; i < customers.length; i++) {
                if (customers[i][0] != null) {
                    if (customers[i][0].equals(nic)) {
                        System.out.println("Customer Already Exists!");
                        break;
                    }
                }else{
                    customers[i][0] = nic;
                    customers[i][1] = name;
                    customers[i][2] = address;
                    customers[i][3] = String.valueOf(salary); // string <= double ()
                    //====================
                    System.out.println("Customer Saved!\n");
                    System.out.println("1) Do you want to add an another customer?");
                    System.out.println("2) Back to Main Menu");
                    int option = input.nextInt();
                    switch (option) {
                        case 1:
                            break customerForLoop;
                        case 2:
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }



    public static void printUi(String position) {
        Date date = new Date(); // util,sql*******Don't //
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String simpleDate = dateFormat.format(date); // 2023-01-10
        String simpleTime = timeFormat.format(date); // 10:10:50
        System.out.println("==========" + simpleDate + "======" + simpleTime + "==>" + position);
        //System.out.println("=======================@System==================================");
    }
}