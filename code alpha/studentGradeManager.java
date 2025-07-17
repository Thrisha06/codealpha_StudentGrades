import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        System.out.println("=== Student Grades Manager ===");
        boolean continueInput = true;

        while (continueInput) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = -1;
            while (grade < 0 || grade > 100) {
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.print("Invalid grade. Enter a value between 0 and 100: ");
                    }
                } else {
                    System.out.print("Invalid input. Enter a numeric value: ");
                    scanner.next(); // discard invalid input
                }
            }
            scanner.nextLine(); // clear buffer

            studentNames.add(name);
            studentGrades.add(grade);

            System.out.print("Add another student? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            continueInput = response.equals("yes");
        }

        if (studentNames.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }

        // Summary calculations
        double total = 0;
        double highest = studentGrades.get(0);
        double lowest = studentGrades.get(0);
        int highestIndex = 0, lowestIndex = 0;

        for (int i = 0; i < studentGrades.size(); i++) {
            double grade = studentGrades.get(i);
            total += grade;

            if (grade > highest) {
                highest = grade;
                highestIndex = i;
            }
            if (grade < lowest) {
                lowest = grade;
                lowestIndex = i;
            }
        }

        double average = total / studentGrades.size();

        // Display summary
        System.out.println("\n=== Summary Report ===");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("%s: %.2f%n", studentNames.get(i), studentGrades.get(i));
        }

        System.out.printf("%nAverage Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %.2f (%s)%n", highest, studentNames.get(highestIndex));
        System.out.printf("Lowest Grade: %.2f (%s)%n", lowest, studentNames.get(lowestIndex));

        scanner.close();
    }
}

               