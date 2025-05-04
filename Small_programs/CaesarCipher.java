import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        /*
        In cryptography, the Caesar cipher is one of the simplest and most widely known encryption techniques. To learn
        more about it check - https://en.wikipedia.org/wiki/Caesar_cipher. My version of the Caesar cipher takes as an
        input the word you want to encrypt and a number by which, we will move the letters. If the new position
        points to a number bigger than the alphabet size, the counter starts from the begging.

        Example 1:
        - Input: abcd
        - Number: 3
        - Output: defg
        - Explanation: The first letter "a" is at position 1. When we sum 1 + 3 = 4, the 4th letter in the english
          alphabet is "d". The same applies to "b" -> 2 + 3 = 5 -> "e"; "c" -> 3 + 3 = 6 -> "f"; "d" -> 4 + 3 = 7 -> "g"

        Example 2:
        - Input: zzzywx
        - Number: 4
        - Output: dddcab
        - Explanation: The letter "z" is the last letter in the english alphabet on position - 26. Since 26 is the last
          available position we start from the beginning. In the case of "z" -> 0 + 4 = 4 -> "d". The next letter "y"
          is the 25th in the alphabet, so we start counting from 25 but we reach the end again(26), so we continue from
          the beginning. In this case 25 + 4 = 29 -> we are 3 steps out of 26, so we start from 0 and count 3 steps.
          The 3th letter in the english alphabet is "c". The same applies for "w" and "x".
         */

        Scanner scanner = new Scanner(System.in);

        List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        String input = scanner.nextLine();
        String[] split = input.split("");
        int step = Integer.parseInt(scanner.nextLine());

        for (String s : split) {
            Character character = alphabet.stream().filter(letter -> letter.toString().equals(s)).findFirst().orElse(' ');
            int letter = alphabet.indexOf(character);

            if (letter + step >= alphabet.size()) {
                System.out.print(alphabet.get((letter + step) - alphabet.size()));
            } else if (letter == -1) {
                System.out.print(" ");
            } else {
                System.out.print(alphabet.get(letter + step));
            }

        }
    }
}
