public class AnimalFarm {
    public static void main(String args[]) {
        // Creating objects
        Animal animal1 = new Dog("Sami");
        Animal animal2 = new Cat("Hershey");
        Animal animal3 = new Cow("Molly");

        // Printing
        System.out.println("animal1 sound" + animal1.sound());
        System.out.println("animal2 sound" + animal2.sound());
        System.out.println("animal3 sound" + animal3.sound());
    }
}