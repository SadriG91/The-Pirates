import java.util.Scanner;
import javax.swing.*;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.*;
import java.util.Objects;

public class Main {
    private final Ship JC = null;

    public static void main(String[] args) throws SQLException {
        Connection conn = Database.createConnection();
        Statement stmt = conn.createStatement();

        String myString1 = "select * from ships where name = 'JonssonCargo'";
        String myString2 = "select * from ships where name = 'MotherRussia'";
        String myString3 = "select * from ships where name = 'AkerstromShipping'";
        String myString4 = "select * from ships where name = 'NordicExpress'";
        String myString5 = "select * from ships where name = 'FarEastCargo'";
        String myString6 = "select * from ships where name = 'Evergreen'";
        String myString7 = "select * from ships where name = 'CasablancaExpress'";
        String myString8 = "select * from ships where name = 'RotterdamGreen'";
        String myString9 = "select * from ships where name = 'HamburgSud'";
        String myString10 = "select * from ships where name = 'OceanExpress'";

        Ship JC = (Ship) Database.createShip(stmt, myString1);
        Ship MR = (Ship) Database.createShip(stmt, myString2);
        Ship AS = (Ship) Database.createShip(stmt, myString3);
        Ship NE = (Ship) Database.createShip(stmt, myString4);
        Ship FE = (Ship) Database.createShip(stmt, myString5);
        Ship EG = (Ship) Database.createShip(stmt, myString6);
        Ship CE = (Ship) Database.createShip(stmt, myString7);
        Ship RG = (Ship) Database.createShip(stmt, myString8);
        Ship HS = (Ship) Database.createShip(stmt, myString9);
        Ship OE = (Ship) Database.createShip(stmt, myString10);

        JC.start();
        boolean go = true;
        while (go) {
            JC.printInfo();
            try {
                Thread.sleep(1200);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }

    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    public void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|          Welcome operator!        |");
        System.out.println("+-----------------------------------+");
    }

    public void printMenu() {
        System.out.println("\nMake your selection");
        System.out.println("[1] Ship");
        System.out.println("[2] Order");
        System.out.println("[3] Map");
        System.out.println("[4] Status");
        System.out.println("[0] Exit");
    }

    public int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 4) {
            try {
                System.out.print("\nEnter your choice: ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again");
            }
        }
        return choice;
    }

    public String getInput2() {
        Scanner kb = new Scanner(System.in);
        String choice;

        System.out.print("\nEnter your choice: ");
        choice = kb.nextLine();

        return choice;
    }

    public void performAction(int choice) {
        switch (choice) {
        case 0:
            exit = true;
            System.out.println("Thank your for using our simulator");
            break;
        case 1:

            break;
        case 2:
            // Order();
            break;
        case 3:
            // Map();
        case 4:
            // Status();
        default:
            System.out.println("Unknown error has occured");
        }
    }
}
