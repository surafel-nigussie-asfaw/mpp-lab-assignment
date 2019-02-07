package ea.mpp.library.controllers;

import java.util.Calendar;
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
		bookInfoDAO.update(bookInfo);

		//create checkout entry
		CheckOutEntry checkOutEntry = new CheckOutEntry(new Date(), addDays(new Date(), bookInfo.getMaxLeaseDays()), bookCopy);


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

	public CheckOutRecord checkIn(int libraryMemberId, String iSBN, int bookCopyId) {
		//does member exist
		LibraryMember libraryMember = memberDAO.get(libraryMemberId);
		if(libraryMember == null) {
			CheckOutRecord record = new CheckOutRecord(null);
			record.setHasError(true);
			record.setErrorMessage("Memeber doesn't exist.");
			return record;
		}else {

			//check for member record
			CheckOutRecord record = checkOutRecordDAO.get(libraryMemberId);
			if(record == null) {
				record = new CheckOutRecord(null);
				record.setHasError(true);
				record.setErrorMessage("Memeber has no checkout record.");
				return record;
			} else {
				if(record.getCheckOutEntries().size() == 0) {
					record = new CheckOutRecord(null);
					record.setHasError(true);
					record.setErrorMessage("Has record, but can't find check out entry.");
					return record;
				}else {
					//member has record, update book info
					for (CheckOutEntry entry : record.getCheckOutEntries()) {
						if(entry.getBookCopy().getCopyId() == bookCopyId) {
							//update book info 
							BookInfo bookInfo = bookInfoDAO.get(iSBN);
							bookInfo.returnBookCopy(bookCopyId);
							bookInfoDAO.update( bookInfo);
							record.setHasError(false);
							record.setErrorMessage("Successfully checkedIn.");
							return record;
						} else {
							record = new CheckOutRecord(null);
							record.setHasError(true);
							record.setErrorMessage("No check out record for book.");
							return record;
						}
					}
				}
			}

			return null;
		}
	}

	public static Date addDays(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return cal.getTime();
	}

	public List<BookDisplay> searchBookByTitle(String text) {
		return bookInfoDAO
				.searchBooksByTitle(text)
				.stream()
				.map(BookDisplay::createFromBookInfo)
				.collect(Collectors.toList());
	}

}
