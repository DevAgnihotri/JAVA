import java.util.Scanner;

public class ass1 {

    Scanner sc = new Scanner(System.in);

    public void processAndDisplayNumber() {
        // Assignment question 5.7

        System.out.print("Enter a real number: ");
        double number = sc.nextDouble();

        int ceil = (int) Math.ceil(number);
        int floor = (int) Math.floor(number);

        System.out.println("Smallest integer not less than the number: " + ceil +
                "\nThe number itself: " + number +
                "\nLargest integer not greater than the number:  " + floor);

        sc.close();
    }

    public void calculateDistance() {
        char continueCalculation;
        // Get initial velocity and acceleration
        System.out.print("Enter initial velocity (u) in m/s: ");
        double initialVelocity = sc.nextDouble();

        System.out.print("Enter acceleration (a) in m/s²: ");
        double acceleration = sc.nextDouble();

        // Get time interval
        System.out.print("Enter time interval in seconds: ");
        double time = sc.nextDouble();

        // Display header
        System.out.println("\nTime (s)\tInitail Velocity (u)\tDistance (m)");
        System.out.println("-----------------------------------------------");

        // Calculate and display distance at regular intervals
        double distance = initialVelocity * time + 0.5 * acceleration * time * time;
        System.out.printf("%.2f\t\t%.2f\t\t%.2f\n", time, initialVelocity, distance);
        sc.close();
    }

    public static void main(String[] args) {
        // Ask user which program to run
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose program to run:");
        System.out.println("1. Number ceiling and floor calculator");
        System.out.println("2. Distance calculator");
        int choice = sc.nextInt();

        ass1 obj = new ass1();
        if (choice == 1) {
            obj.processAndDisplayNumber();
        } else if (choice == 2) {
            obj.calculateDistance();
        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }

}
