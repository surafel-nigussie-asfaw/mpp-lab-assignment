package ea.mpp.library.entities;

import java.util.List;

public class BookInfo {
	private int maxLeaseDays;
	private String title;
	private String ISBN;
	private List<Author> authors;
	private List<BookCopy> bookCopies;
	private String errorMessage;
	
	public BookInfo(int maxLeaseDays, String title, String iSBN) {
		this.maxLeaseDays = maxLeaseDays;
		this.title = title;
		this.ISBN = iSBN;
	}
	
	public BookInfo(int maxLeaseDays, String title, String iSBN, List<Author> authors, List<BookCopy> bookCopies) {
		this.maxLeaseDays = maxLeaseDays;
		this.title = title;
		this.ISBN = iSBN;
		this.authors = authors;
		this.bookCopies = bookCopies;
	}

	public int getMaxLeaseDays() {
		return maxLeaseDays;
	}

	public void setMaxLeaseDays(int maxLeaseDays) {
		this.maxLeaseDays = maxLeaseDays;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}
	
	public BookCopy getAvailableBook() {
		BookCopy bookcopy = null;
		for (BookCopy copy : bookCopies) {
			if(copy.isAvailable()) {
				bookcopy = copy;
				copy.setAvailable(false);
			}
		}
		return bookcopy;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
