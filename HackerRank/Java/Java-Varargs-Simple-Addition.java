import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());
        int four = Integer.parseInt(scanner.nextLine());
        int five = Integer.parseInt(scanner.nextLine());
        int six = Integer.parseInt(scanner.nextLine());

        add(one, two);
        add(one, two, three);
        // add(one, two, three, four);
        add(one, two, three, four, five);
        add(one, two, three, four, five, six);
    }
    public static void add(int... args) {
        if (args.length != 0) {
            List<Integer> list = Arrays.stream(args).boxed().collect(Collectors.toList());
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                output.append(list.get(i)).append(i == list.size() - 1 ? "=" : "+");

            }
            System.out.println(output.append(Arrays.stream(args).sum()));
        }

    }
}
