import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(count + " " + input);
            count++;
        }
    }
}
