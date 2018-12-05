package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.BookInfo;

public class BookInfoDAO {
	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>();
	
	public BookInfo add(String bookTitle, BookInfo value) {
		return bookInfoDataMap.put(bookTitle, value);
	}

	public BookInfo update(String bookTitle, BookInfo value) {
		return bookInfoDataMap.put(bookTitle, value);
	}

	public BookInfo get(String bookTitle) {
		return bookInfoDataMap.get(bookTitle);
	}

	public BookInfo delete(String bookTitle) {
		return bookInfoDataMap.remove(bookTitle);
	}
}
