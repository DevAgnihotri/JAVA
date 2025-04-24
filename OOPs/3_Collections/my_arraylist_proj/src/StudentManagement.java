import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] k) {

        ArrayList<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Add a student");
            System.out.println("2. Update a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View all students");
            System.out.println("5. Sort students by age");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter Student name");
                String name = sc.nextLine();

                System.out.println("Enter Student age");
                int age = sc.nextInt();

                System.out.println("Enter Student major");
                String major = sc.nextLine();

                students.add(new Student(name, age, major));
                System.out.println("Student added Succesfully");
            }

            else if (choice == 2) {
                System.out.println("Enter the index of the student to update");
                int index = sc.nextInt();
                sc.nextLine();
                if (index >= 0 && index < students.size()) {
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter major: ");
                    String major = sc.nextLine();

                    students.get(index).setName(name);
                    students.get(index).setAge(age);
                    students.get(index).setMajor(major);
                    System.out.println("Student updated successfully!!");
                } else {
                    System.out.println("Invalid Index");
                }
            } else if (choice == 3) {
                System.out.print("Enter the index of the student to delete");
                int index = sc.nextInt();
                sc.nextLine();

                if (index >= 0 && index < students.size()) {
                    students.remove(index);
                    System.out.println("Student deleted successfully");
                } else {
                    System.out.println("Invalid index");
                }
            } else if (choice == 4) {
                if (students.isEmpty()) {
                    System.out.println("No Students Found");
                } else {
                    System.out.println("\n List of Students");
                    // for(int i=0; i < students.size(); i++)
                    // {
                    // System.out.println(i + ". " + students.get(i));
                    // }
                    students.forEach(student -> System.out.println(student));
                }
            } else if (choice == 5) {
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Integer.compare(s1.getAge(), s2.getAge());
                    }
                });

                System.out.println("Studetns sorted by age(Asc)");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(i + " " + students.get(i));
                }
            }

            else if (choice == 6) {
                System.out.println("Exiting the program");
                break;
            }

            else {
                System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}
