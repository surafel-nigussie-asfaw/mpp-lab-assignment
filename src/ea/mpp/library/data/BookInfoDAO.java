package ea.mpp.library.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ea.mpp.library.entities.BookInfo;

public class BookInfoDAO {
	
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
	
	public List<BookInfo> searchBooksByTitle(String text) {

		StringBuilder builder = new StringBuilder()
			.append("(.*)")
			.append(text.toLowerCase())
			.append("(.*)");
		String searchText = builder.toString();
		
		List<BookInfo> booksFound = bookInfoDataMap
			.values()
			.stream()
			.filter(bookInfo -> {
				return bookInfo.getTitle()
						.toLowerCase()
						.matches(searchText);
			})
			.collect(Collectors.toList());
		
		return new ArrayList<BookInfo>(booksFound);
	}

	public boolean bookExists(String ISBN) {
		return bookInfoDataMap.containsKey(ISBN);
	}
	
}
