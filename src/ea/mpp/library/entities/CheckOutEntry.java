package ea.mpp.library.entities;

import java.util.Date;

public class CheckOutEntry {
	private Date dateOfCheckOut;
	private Date dueDate;
	private BookCopy bookCopy;
	
	public CheckOutEntry(Date dateOfCheckOut, Date dueDate, BookCopy bookCopy) {
		this.dateOfCheckOut = dateOfCheckOut;
		this.dueDate = dueDate;
		this.bookCopy = bookCopy;
	}

	public Date getDateOfCheckOut() {
		return dateOfCheckOut;
	}

	public void setDateOfCheckOut(Date dateOfCheckOut) {
		this.dateOfCheckOut = dateOfCheckOut;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public int getCopyId() {
		return bookCopy.getCopyId();
	}
	
}
