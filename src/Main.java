public class Main {

    public static void main(String[] args) {
        int y = 97;
        int x = 2;
        for (int i = 0; i <= 100; i++) {
            String b = "{" + x + "," + y + "},";
            print(b);
            y--;

        }

    }

    // printa ut i konsolen med ett kortare kommado
    public static void print(String printthis) {
        System.out.println(printthis);
    }
}
