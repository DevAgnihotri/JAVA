import java.util.Scanner;

public class AnimalFarm {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Animal[] animals = new Animal[10];
        int anmlIdx = 0;

        while (true) {
            System.out.println("Press 1 to view the animals, " +
                    "\n2 to add animals, " +
                    "\nany other key to exit");
            String userAction = sc.nextLine();
            if (userAction.equals("1")) {
                for (int i = 0; i < animals.length; i++) {
                    if (animals[i] != null)
                        System.out.println(animals[i]);
                }
            } else if (userAction.equals("2")) {
                if (anmlIdx == 10) {
                    System.out.println("10 Animals already added can't add more");
                    continue;
                }
                System.out.println("Which animal do you want to create? \nPress 1 for dog," +
                        "\n2 for cat " +
                        "\n3 for cow");
                String animalChoice = sc.nextLine();
                if (animalChoice.equals("1")) {
                    System.out.println("Enter the name of the dog");
                    String dogName = sc.nextLine();
                    Animal anmlTmp = new Dog(dogName);
                    System.out.println("Enter what the Dog eats ");
                    String dogFood = sc.nextLine();
                    anmlTmp.setFood(dogFood);
                    animals[anmlIdx++] = anmlTmp;

                } else if (animalChoice.equals("2")) {
                    System.out.println("Enter name of the cat");
                    String catName = sc.nextLine();
                    Animal anmlTmp = new Cat(catName);
                    System.out.println("Enter what the cat eats");
                    String catFood = sc.nextLine();
                    anmlTmp.setFood(catFood);
                    animals[anmlIdx++] = anmlTmp;

                } else if (animalChoice.equals("3")) {
                    System.out.println("Enter name of the cow");
                    String cowName = sc.nextLine();
                    Animal anmlTmp = new Cat(cowName);
                    System.out.println("Enter what the cow eats");
                    String cowFood = sc.nextLine();
                    anmlTmp.setFood(cowFood);
                    animals[anmlIdx++] = anmlTmp;

                }
            } else {
                System.out.println("Bye");
                break;
            }
        }
    }
}