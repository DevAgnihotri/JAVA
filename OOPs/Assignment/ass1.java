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
        // Assignment question 5.8

        char continueCalculation;
        System.out.print("Enter initial velocity (u) in m/s: ");
        double u = sc.nextDouble();

        System.out.print("Enter acceleration (a) in m/s²: ");
        double a = sc.nextDouble();

        System.out.print("Enter time interval in seconds: ");
        double time = sc.nextDouble();

        System.out.println("\nTime (s)\tInitail Velocity (u)\tAcceleration (a)\tDistance (m)");
        System.out.println("-------------------------------------------------------------------------");

        double distance = u * time + 0.5 * a * time * time;
        System.out.printf("%.2f\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n", time, u, a, distance);
        sc.close();
    }

    public void calculateEOQAndTBO() {
        // Assignment question 5.9
        // Economic Order Quantity (EOQ) and Time Between Orders (TBO) calculator

        System.out.print("Enter demand rate (items per unit time): ");
        double dr = sc.nextDouble();

        System.out.print("Enter setup costs (per order): ");
        double sco = sc.nextDouble();

        System.out.print("Enter holding cost (per item per unit time): ");
        double hc = sc.nextDouble();

        // Calculate EOQ
        double eoq = Math.sqrt((2 * dr * sco) / hc);

        // Calculate TBO
        double tbo = Math.sqrt((2 * sco) / (dr * hc));

        // Display results
        System.out.println("\nCalculation Results:");
        System.out.println("Economic Order Quantity (EOQ): " + String.format("%.2f", eoq) + " items");
        System.out.println("Time Between Orders (TBO): " + String.format("%.2f", tbo) + " time units");
    }

    public void naturalFrequency() {
        // Assignmet question 5.10
        // Values for testing:
        // Inductance (L): 0.0004
        // Resistance (R): 0.0002
        // Capacitance (C): 0.01 to 0.10 (increase rate by 0.01)
        System.out.println("This program calculates the natural frequency");
        System.out.print("Enter inductance: ");
        double l = sc.nextDouble();

        System.out.print("Enter resistance: ");
        double r = sc.nextDouble();

        System.out.printf("For Inductance %.4f and Resistance %.4f\n", l, r);
        System.out.println("Capcitance (c)\t\tFrequency (f)");
        System.out.println("--------------------------------------");
        for (double c = 0.01; c <= 0.10; c += 0.01) {
            // Fix the formula - should use L² not C² in denominator
            double discriminant = (1 / (l * c)) - ((r * r) / (4 * c * c));
            if (discriminant < 0) {
                System.out.printf("%.2f\t\t\t\t%.2f\tComplex (No Real Frequency)\n", c, discriminant);
            } else {
                double freq = Math.sqrt(discriminant);
                System.out.printf("%.2f\t\t\t\t%.2f\n", c, freq);
            }
        }
    }

    public static void main(String[] args) {
        // Ask user which program to run
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose program to run:");
        System.out.println("1. Number ceiling and floor calculator");
        System.out.println("2. Distance calculator");
        System.out.println("3. EOQ and TBO calculator");
        System.out.println("4. natural Frequency");
        int choice = sc.nextInt();

        ass1 obj = new ass1();
        if (choice == 1) {
            obj.processAndDisplayNumber();
        } else if (choice == 2) {
            obj.calculateDistance();
        } else if (choice == 3) {
            obj.calculateEOQAndTBO();
        } else if (choice == 4) {
            obj.naturalFrequency();
        } else {
            System.out.println("Invalid choice Bye");
        }

        sc.close();
    }

}
