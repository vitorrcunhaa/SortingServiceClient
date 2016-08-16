/**
 *
 * @author Vítor Cunha
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingService {
	
	public static void main(String[] args) throws SortingServiceException {
		Book book1 = new Book("Java How to Program","Deitel & Deitel",2007);
		Book book2 = new Book("Patterns of Enterprise Application Architecture","Martin Fowler",2002);
		Book book3 = new Book("Head First Design Patterns","Elisabeth Freeman",2004);
		Book book4 = new Book("Intenet & World Wide Web: How to Program","Deitel & Deitel",2007);
		
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Order by: ");
		System.out.println("1-Title ascending");
		System.out.println("2-Author ascending/Title descending");
		System.out.println("3-Edition descending/Author descending/Title ascending");
		String input = scanner.nextLine();
        
        if (input.equals("1"))
        {
        	System.out.println("Ordered books by Title ascending:");
        	Collections.sort(books, Book.BookTitleComparator);
        } 
        else if (input.equals("2")) 
        {
        	System.out.println("Ordered books by Author ascending/Title descending:");
        	Collections.sort(books, Book.BookAuthorTitleComparator);
        }
        else if (input.equals("3")) 
        {
        	System.out.println("Ordered books by Edition descending/Author descending/Title ascending:");
        	Collections.sort(books, Book.BookEditionAuthorTitleComparator);
        }
        else
        {
        	throw new SortingServiceException("No entry");
        }
		
		for (Book book : books) {
			System.out.println("Title: " + book.getTitle());
			System.out.println("Author: " + book.getAuthor());
			System.out.println("Edition year: " + book.getYear());
			System.out.println();
		}

	}

}
