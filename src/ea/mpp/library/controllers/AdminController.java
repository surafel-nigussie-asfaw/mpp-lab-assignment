package ea.mpp.library.controllers;

import java.util.List;

import ea.mpp.library.entities.*;

public class AdminController {

	public AdminController() {

	}

	public boolean addBook(String title, String ISBN, int maxLeaseDays, List<Author> authors, List<BookCopy> copies) {

		BookInfo bookInfo = new BookInfo(maxLeaseDays, title, ISBN, authors, copies);

//		DAO dataAccess = new DAO();
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

}
