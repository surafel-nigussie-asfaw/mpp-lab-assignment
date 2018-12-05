package ea.mpp.library.controllers;

import java.util.Date;
import java.util.List;

import ea.mpp.library.data.BookInfoDAO;
import ea.mpp.library.data.CheckOutRecordDAO;
import ea.mpp.library.data.MemberDAO;
import ea.mpp.library.entities.BookCopy;
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
	
	public String checkOut(int libraryMemberId, Date dateOfCheckOut, Date dueDate, String bookTitle) {
		//check for member
		LibraryMember libraryMember = memberDAO.get(libraryMemberId);
		if(libraryMember == null) {
			return "Memeber doesn't exist.";
		}
		
		//check if there is available book
		BookInfo bookInfo = bookInfoDAO.get(bookTitle);
		BookCopy bookCopy;
		if(bookInfo != null) {
			if(bookInfo.isAvailable()) {
				//get a book from book info
				int size = bookInfo.getBookCopies().size();
				//get the last book
				bookCopy = bookInfo.getBookCopies().remove(size-1);
				//update the record
				bookInfoDAO.update(bookTitle, bookInfo);
			}else {
				return "Book isn't available.";
			}
		}else {
			return "We don't have the book.";
		}
		
		//create checkout entry
		CheckOutEntry checkOutEntry = new CheckOutEntry(dateOfCheckOut, dueDate, bookCopy);
		
		//get record by member id
		CheckOutRecord checkOutRecord = checkOutRecordDAO.get(libraryMember.getLibraryMemberId());
		
		//if record exist, add to existing else create new one
		if(checkOutRecord != null){
			checkOutRecord.getCheckOutEntries().add(checkOutEntry);
			checkOutRecordDAO.update(libraryMember.getLibraryMemberId(), checkOutRecord);
		} else {
			CheckOutRecord newCheckOutRecord = new CheckOutRecord(libraryMember);
			newCheckOutRecord.getCheckOutEntries().add(checkOutEntry);
			checkOutRecordDAO.add(libraryMember.getLibraryMemberId(), newCheckOutRecord);
		} 
		
		return "Check Our Successful";
	}
}
