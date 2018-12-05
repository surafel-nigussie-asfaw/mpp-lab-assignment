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
	
	public BookInfo checkOut(int libraryMemberId, String iSBN) {
		//dummy data
		BookInfo bookInfo = new BookInfo(0, "", "");
		
		//check for member
		LibraryMember libraryMember = memberDAO.get(libraryMemberId);
		if(libraryMember == null) {
			bookInfo.setErrorMessage("Memeber doesn't exist.");
			return bookInfo;
		}
		
		//check if there is available book
		bookInfo = bookInfoDAO.get(iSBN);
		BookCopy bookCopy;
		if(bookInfo != null) {
			bookCopy = bookInfo.getAvailableBook();
			bookInfoDAO.update(iSBN, bookInfo);
			if(bookCopy == null){
				bookInfo.setErrorMessage("We dont have any book available.");
			}
		}else {
			bookInfo.setErrorMessage("We don't have the book.");
			return bookInfo;
		}
		
		//create checkout entry
		CheckOutEntry checkOutEntry = new CheckOutEntry(new Date(), /**/new Date(), bookCopy);
		
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
		
		bookInfo.setErrorMessage("Check Out Successful");
		return bookInfo;
	}
}
