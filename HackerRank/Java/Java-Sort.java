import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            int id = Integer.parseInt(input[0]);
            String name = input[1];
            double grade = Double.parseDouble(input[2]);

            Student student = new Student(id, name, grade);
            students.add(student);
        }

        Collections.sort(students, Comparator
                .comparing(Student::getGrade)
                .reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId));
        
        students.forEach(System.out::println);
    }
}

class Student {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name;
    }
}
