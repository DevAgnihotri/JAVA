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
4. **Access Modifiers:** Keywords like `public`, `private`, `default` and `protected` that control access to class members.

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

---

## 🔹 3. Abstraction

**Definition:** Abstraction is the process of hiding the internal details of a showing only the relevant information to the user. It focuses on "what" an object does rather than "how" it does it.

**Key Characteristics of Abstraction:**

- **Simplification:** Reduces complexity by showing only the relevant details to the user.
- **Focus on Functionality:** Allows developers to focus on high-level design without worrying about implementation details.
- **Improved Maintainability:** Changes to the internal implementation do not affect the external interface.

**Real-Life Example:** A **Car dashboard** provides controls like steering, accelerator, and speedometer. The user interacts with these controls without needing to understand the internal mechanics of the engine or transmission.

**Types of Abstraction in Java:**

1. **Abstract Classes:** Classes that cannot be instantiated and may contain both abstract (unimplemented) and concrete (implemented) methods.
2. **Interfaces:** Fully abstract types that define a contract for classes to implement.

### ➤ Abstract Classes

**Syntax:**

```java
abstract class ClassName {
    // Abstract method (no body)
    abstract void methodName();

    // Concrete method (with body)
    void concreteMethod() {
        System.out.println("This is a concrete method.");
    }
}
```

**Code Example:**

```java
abstract class Car {
    abstract void start();

    void stop() {
        System.out.println("Car is stopping.");
    }
}

class Sedan extends Car {
    void start() {
        System.out.println("Sedan starting with key.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Sedan();
        myCar.start();
        myCar.stop();
    }
}
```

**Output:**

```
Sedan starting with key.
Car is stopping.
```

**Use Case:** Abstract classes are useful when we want to provide a common base class with some shared functionality while allowing subclasses to define specific behaviors.

### ➤ Interfaces

**Syntax:**

```java
interface InterfaceName {
    void methodName();
}
```

**Code Example:**

```java
interface Vehicle {
    void start();
    void stop();
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike starting with kick.");
    }

    public void stop() {
        System.out.println("Bike is stopping.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myBike = new Bike();
        myBike.start();
        myBike.stop();
    }
}
```

**Output:**

```
Bike starting with kick.
Bike is stopping.
```

**Use Case:** Interfaces are ideal for defining a contract that multiple classes can implement, ensuring consistency across different implementations.

**Advantages of Abstraction:**

- **Code Reusability:** Abstract classes and interfaces promote code reuse by defining common behaviors.
- **Flexibility:** Allows developers to change the implementation without affecting the external interface.
- **Security:** Hides sensitive implementation details from the user.

**Best Practices for Abstraction:**

- Use abstract classes when you need to share code among related classes.
- Use interfaces when you need to define a contract for unrelated classes.
- Avoid overusing abstraction, as it can lead to unnecessary complexity.

> 📘 **Note:** Abstraction is a cornerstone of OOP, enabling developers to build scalable and maintainable applications by separating concerns and focusing on high-level design.

---

## 🔹 4. Encapsulation

**Definition:** Encapsulation is the technique of wrapping data (variables) and code (methods) together as a single unit and restricting access to some components. It ensures that the internal representation of an object is hidden from the outside world, exposing only what is necessary.

**Key Characteristics of Encapsulation:**

- **Data Hiding:** Internal details of an object are hidden, and only a controlled interface is exposed.
- **Access Control:** Access modifiers like `private`, `protected`, and `public` are used to control access to class members.
- **Improved Security:** Sensitive data is protected from unauthorized access or modification.
- **Ease of Maintenance:** Changes to the internal implementation do not affect external code that uses the object.

**Advantages of Encapsulation:**

1. **Improved Code Maintainability:** Encapsulation allows changes to the internal implementation without affecting external code.
2. **Enhanced Security:** By restricting access to certain components, encapsulation prevents unintended interference or misuse.
3. **Modularity:** Encapsulation helps in dividing a program into smaller, manageable parts.
4. **Reusability:** Encapsulated code can be reused across different parts of a program or in other programs.
5. **Flexibility:** Encapsulation allows developers to modify the internal workings of a class without impacting its external behavior.

**Real-Life Example:** A **Car's speedometer**—you can see the speed but can't directly change the way it calculates speed. The internal mechanism is hidden, and only the result is exposed.

**How Encapsulation Works in Java:**

