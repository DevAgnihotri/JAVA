/*
 * This class demonstrates the use of the `clone()` method in Java.
 * The `main` method creates instances of the `Book` class, sets their properties,
 * and clones one of the objects to create a new object with the same state.
 *
 * Key Points:
 * - The `clone()` method is used to create a copy of an object.
 * - The `Cloneable` interface must be implemented in the class to allow cloning.
 * - The `throws CloneNotSupportedException` declaration is required because the `clone()` method
 *   in the `Object` class throws this exception if the object being cloned does not implement `Cloneable`.
 *
 * Example of `throws CloneNotSupportedException`:
 * If a class does not implement `Cloneable` and you attempt to call `clone()` on its object:
 * 
 * ```java
 * Object obj = new Object();
 * Object clonedObj = obj.clone(); // This will throw CloneNotSupportedException
 * ```
 * 
 * To avoid this, the class must implement `Cloneable`, and the method invoking `clone()` must either
 * handle the exception using a `try-catch` block or declare it using `throws CloneNotSupportedException`.
 */
public class BookAccess {
    // The `main` method is the entry point of the program.
    // It declares `throws CloneNotSupportedException` because the `clone()` method
    // is invoked,
    // and it may throw this exception if the object being cloned does not implement
    // `Cloneable`.
    public static void main(String s[]) throws CloneNotSupportedException {
        // Create the first book object using the parameterized constructor
        Book book1 = new Book("Atomic Habits", "James Clear", 30.00f);

        // Create the second book object using the default constructor
        Book book2 = new Book();
        // Set the properties of the second book object
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        // Print the details of the first book object
        System.out.println("The first book object is ");
        System.out.println(book1);

        // Print the details of the second book object
        System.out.println("The second book object is ");
        System.out.println(book2);

        // Clone the first book object to create a third book object
        // The `clone()` method is called here, which creates a shallow copy of `book1`.
        // Since `Book` implements `Cloneable`, this operation is allowed.
        Book book3 = (Book) (book1.clone());

        // Print the details of the cloned third book object
        System.out.println("The third book cloned object is ");
        System.out.println(book3);
    }
}