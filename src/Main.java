import java.util.Scanner;
import javax.swing.*;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.*;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class Main {

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
        String myString10 = "select * from ships where name = 'OceansExpress'";

        Ship JC = (Ship) Database.createShip(stmt, myString1);
        Objects.requireNonNull(JC).setPathNumber(1);
        Ship MR = (Ship) Database.createShip(stmt, myString2);
        Objects.requireNonNull(MR).setPathNumber(2);
        Ship AS = (Ship) Database.createShip(stmt, myString3);
        Objects.requireNonNull(AS).setPathNumber(3);
        Ship NE = (Ship) Database.createShip(stmt, myString4);
        Objects.requireNonNull(NE).setPathNumber(4);
        Ship FE = (Ship) Database.createShip(stmt, myString5);
        Objects.requireNonNull(FE).setPathNumber(5);
        Ship EG = (Ship) Database.createShip(stmt, myString6);
        Objects.requireNonNull(EG).setPathNumber(6);
        Ship CE = (Ship) Database.createShip(stmt, myString7);
        Objects.requireNonNull(CE).setPathNumber(7);
        Ship RG = (Ship) Database.createShip(stmt, myString8);
        Objects.requireNonNull(RG).setPathNumber(8);
        Ship HS = (Ship) Database.createShip(stmt, myString9);
        Objects.requireNonNull(HS).setPathNumber(9);
        Ship OE = (Ship) Database.createShip(stmt, myString10);
        Objects.requireNonNull(OE).setPathNumber(10);

        JC.start();
        MR.start();
        AS.start();
        NE.start();
        FE.start();
        EG.start();
        CE.start();
        RG.start();
        HS.start();
        OE.start();

        List<Object> shipList = new ArrayList<Object>();

        shipList.add(JC);
        shipList.add(MR);
        shipList.add(AS);
        shipList.add(NE);
        shipList.add(FE);
        shipList.add(EG);
        shipList.add(CE);
        shipList.add(RG);
        shipList.add(HS);
        shipList.add(OE);
        boolean run = true;
        while (run) {
            Scanner userInput = new Scanner(System.in);
            String shipChoice = Main.selectShip();
            System.out.println("enter 1 for simple console print for selected ship or 2 for GUI");

            int choice = userInput.nextInt();

            switch (choice) {
            case 1:
                for (int i = 0; i < shipList.size(); i++) {
                    Ship object = (Ship) shipList.get(i);
                    if (object.getName().equals(shipChoice)) {
                        System.out.println("det funkade");
                        System.out.println(object);
                        object.printInfo();
                    }
                }

            case 2:
                Ship object1 = (Ship) shipList.get(0);
                int x1 = object1.getX();
                int y1 = object1.getY();
                object1.start();
                Ship object2 = (Ship) shipList.get(1);
                int x2 = object2.getX();
                int y2 = object2.getY();
                object2.start();
                Ship object3 = (Ship) shipList.get(2);
                int x3 = object3.getX();
                int y3 = object3.getY();
                object3.start();
                Ship object4 = (Ship) shipList.get(3);
                int x4 = object4.getX();
                int y4 = object4.getY();
                Ship object5 = (Ship) shipList.get(4);
                int x5 = object5.getX();
                int y5 = object5.getY();
                Ship object6 = (Ship) shipList.get(5);
                int x6 = object6.getX();
                int y6 = object6.getY();
                Ship object7 = (Ship) shipList.get(6);
                int x7 = object7.getX();
                int y7 = object7.getY();
                Ship object8 = (Ship) shipList.get(7);
                int x8 = object8.getX();
                int y8 = object8.getY();
                Ship object9 = (Ship) shipList.get(8);
                int x9 = object9.getX();
                int y9 = object9.getY();
                Ship object10 = (Ship) shipList.get(9);
                int x10 = object10.getX();
                int y10 = object10.getY();

                for (int i = 0; i < shipList.size(); i++) {
                    Ship object = (Ship) shipList.get(i);
                    if (object.getName().equals(shipChoice)) {
                        String name = object.getName();
                        String lastHarbor = object.getHarborName();
                        String destination = object.getDestination();
                        int currentWeight = object.getCurrentWeight();
                        int cruiseSpeed = object.getCruiseSpeed();
                        DialogWindow.Sea(name, lastHarbor, destination, currentWeight, cruiseSpeed, x1, y1, x2, y2, x3,
                                y3, x4, y4, x5, y5, x6, y6, x7, y7, x8, y8, x9, y9, x10, y10);

                    }

                }

            }
        }

    }

    public static String selectShip() {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter shipname:");
        String shipChoice = kb.nextLine();
        return shipChoice;

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

    public static void printMenu() {
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
