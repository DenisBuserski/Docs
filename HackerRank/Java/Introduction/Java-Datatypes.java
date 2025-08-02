import java.util.*;

public class Main {
    public static void main(String[] argh) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            try {
                long x = scanner.nextLong();
                System.out.println(x + " can be fitted in:");

                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (x <= Short.MAX_VALUE && x >= Short.MIN_VALUE) {
                    System.out.println("* short");
                }
                if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE) {
                    System.out.println("* int");
                }
                if (x <= Long.MAX_VALUE && x >= Long.MIN_VALUE) {
                    System.out.println("* long");
                }
            } catch (Exception e) {
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }

        }
    }
}
