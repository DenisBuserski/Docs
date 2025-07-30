import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayList myList = new ArrayList();

        for (int i = 0; i < m; i++) {
            myList.add(sc.nextInt());
        }

        myList.add("###");

        for (int j = 0; j < n; j++) {
            myList.add(sc.next());
        }

        int index = myList.indexOf("###");
        for (int i = index + 1; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

    }
}
