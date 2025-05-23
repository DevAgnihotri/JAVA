public class Animal {
    private String name;
    private String food;

    public Animal(String name) {
        this.name = name;
    }

    public String sound() {
        return null;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return this.food;
    }

    public String toString() {
        return name.concat(" says ").concat(sound().concat(" eats ").concat(food));
    }

}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public String sound() {
        return "meow";
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    public String sound() {
        return "moo";
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public String sound() {
        return "bark";
    }
}