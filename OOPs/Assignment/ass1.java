import java.util.Scanner;

public class ass1 {

    private static void processAndDisplayNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a real number: ");
        double number = scanner.nextDouble();

        int ceil = (int) Math.ceil(number);
        int floor = (int) Math.floor(number);

        System.out.println("Smallest integer not less than the number: " + ceil +
                "\nThe number itself: " + number +
                "\nLargest integer not greater than the number:  " + floor);

        scanner.close();
    }

    public static void main(String[] args) {
        processAndDisplayNumber();
    }

}
