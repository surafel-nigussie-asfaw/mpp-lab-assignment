package ea.mpp.library.entities;

public class BookCopy {
	private int copyId;
	private BookInfo bookInfo;
	private boolean isAvailable;
	
	public BookCopy(int copyId, BookInfo bookInfo) {
		this.copyId = copyId;
		this.bookInfo = bookInfo;
		this.isAvailable = true;
	}	
	
	public BookCopy(int copyId) {
		this.copyId = copyId;
		this.isAvailable = true;
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
