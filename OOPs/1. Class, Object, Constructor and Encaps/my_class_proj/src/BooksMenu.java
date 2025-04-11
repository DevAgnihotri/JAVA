import java.util.Scanner;

public class BooksMenu {
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        Book[] books = new Book[10];
        int bkIdx = 0;
        while (true) {
            System.out.println("Press 1 to view books, 2 to add books, 3 to compare prices, any other key to exit");
            String userAction = scanner.nextLine();
            System.out.println("User Action is" + userAction);
            if (userAction.equals("1")) {
                for (int i = 0; i < books.length; i++) {
                    if (books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if (bkIdx == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }
                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();
                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());
                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tmpPrice);
                books[bkIdx++] = bkTmp;

            } else if (userAction.equals("3")) {
                int i = 0;
                int flag = (books[0] != null) ? 1 : 0;
                if (flag == 0) {
                    System.out.println("No books buddy");
                    continue;
                }
                while (i < books.length) {
                    if (books[i] != null) {
                        System.out.println(i + "->" + books[i].getTitle());
                    }
                    i++;
                }
                System.out.println("Enter first index: ");
                int a = scanner.nextInt();
                System.out.println("Enter second index: ");
                int b = scanner.nextInt();
                BookAccess.comparePrices(books[a], books[b]);
            }
            // Alternate way // Option 3: Compare prices of two books
            // else if (userAction.equals("3")) {
            // // Prompt the user for the indices of the books to compare
            // System.out.println("Enter index of first book to compare");
            // int book1Idx = Integer.parseInt(scanner.nextLine());
            // System.out.println("Enter index of second book to compare");
            // int book2Idx = Integer.parseInt(scanner.nextLine());
            // // Check if the selected indices contain valid Book objects
            // if (books[book1Idx] != null && books[book2Idx] != null) {
            // // Compare the books and print the details of the more expensive book
            // System.out.println("The details of expensive book is \n" +
            // getExpensiveBook(books[book1Idx], books[book2Idx]));
            // } else {
            // System.out.println("One of the books is null"); // Error message if an index
            // is empty
            // }
            // }

            else {
                break;
            }
        }
    }
}