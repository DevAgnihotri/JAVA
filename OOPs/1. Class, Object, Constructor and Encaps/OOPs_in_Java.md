# Object Oriented Programming (OOP) in Java

Object Oriented Programming (OOP) is a programming paradigm based on the concept of "objects," which can contain data and code to manipulate that data. Java is a language that strongly supports OOP principles.

---

## 🔹 1. Objects

**Definition:** An object is an instance of a class. It represents a real-world entity with state and behavior.

**Key Characteristics of Objects:**

- **State:** Represented by attributes or fields (e.g., a car's color, brand, and model).
- **Behavior:** Represented by methods or functions (e.g., a car can drive, brake, or honk).
- **Identity:** Each object has a unique identity, which distinguishes it from other objects, even if they have the same state and behavior.

**How Objects Work:**

- Objects are created using the `new` keyword in Java.
- They occupy memory space and can interact with other objects through method calls.

**Advantages of Using Objects:**

- **Modularity:** Objects help break down complex systems into smaller, manageable parts.
- **Reusability:** Objects can be reused across different parts of a program or even in other programs.
- **Encapsulation:** Objects bundle data and methods together, promoting data security and abstraction.

**Example in Real Life:**

- A **Person** object can have attributes like name, age, and height (state) and behaviors like walking, talking, and eating (methods).

**Code Example:**

```java
class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Alice";
        person.age = 25;
        person.introduce();
    }
}
```

**Output:**

```
Hi, my name is Alice and I am 25 years old.
```

---

## 🔹 2. Classes

**Definition:** A class is a blueprint from which individual objects are created. It defines fields and methods.

**Key Characteristics of Classes:**

- **Blueprint for Objects:** A class provides the structure and behavior that its objects will have.
- **Encapsulation:** Classes encapsulate data and methods, ensuring modularity and security.
- **Reusability:** Classes can be reused in different parts of a program or in other programs.
- **Inheritance Support:** Classes can inherit properties and behaviors from other classes, promoting code reuse.

**Components of a Class:**

1. **Fields (Attributes):** Variables that hold the state of the object.
2. **Methods:** Functions that define the behavior of the object.
3. **Constructors:** Special methods used to initialize objects.
4. **Access Modifiers:** Keywords like `public`, `private`, and `protected` that control access to class members.

**Real-Life Example:** A **Car class** is a blueprint. Multiple car objects like sedan, SUV, and hatchback can be made from it.

**Syntax:**

```java
class ClassName {
    // fields
    // methods
}
```

**Code Example:**

```java
class Car {
    String model;
    int year;

    void honk() {
        System.out.println("Honking");
    }
}
```

**Use Case:** Organizing car-related data and behaviors like honking and model/year info.

**Advantages of Using Classes:**

- **Modularity:** Classes help divide a program into smaller, manageable parts.
- **Abstraction:** Classes allow hiding of implementation details while exposing only necessary functionalities.
- **Scalability:** Classes make it easier to scale applications by adding new features or modifying existing ones.

**Best Practices for Defining Classes:**

- Use meaningful names for classes that reflect their purpose.
- Keep classes focused on a single responsibility (Single Responsibility Principle).
- Use access modifiers to enforce encapsulation.
- Document the purpose and usage of the class for better maintainability.
- Avoid making classes unnecessarily large; split them into smaller, cohesive classes if needed.

## 🔹 3. Abstraction

**Definition:** Abstraction is the process of hiding internal details and showing only essential information.

**Real-Life Example:** A **Car dashboard** provides only necessary controls like steering and speedometer; the internal engine workings are abstracted away.

**Syntax (abstract class):**

```java
abstract class ClassName {
    abstract void method();
}
```

**Code Example:**

```java
abstract class Car {
    abstract void start();
}

class Sedan extends Car {
    void start() {
        System.out.println("Sedan starting with key");
    }
}
```

**Use Case:** Creating a general Car class to be extended by specific car types.

---

## 🔹 4. Encapsulation

**Definition:** Encapsulation is the technique of wrapping data (variables) and code (methods) together as a single unit and restricting access to some components.

**Real-Life Example:** A **Car's speedometer**—you can see the speed but can't change the way it calculates speed.

**Syntax (getter/setter):**

```java
private Type var;
public Type getVar();
public void setVar(Type val);
```

**Code Example:**

```java
class Car {
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }
}
```

**Use Case:** Hiding and controlling car speed access.

---

## 🔹 5. Inheritance

**Definition:** Inheritance allows one class to acquire properties and behaviors from another class.

**Real-Life Example:** An **ElectricCar** inherits general properties from Car like wheels and steering.

**Syntax:**

```java
class ChildClass extends ParentClass {
    // additional methods or fields
}
```

**Code Example:**

```java
class Car {
    void drive() {
        System.out.println("Driving a car");
    }
}

class ElectricCar extends Car {
    void charge() {
        System.out.println("Charging battery");
    }
}
```

**Use Case:** Sharing general car functionalities with electric or hybrid variations.

---

## 🔹 6. Polymorphism

**Definition:** Polymorphism allows a single method to perform differently based on the object calling it.

**Real-Life Example:** The **start()** action for different cars—key start, push-button start, or remote start.

### ➤ Compile-Time Polymorphism (Method Overloading)

**Syntax:**

```java
returnType methodName(param1);
returnType methodName(param1, param2);
```

**Code Example:**

```java
class Car {
    void start() {
        System.out.println("Starting car");
    }

    void start(String mode) {
        System.out.println("Starting car in " + mode + " mode");
    }
}
```

**Use Case:** Starting the car differently based on driver preferences.

### ➤ Run-Time Polymorphism (Method Overriding)

**Syntax:**

```java
class SubClass extends SuperClass {
    @Override
    returnType methodName() {
        // new implementation
    }
}
```

**Code Example:**

```java
class Car {
    void start() {
        System.out.println("Generic car start");
    }
}

class SportsCar extends Car {
    @Override
    void start() {
        System.out.println("Sports car roars to life");
    }
}
```

**Use Case:** Allowing different car models to start in their own unique way.

---

## 🔹 OOP in Java

**Definition:** Java is a class-based, object-oriented programming language that implements OOP principles strictly.

### Key Features:

- Class-based structure
- Support for Abstraction, Encapsulation, Inheritance, and Polymorphism
- Built-in access modifiers: `private`, `public`, `protected`, and default

**Syntax:**

```java
public class ClassName {
    // fields and methods
}
```

**Use Case:** Building robust, modular, and scalable car-related Java applications.

---

## 🔹 Related Concepts

### ➤ Constructor

**Definition:** A constructor is a special method invoked when an object is created. Used for initialization.

**Real-Life Example:** A **Car factory** uses a constructor to create a fully set-up car.

**Syntax:**

```java
ClassName() {
    // initialization code
}
```

**Code Example:**

```java
class Car {
    Car() {
        System.out.println("Car constructed");
    }
}
```

**Use Case:** Automatically initializing car data during creation.

---

### ➤ Interface

**Definition:** An interface is a contract that a class can implement. It contains abstract methods only.

**Real-Life Example:** A **Car control interface** defines buttons like accelerate and brake. Any car can implement these.

**Syntax:**

```java
interface InterfaceName {
    void method();
}
```

**Code Example:**

```java
interface CarFeatures {
    void playMusic();
}

class LuxuryCar implements CarFeatures {
    public void playMusic() {
        System.out.println("Playing music in car");
    }
}
```

**Use Case:** Implementing a common set of features across various car types.

---

### ➤ "this" Keyword

**Definition:** The `this` keyword refers to the current instance of the class.

**Real-Life Example:** Inside a **Car object**, saying "this color" refers to the specific car's color.

**Syntax:**

```java
this.variableName = variableName;
```

**Code Example:**

```java
class Car {
    String brand;
    Car(String brand) {
        this.brand = brand;
    }
}
```

**Use Case:** Clarifying object fields when variable names conflict with method parameters.

---

> 📘 **Note:** Mastery of OOP concepts leads to better design and development of clean, maintainable Java applications.

---
