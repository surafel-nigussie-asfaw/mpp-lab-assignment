package ea.mpp.library.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.Person;
import ea.mpp.library.entities.Address;

<<<<<<< HEAD
public class BookInfoDAO {
	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>();

=======
public class BookInfoDAO 
{

	@SuppressWarnings("serial")
	private Map<String, BookInfo> bookInfoDataMap = new HashMap<String, BookInfo>() {
		{
			BookInfo bookOne = new BookInfo(7, "UML Distilled", "1234567", new ArrayList<>(), new ArrayList<>());
			BookInfo bookTwo = new BookInfo(7, "Java for the impatient", "7654321", new ArrayList<>(), new ArrayList<>());
			
			put(bookOne.getISBN(), bookOne);
			put(bookTwo.getISBN(), bookTwo);
		}
	};
	
>>>>>>> ff90c998f1147a7a01dc42fcc3702e190fb4da58
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
<<<<<<< HEAD

	public BookInfo add(String iSBN, BookInfo value) {
		return bookInfoDataMap.put(iSBN, value);
=======
	
	public BookInfo add(BookInfo value) {
		return bookInfoDataMap.put(value.getISBN(), value);
>>>>>>> ff90c998f1147a7a01dc42fcc3702e190fb4da58
	}

	public BookInfo update(BookInfo value) {
		
		for (Entry<String, BookInfo> entry : bookInfoDataMap.entrySet()) {
		
			if(((BookInfo)entry.getValue()).getISBN().equals(value.getISBN())){
								
				String updatedKey=entry.getKey();
				
				bookInfoDataMap.replace(updatedKey,value);
				
			}
			
		}
		
		return get(value.getTitle());
	}

	public BookInfo get(String iSBN) {
		return bookInfoDataMap.get(iSBN);
	}

	public BookInfo delete(String iSBN) {
		return bookInfoDataMap.remove(iSBN);
	}
<<<<<<< HEAD

//	public List<BookInfo> search(String key) {
//		List<BookInfo> result = new ArrayList<BookInfo>();
//		for(Map<String, BookInfo> books: bookInfoDataMap )
//
//		if (bookInfoDataMap.containsKey(key)) {
//			bookcopies.add(bookInfoDataMap.get(key));
//		}
//
//	}
=======
	
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

	public boolean exists(String ISBN) {
		return bookInfoDataMap.containsKey(ISBN);
	}
	
	public List<BookInfo> getAll() {
		
		List<BookInfo> bookInfos=new ArrayList<BookInfo>();
		
		for (BookInfo bookInfo : bookInfoDataMap.values()) {
			
			bookInfos.add(bookInfo);
		}
		
		return bookInfos;
	}
	
	public int count() {
		
		return bookInfoDataMap.size();
	}
	
>>>>>>> ff90c998f1147a7a01dc42fcc3702e190fb4da58
}
