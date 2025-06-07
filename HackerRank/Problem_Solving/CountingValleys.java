import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestProjectApplication {
    public static void main(String[] args) {
        int valleysExited = 0;
        int seaLevel = 0;

        Scanner scanner = new Scanner(System.in);

        int steps = Integer.parseInt(scanner.nextLine());
        List<String> path = Arrays.asList(scanner.nextLine().split(""));

        for (String step : path) {
            switch (step) {
                case "U" -> {
                    seaLevel++;

                    if (seaLevel == 0) {
                        valleysExited++;
                    }
                }
                case "D" -> {
                    seaLevel--;
                }
            }
        }

        System.out.println(valleysExited);
    }
}
