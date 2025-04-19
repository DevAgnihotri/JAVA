public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String sound() {
        return null;
    }

    public String toString() {
        return name.concat("says").concat(sound());
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