package ea.mpp.library.controllers;

import java.util.List;

import ea.mpp.library.entities.*;

public class AdminController {

	/*Data Access Object for Books: To be edited later*/
//	DAO dataAccess = new DAO();
	
	public AdminController() {

	}

	// adding book to the data store	
	public boolean addBook(String title, String ISBN, int maxLeaseDays, List<Author> authors, List<BookCopy> copies) {

		BookInfo bookInfo = new BookInfo(maxLeaseDays, title, ISBN, authors, copies);

//
//		if (dataAccess.bookExists(bookInfo)) {
//
//			return false;
//		}
//
//		else {
//
//			return dataAccess.createBook(bookInfo);
//		}

		
		return false;
	}
	
	
	//getting all the books from the data store
	public List<BookInfo> getBooks(){
		
//		DAO dataAccess = new DAO();
		
//		return dataAccess.getBooks();
		
		
		return null;
	}
	
	
	//editing an existing book in the store
	public boolean editBook(BookInfo book) {
		
//		if(dataAccess.updateBook(book)) {
//			
//			return true;
//		}
//		
//		else 
//		{
//			
//			return false;
//		}
		
		
		return false;
	}

}
