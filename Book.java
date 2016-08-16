/**
 *
 * @author Vítor
 */
import java.util.Comparator;


public class Book implements Comparable<Book>{

	private String title;
	private String author;
	private Integer year;
	
	public Book(String title, String author, Integer year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}


	@Override
	public int compareTo(Book book) {
		Integer compareYear = ((Book) book).getYear();

		return this.year - compareYear;
	}
	
	public static Comparator<Book> BookTitleComparator = new Comparator<Book>() {
		
		public int compare(Book book1, Book book2) {
		
			String bookTitle1 = book1.getTitle().toUpperCase();
			String bookTitle2 = book2.getTitle().toUpperCase();
			
			return bookTitle1.compareTo(bookTitle2);
		}

	};
	
	public static Comparator<Book> BookAuthorTitleComparator = new Comparator<Book>() {
		
		public int compare(Book book1, Book book2) {
			
			int value1 = book1.getAuthor().compareTo(book2.getAuthor());
			if (value1 == 0) {
	            return book2.getTitle().compareTo(book1.getTitle());
			}
	        return value1;
	    }
	};
	
	public static Comparator<Book> BookEditionAuthorTitleComparator = new Comparator<Book>() {
		
		public int compare(Book book1, Book book2) {
			
			int value1 = book2.getYear().compareTo(book1.getYear());
			if (value1 == 0) {
	            int value2 = book2.getAuthor().compareTo(book1.getAuthor());
	            if (value2 == 0) {
	            	return book1.getTitle().compareTo(book2.getTitle());
	            }
				return book2.getTitle().compareTo(book1.getTitle());
			}
	        return value1;
	    }
	};
	
}
