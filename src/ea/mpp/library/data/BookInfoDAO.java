package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.Person;

public class BookInfoDAO 
{

	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>();
	
	
	public BookInfo add(BookInfo value) {
		return bookInfoDataMap.put(value.getTitle(), value);
	}

	public BookInfo update(BookInfo value) {
		return bookInfoDataMap.put(value.getTitle(), value);
	}

	public BookInfo get(String title) {
		return bookInfoDataMap.get(title);
	}

	public BookInfo delete(String title) {
		return bookInfoDataMap.remove(title);
	}
	
	public boolean exists(String ISBN) {
		
		return bookInfoDataMap.containsKey(ISBN);
	}
	
	public int count() {
		
		return bookInfoDataMap.size();
	}
	
}
