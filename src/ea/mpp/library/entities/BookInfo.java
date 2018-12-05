package ea.mpp.library.entities;

import java.util.List;

public class BookInfo {
	private int maxLeaseDays;
	private String title;
	private String ISBN;
	private List<Author> authors;
	private List<BookCopy> bookCopies;
	
	public BookInfo(int maxLeaseDays, String title, String iSBN) {
		this.maxLeaseDays = maxLeaseDays;
		this.title = title;
		this.ISBN = iSBN;
	}
	
	public BookInfo(int maxLeaseDays, String title, String iSBN, List<Author> authors, List<BookCopy> bookCopies) {
		this.maxLeaseDays = maxLeaseDays;
		this.title = title;
		ISBN = iSBN;
		this.authors = authors;
		this.bookCopies = bookCopies;
	}

	public boolean isAvailable() {
		if(bookCopies.size() > 0) {
			return true;
		}else {
			return false;
		}
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
		ISBN = iSBN;
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
	
}