1. Declare the variables of a class as `private`.
2. Provide `public` getter and setter methods to access and update the values of private variables.

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

    // Getter method
    public int getSpeed() {
        return speed;
    }

    // Setter method
    public void setSpeed(int s) {
        if (s >= 0) { // Adding validation
            speed = s;
        } else {
            System.out.println("Speed cannot be negative.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setSpeed(50); // Setting speed
        System.out.println("Car speed: " + myCar.getSpeed()); // Getting speed
    }
}
```

**Output:**

```
Car speed: 50
```

**Best Practices for Encapsulation:**

1. Always declare class variables as `private` to restrict direct access.
2. Use meaningful names for getter and setter methods, following the naming convention (`getVariableName`, `setVariableName`).
3. Add validation logic in setter methods to ensure data integrity.
4. Avoid exposing unnecessary internal details through getter and setter methods.
5. Document the purpose of each getter and setter method for better maintainability.

> 📘 **Note:** Encapsulation is a fundamental principle of OOP that promotes data security, modularity, and maintainability, making it easier to build robust and scalable applications.

---

## 🔹 5. Inheritance

**Definition:** Inheritance is a mechanism in object-oriented programming that allows one class (child or subclass) to inherit the properties and behaviors of another class (parent or superclass). It promotes code reuse and establishes a natural hierarchy between classes.

**Real-Life Example:** An **ElectricCar** inherits general properties from a **Car** like wheels, steering, and the ability to drive, while adding its own unique behavior, such as charging the battery.

---

### ➤ Key Characteristics of Inheritance:

1. **Code Reusability:** Common functionality can be written in the parent class and reused in child classes, reducing redundancy.
2. **Hierarchical Structure:** Inheritance establishes a parent-child relationship, creating a clear hierarchy in the codebase.
3. **Extensibility:** Child classes can extend the functionality of the parent class by adding new methods or overriding existing ones.
4. **Polymorphism Support:** Inheritance enables polymorphism, allowing a child class to provide its own implementation of a parent class method.

---

### ➤ Syntax:

```java
class ParentClass {
    // fields and methods
}

class ChildClass extends ParentClass {
    // additional fields and methods
}
```

---

### ➤ Code Example:

```java
class Car {
    String brand;

    void drive() {
        System.out.println("Driving a car");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    void charge() {
        System.out.println("Charging the battery");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricCar myElectricCar = new ElectricCar();
        myElectricCar.brand = "Tesla";
        myElectricCar.batteryCapacity = 100;
        myElectricCar.drive(); // Inherited from Car
        myElectricCar.charge(); // Defined in ElectricCar
    }
}
```

**Output:**

```
Driving a car
Charging the battery
```

---

### ➤ Types of Inheritance in Java:

1. **Single Inheritance:** A child class inherits from one parent class.

   ```java
   class Parent {}
   class Child extends Parent {}
   ```

2. **Multilevel Inheritance:** A class inherits from a child class, forming a chain.

   ```java
   class Grandparent {}
   class Parent extends Grandparent {}
   class Child extends Parent {}
   ```

3. **Hierarchical Inheritance:** Multiple child classes inherit from a single parent class.
   ```java
   class Parent {}
   class Child1 extends Parent {}
   class Child2 extends Parent {}
   ```

> 📘 **Note:** Java does not support multiple inheritance with classes to avoid ambiguity (the "diamond problem"). However, it can be achieved using interfaces.

---

### ➤ Method Overriding in Inheritance:

Child classes can provide their own implementation of a method defined in the parent class. This is known as **method overriding**.

**Code Example:**

```java
class Car {
    void start() {
        System.out.println("Starting a generic car");
    }
}

class SportsCar extends Car {
    @Override
    void start() {
        System.out.println("Starting a sports car with a roar");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new SportsCar();
        myCar.start(); // Calls the overridden method in SportsCar
    }
}
```

**Output:**

```
Starting a sports car with a roar
```

---

### ➤ Advantages of Inheritance:

1. **Code Reusability:** Reduces duplication by reusing existing code in parent classes.
2. **Improved Maintainability:** Changes in the parent class automatically propagate to child classes.
3. **Extensibility:** Allows adding new features to child classes without modifying the parent class.
4. **Polymorphism:** Enables dynamic method invocation, improving flexibility and scalability.

---

### ➤ Best Practices for Using Inheritance:

1. **Use Inheritance for "Is-A" Relationships:** Ensure the child class is a specialized version of the parent class (e.g., an ElectricCar "is a" Car).
2. **Avoid Deep Inheritance Hierarchies:** Keep the hierarchy shallow to reduce complexity and improve readability.
3. **Favor Composition Over Inheritance:** Use composition when a "Has-A" relationship is more appropriate (e.g., a Car "has a" Engine).
4. **Override Methods Judiciously:** Only override methods when necessary to provide specific behavior in the child class.
5. **Document the Hierarchy:** Clearly document the purpose of each class in the hierarchy for better maintainability.

> 📘 **Note:** Inheritance is a powerful tool in OOP, but it should be used carefully to avoid tight coupling and maintain a clean, modular design.

---

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
