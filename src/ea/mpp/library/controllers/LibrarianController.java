package ea.mpp.library.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ea.mpp.library.data.BookInfoDAO;
import ea.mpp.library.data.CheckOutRecordDAO;
import ea.mpp.library.data.MemberDAO;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookDisplay;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.CheckOutEntry;
import ea.mpp.library.entities.CheckOutRecord;
import ea.mpp.library.entities.LibraryMember;

public class LibrarianController {
	private static LibrarianController instance = new LibrarianController();

	private MemberDAO memberDAO = new MemberDAO();
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private CheckOutRecordDAO checkOutRecordDAO = new CheckOutRecordDAO();

	private LibrarianController() {}

	public static LibrarianController getInstance() {return instance;}

	public boolean checkOut(LibraryMember libraryMember, Date dateOfCheckOut, Date dueDate, BookCopy bookCopy) {
		//create entry
		CheckOutEntry checkOutEntry = new CheckOutEntry(dateOfCheckOut, dueDate, bookCopy);
		//get record by member id
		CheckOutRecord checkOutRecord = checkOutRecordDAO.get(libraryMember.getLibraryMemberId());
		//add check out entry 
		checkOutRecord.getCheckOutEntries().add(checkOutEntry);
		//save
		checkOutRecordDAO.update(libraryMember.getLibraryMemberId(), checkOutRecord);
		//validate
		return true;
	}

	public List<BookDisplay> searchBookByTitle(String text) {
		return bookInfoDAO.searchBooksByTitle(text)
			.stream()
			.map(bookInfo -> { 
				return new BookDisplay(bookInfo);
			}).collect(Collectors.toList());
	}

}
