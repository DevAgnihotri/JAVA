// Implement Cloneable interface to allow cloning

public class Book implements Cloneable {
    // The Cloneable interface is a marker interface (has no methods) that indicates
    // the class supports cloning. Without implementing Cloneable, calling clone()
    // on an object will throw CloneNotSupportedException.

    private String title; // Title of the book
    private String author; // Author of the book
    private float price; // Price of the book

    public Book() {
        // Default constructor initializes title and author to null
        this.title = null;
        this.author = null;
    }

    public Book(String title, String author, float price) {
        // Parameterized constructor to initialize the book's title, author, and price
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Overriding the clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // The clone() method creates and returns a copy of the object.
        // The super.clone() method performs a shallow copy of the object.
        // This means that primitive fields (like price) are copied directly,
        // and object references (like title and author) are copied as references.
        return super.clone();
    }

    public void setTitle(String title) {
        // Setter method for the title field
        this.title = title;
    }

    public void setAuthor(String author) {
        // Setter method for the author field
        this.author = author;
    }

    public void setPrice(float price) {
        // Setter method for the price field
        this.price = price;
    }

    public String getTitle() {
        // Getter method for the title field
        return this.title;
    }

    public String getAuthor() {
        // Getter method for the author field
        return this.author;
    }

    public float getPrice() {
        // Getter method for the price field
        return this.price;
    }

    public String toString() {
        // Overriding the toString() method to provide a string representation of the
        // book
        return "Title - " + this.title + "\nAuthor - "
                + this.author + "\nPrice - " + String.format("%.2f", this.price);
    }

    // Alternate method
    // if (this.title.equals(book2.getTitle()) &&
    // this.author.equals(book2.getAuthor()) &&
    // this.price == book2.getPrice())
    public boolean equals(Book book1, Book book2) {
        if (book1.title == book2.title && book1.price == book2.price && book1.author == book2.author) {
            return true;
        } else {
            return false;
        }
    }
}