package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.BookInfo;

public class BookInfoDAO {
	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>();
	
	public BookInfo add(String title, BookInfo value) {
		return bookInfoDataMap.put(title, value);
	}

	public BookInfo update(String title, BookInfo value) {
		return bookInfoDataMap.put(title, value);
	}

	public BookInfo get(String title) {
		return bookInfoDataMap.get(title);
	}

	public BookInfo delete(String title) {
		return bookInfoDataMap.remove(title);
	}
}