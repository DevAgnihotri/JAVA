public class BookAccess {
    private static void comparePrices(Book book1, Book book2) {
        float book1Price = book1.getPrice();
        float book2Price = book2.getPrice();
        String pricecmp = "";
        if (book1Price < book2Price) {
            pricecmp = book1.getTitle() + " costs less than " + book2.getTitle();
        } else if (book1Price == book2Price) {
            pricecmp = book1.getTitle() + " cost as much as " + book2.getTitle();
        } else {
            pricecmp = book1.getTitle() + " cost more than " + book2.getTitle();
        }
        System.out.println("Message:-> " + pricecmp);
    }

    public static void main(String s[]) {
        Book book1 = new Book();
        book1.setTitle("Atomic Habits");
        book1.setAuthor("James Clear");
        book1.setPrice(30.00f);
        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        System.out.println("The first book object is");
        System.out.println(book1);
        System.out.println("The Second book object is");
        System.out.println(book2);
        comparePrices(book1, book2);

    }
}
