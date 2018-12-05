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
	
	public BookInfo getBookInfo(int libraryMemberId, String iSBN) {
		//check for member
		LibraryMember libraryMember = memberDAO.get(libraryMemberId);
		if(libraryMember == null) {
			BookInfo bookInfo = new BookInfo(0, "", "");
			bookInfo.setErrorMessage("Memeber doesn't exist.");
			return bookInfo;
		}
		
		//check if there is available book
		BookInfo bookInfo = bookInfoDAO.get(iSBN);
		bookInfo.setErrorMessage(null);
		BookCopy bookCopy;
		if(bookInfo != null) {
			bookCopy = bookInfo.checkAvailableBook();
			if(bookCopy == null){
				bookInfo.setErrorMessage("We dont have any book available.");
			}
		}else {
			BookInfo bookInfo2 = new BookInfo(0, "", "");
			bookInfo2.setErrorMessage("This book doesn't exist.");
			return bookInfo2;
		}
		
		return bookInfo;
	}
	
	public CheckOutRecord checkOut(int libraryMemberId, String iSBN) {
		//check for member
		LibraryMember libraryMember = memberDAO.get(libraryMemberId);
		
		//check if there is available book
		BookInfo bookInfo = bookInfoDAO.get(iSBN);
		BookCopy bookCopy = bookInfo.getAvailableBook();
		bookInfoDAO.update(iSBN, bookInfo);
		BookInfo _bookInfo = bookInfoDAO.get(iSBN);
		
		//create checkout entry
		CheckOutEntry checkOutEntry = new CheckOutEntry(new Date(), new Date(), bookCopy);
		
		//get record by member id
		CheckOutRecord checkOutRecord = checkOutRecordDAO.get(libraryMember.getLibraryMemberId());
		
		//if record exist, add to existing else create new one
		if(checkOutRecord != null){
			checkOutRecord.getCheckOutEntries().add(checkOutEntry);
			checkOutRecordDAO.update(libraryMember.getLibraryMemberId(), checkOutRecord);
			checkOutRecord.setErrorMessage("Sucessfully checked out!");
			return checkOutRecord;
		} else {
			CheckOutRecord newCheckOutRecord = new CheckOutRecord(libraryMember);
			newCheckOutRecord.getCheckOutEntries().add(checkOutEntry);
			checkOutRecordDAO.add(libraryMember.getLibraryMemberId(), newCheckOutRecord);
			newCheckOutRecord.setErrorMessage("Sucessfully checked out!");
			return newCheckOutRecord;
		} 
	}
}
