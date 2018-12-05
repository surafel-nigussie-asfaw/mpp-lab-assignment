package ea.mpp.library.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.Person;

public class BookInfoDAO {
	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>();
	
	public BookInfoDAO() {
		List<Author> authors = new ArrayList<>();
		authors.add(new Author("creds tom", "bio tom", new Person("tom", "robert", "9798798")));
		authors.add(new Author("creds roger", "bio roger", new Person("roger", "federer", "666666")));
		
		List<BookCopy> bookcopies = new ArrayList<>();
		bookcopies.add(new BookCopy(1234));
		bookcopies.add(new BookCopy(5467));
		bookcopies.add(new BookCopy(6588));
		
		bookInfoDataMap.put("isbn", new BookInfo(10, "the love", "isbn", authors, bookcopies));
	}
	
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
