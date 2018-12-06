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
		for (BookCopy copy : bookCopies) {
			if(copy.isAvailable()) {
				copy.setAvailable(false);
				return copy;
			}
		}
		return null;
	}
	
	public BookCopy checkAvailableBook() {
		for (BookCopy copy : bookCopies) {
			if(copy.isAvailable()) {
				return copy;
			}
		}
		return null;
	}
	
	public void returnBookCopy(int copyId) {
		for (BookCopy bookCopy : bookCopies) {
			if (bookCopy.getCopyId() == copyId) {
				bookCopy.setAvailable(true);
			}
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getNumberOfBooksAvailable() {
		int count = 0;
		for (BookCopy bookCopy : bookCopies) {
			if(bookCopy.isAvailable())
				count++;
		}
		return count;
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
