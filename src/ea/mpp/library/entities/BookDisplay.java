
package ea.mpp.library.entities;

public class BookDisplay {

	private BookInfo bookInfo;

	public BookDisplay(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getDisplayText() {
		return bookInfo.toString();
	}

	@Override
	public String toString() {
		return bookInfo.getTitle();
	}
}
