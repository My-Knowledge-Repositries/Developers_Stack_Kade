import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AppInitializer {
    //==========Database area========= (access all around the project)
    static String[][] users = new String[3][2];


    //==========Database area=========
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitState=false;


        // program initialization
        String[] initializePageQuestions =
                {
                        "1) Do you want to login?",
                        "2) Are you new to here?",
                        "3) Do you want to exit the page?"
                };


        while (!exitState){
            for (String question : initializePageQuestions) {
                System.out.println(question);
            }


            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    // just for our testing process
                    users[0][0]="hasika@gmail.com";
                    users[0][1]="1234";
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


        // program initialization
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
            if (users[i][0] != null && users[i][0].equals(email)) { // & vs &&
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


    // login process
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


    // register process
    // dashboard process
    public static void openDashboard() {
        System.out.println("inside the dashboard");
    }
    // dashboard process


    public static void printUi(String position){
        Date date = new Date(); // util,sql*******Don't //
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


        String simpleDate = dateFormat.format(date); // 2023-01-10
        String simpleTime = timeFormat.format(date); // 10:10:50
        System.out.println("=========="+simpleDate+"======"+simpleTime+"==>"+position);
        //System.out.println("=======================@System==================================");
    }

}
