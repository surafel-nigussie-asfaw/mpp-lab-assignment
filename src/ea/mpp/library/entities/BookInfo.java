package ea.mpp.library.entities;

import java.util.ArrayList;
import java.util.List;

public class BookInfo {
	private int maxLeaseDays;
	private String title;
	private String ISBN;
	private List<Author> authors;
	private List<BookCopy> bookCopies;
	
	
	public BookInfo(int maxLeaseDays, String title, String iSBN) {
		this(maxLeaseDays, title, iSBN, new ArrayList<>(), new ArrayList<>());
	}
	
	public BookInfo(int maxLeaseDays, String title, String iSBN, List<Author> authors, List<BookCopy> bookCopies) {
		this.maxLeaseDays = maxLeaseDays;
		this.title = title;
		ISBN = iSBN;
		this.authors = authors;
		this.bookCopies = bookCopies;
	}

	public boolean isAvailable() {
		//TODO: implementation
		return false;
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

	public int getCopies() {
		
		return bookCopies.size();
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title: ").append(title)
		.append("\nISBN: ").append(ISBN)
		.append("\nAuthor").append(authors.isEmpty() ? "" : "s").append(":");
		
		authors.forEach(author -> { builder.append("\n").append(author.toString()).append("\n"); });
		
		builder.append("\nCopies: ").append(bookCopies.size());
		
		return builder.toString();
	}
	
}
