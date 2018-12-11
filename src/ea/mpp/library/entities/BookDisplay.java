
package ea.mpp.library.entities;

public class BookDisplay {

	private BookInfo bookInfo;

	private BookDisplay(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	private BookDisplay() {}
	
	public static BookDisplay createFromBookInfo(BookInfo bookInfo) {
		return new BookDisplay(bookInfo);
	}

	public String getDisplayText() {
		return bookInfo.toString();
	}

	@Override
	public String toString() {
		return bookInfo.getTitle();
	}
}
