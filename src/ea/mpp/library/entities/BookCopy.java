package ea.mpp.library.entities;

public class BookCopy {
	private int copyId;
	private BookInfo bookInfo;
	
	public BookCopy(int copyId, BookInfo bookInfo) {
		this.copyId = copyId;
		this.bookInfo = bookInfo;
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
	
}
