import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int firstNumber = Integer.parseInt(input[0]);
            int secondNumber = Integer.parseInt(input[1]);

            switch (firstNumber) {
                case 1 -> isOdd(secondNumber);
                case 2 -> {
                    if (isPrime(secondNumber)) {
                        System.out.println("PRIME");
                    } else {
                        System.out.println("COMPOSITE");
                    }
                }
                case 3 -> isPalindrome(secondNumber);
            }
        }


    }

    private static void isPalindrome(int number) {
        int reverse = 0;
        int temp = number;
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }

        if (reverse == number) {
            System.out.println("PALINDROME");
        } else {
            System.out.println("NOT PALINDROME");
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void isOdd(int number) {
        if (number % 2 != 0) {
            System.out.println("ODD");
        } else {
            System.out.println("EVEN");
        }
    }
    
}
