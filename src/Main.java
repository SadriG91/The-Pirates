import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private boolean exit;

    public static void main(String[] args) throws SQLException, InterruptedException {
        Database.loginUsername(); // Kan tas bort tills presentationen men glöm inte att lägga in login info i
                                  // database classen
        Database.loginPassword();

        Connection conn = Database.createConnection();
        Statement stmt = Objects.requireNonNull(conn).createStatement();

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
        MR.start();
        AS.start();
        NE.start();
        FE.start();
        EG.start();
        CE.start();
        RG.start();
        HS.start();
        OE.start();

        List<String> shipList = new ArrayList<String>();// Creating arraylist
        shipList.add(JC.getName());
        shipList.add(MR.getName());
        shipList.add(AS.getName());
        shipList.add(NE.getName());
        shipList.add(FE.getName());
        shipList.add(EG.getName());
        shipList.add(CE.getName());
        shipList.add(RG.getName());
        shipList.add(HS.getName());
        shipList.add(OE.getName());
        Scanner kb = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("enter 1 or 2");

            int value = kb.nextInt();
            switch (value) {
            case 1:
                checkShipName(JC, MR, AS, NE, FE, EG, CE, RG, HS, OE, shipList);// Kalla på den här funktionen när du
                                                                                // vill
                Thread.sleep(1000);

                break;
            case 2:
                listShipName(JC, MR, AS, NE, FE, EG, CE, RG, HS, OE, stmt);

            default:
                break;
            }

        }
        kb.close();

    }

    private static void listShipName(Ship JC, Ship MR, Ship AS, Ship NE, Ship FE, Ship EG, Ship CE, Ship RG, Ship HS,
            Ship OE, Statement stmt) throws SQLException {
        String name = JC.getName();
        String lastHarbor = JC.getHarborName();
        String destination = JC.getDestination();
        int currentWeight = JC.getCurrentWeight();
        int cruiseSpeed = JC.getCruiseSpeed();

        int x1 = JC.getX();
        int y1 = JC.getY();
        String name1 = JC.getName();
        Database.storeData(stmt, x1, y1, name1);

        int x2 = MR.getX();
        int y2 = MR.getY();
        String name2 = MR.getName();
        Database.storeData(stmt, x2, y2, name2);

        int x3 = AS.getX();
        int y3 = AS.getY();
        String name3 = AS.getName();
        Database.storeData(stmt, x3, y3, name3);

        int x4 = NE.getX();
        int y4 = NE.getY();
        String name4 = NE.getName();
        Database.storeData(stmt, x4, y4, name4);

        int x5 = FE.getX();
        int y5 = FE.getY();
        String name5 = FE.getName();
        Database.storeData(stmt, x5, y5, name5);

        int x6 = EG.getX();
        int y6 = EG.getY();
        String name6 = EG.getName();
        Database.storeData(stmt, x6, y6, name6);

        int x7 = CE.getX();
        int y7 = CE.getY();
        String name7 = CE.getName();
        Database.storeData(stmt, x7, y7, name7);

        int x8 = RG.getX();
        int y8 = RG.getY();
        String name8 = RG.getName();
        Database.storeData(stmt, x8, y8, name8);

        int x9 = HS.getX();
        int y9 = HS.getY();
        String name9 = HS.getName();
        Database.storeData(stmt, x9, y9, name9);

        int x10 = OE.getX();
        int y10 = OE.getY();
        String name10 = OE.getName();
        Database.storeData(stmt, x10, y10, name10);

        DialogWindow.Sea(name, lastHarbor, destination, currentWeight, cruiseSpeed, x1, y1, x2, y2, x3, y3, x4, y4, x5,
                y5, x6, y6, x7, y7, x8, y8, x9, y9, x10, y10);

    }

    private static void checkShipName(Ship JC, Ship MR, Ship AS, Ship NE, Ship FE, Ship EG, Ship CE, Ship RG, Ship HS,
            Ship OE, List<String> shipList) {
        String shipChoice = Main.selectShip();
        for (String s : shipList) {
            // shipList.get(i);
            if (s.equals(shipChoice)) {
                System.out.println(s);
                System.out.println("det funkade");

                if (s.equals(JC.getName())) {
                    System.out.println(JC.getX() + "," + JC.getY());
                } else if (s.equals(MR.getName())) {
                    System.out.println(MR.getX() + "," + MR.getY());
                } else if (s.equals(AS.getName())) {
                    System.out.println(AS.getX() + "," + AS.getY());
                } else if (s.equals(NE.getName())) {
                    System.out.println(AS.getX() + "," + AS.getY());
                } else if (s.equals(FE.getName())) {
                    System.out.println(FE.getX() + "," + FE.getY());
                } else if (s.equals(EG.getName())) {
                    System.out.println(EG.getX() + "," + EG.getY());
                } else if (s.equals(CE.getName())) {
                    System.out.println(CE.getX() + "," + CE.getY());
                } else if (s.equals(RG.getName())) {
                    System.out.println(RG.getX() + "," + RG.getY());
                } else if (s.equals(HS.getName())) {
                    System.out.println(HS.getX() + "," + HS.getY());
                } else if (s.equals(OE.getName())) {
                    System.out.println(OE.getX() + "," + OE.getY());
                }

            }

        }
    }

    public static String selectShip() {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter shipname:");
        return kb.nextLine();

    }

    public void runMenu() {
        printHeader();
        // boolean exit = false;
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
            // exit = true;
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
