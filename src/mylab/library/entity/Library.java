package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private String name;
	List<Book> bookList = new ArrayList<>();
	
	public Library(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public Book findBookByTitle(String title) {
		
		Book targetBook = null;
		
		for (Book book : bookList) {
			if (book.getTitle().equals(title)) {
				targetBook = book;
			}
		}
		
		return targetBook;
	}
	
	public List<Book> findBooksByAuthor(String author) {
		List<Book> targetBookList = new ArrayList<>();
		
		for (Book book : bookList) {
			if (book.getAuthor().equals(author)) {
				targetBookList.add(book);
			}
		}
		
		return targetBookList;
	}

	public Book findBookByISBN(String isbn) {
		Book targetBook = null;
		
		for (Book book : bookList) {
			if (book.getIsbn().equals(isbn)) {
				targetBook = book;
			}
		}
		
		return targetBook;
	}
	
	public boolean checkOutBook(String isbn) {
		Book targetBook = findBookByISBN(isbn);
		
		if (targetBook.isAvailable()) {
			targetBook.setAvailable(false);
			return true;
		}
		
		return false;
	}
	
	public boolean returnBook(String isbn) {
		Book targetBook = findBookByISBN(isbn);
		
		if (!targetBook.isAvailable()) {
			targetBook.setAvailable(true);
			return true;
		}
		
		return false;
	}
	
	public List<Book> getAvailableBooks() {
		List<Book> targetBookList = new ArrayList<>();
		
		for (Book book : bookList) {
			if (book.isAvailable()) {
				targetBookList.add(book);
			}
		}
		
		return targetBookList;
	}
	
	public List<Book> getAllBooks() {
		return bookList;
	}
	
	public int getTotalBooks() {
		
		return bookList.size();
	}

	public int getAvailableBooksCount() {
		
		return getAvailableBooks().size();
	}
	
	public int getBorrowedBooksCount() {
		
		int count = 0;
		
		for (Book book : bookList) {
			if (!book.isAvailable()) {
				count += 1;
			}
		}
		
		return count;
	}


	


}
