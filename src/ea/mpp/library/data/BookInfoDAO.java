package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.BookInfo;

public class BookInfoDAO {
	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>();
	
	public BookInfo add(String iSBN, BookInfo value) {
		return bookInfoDataMap.put(iSBN, value);
	}

	public BookInfo update(String iSBN, BookInfo value) {
		return bookInfoDataMap.put(iSBN, value);
	}

	public BookInfo get(String iSBN) {
		return bookInfoDataMap.get(iSBN);
	}

	public BookInfo delete(String iSBN) {
		return bookInfoDataMap.remove(iSBN);
	}
}
