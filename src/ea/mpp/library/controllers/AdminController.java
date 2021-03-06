package ea.mpp.library.controllers;

import java.util.List;
import java.util.Map;
import ea.mpp.library.entities.*;
import ea.mpp.library.data.*;

public class AdminController {
	private static MemberDAO memberDAO = new MemberDAO();

	/* Data Access Object for Books: To be edited later */

	BookInfoDAO dataAccess = new BookInfoDAO();

	private static AuthorDAO authorDAO = new AuthorDAO();

	public AdminController() {

	}

	/**
	 * get a list of all library members
	 * 
	 * @return
	 */
	public Map<Integer, LibraryMember> getLibraryMembers() {
		return memberDAO.getAll();
	}

	/**
	 * edit library member
	 * 
	 * @param member library member id
	 * @return LibraryMember edited copy of the library member details
	 */
	public LibraryMember editLibraryMember(LibraryMember member) {
		memberDAO.update(member.getLibraryMemberId(), member);

		return member;
	}

	/**
	 * add new library members
	 * 
	 * @param member a fresh copy of the library member
	 * @return
	 */
	public LibraryMember addLibraryMember(Person personDetails) {
		Integer libraryMemberId = MemberDAO.generateUniqueId();
		LibraryMember member = new LibraryMember(libraryMemberId, personDetails);

		memberDAO.add(libraryMemberId, member);

		return member;
	}
	
	
	/**
	 * adding book to the DAO
	 * 
	 */

	public boolean addBook(String title, String ISBN, int maxLeaseDays, List<Author> authors, List<BookCopy> copies) {

		
			if (!dataAccess.exists(ISBN)) {

				BookInfo bookInfo = new BookInfo(maxLeaseDays, title, ISBN, authors, copies);

				dataAccess.add(bookInfo);

				return true;
			
			}
			else {

				return false;
			}
		
	}

	/**
	 * getting all the books from the DAO
	 * 
	 * @return
	 */
	public List<BookInfo> getBooks() {

		 return dataAccess.getAll();
		

	}

	/***
	 * get a single book by it's title
	 * 
	 * @param title
	 * @return
	 */
	public BookInfo getBook(String title) {

		return dataAccess.get(title);
	}

	/***
	 * get number of books contained within the DAO
	 * @return
	 */
	public int getBooksCount() {

		return dataAccess.count();
	}

	/**
	 * editing an existing book in the store
	 * 
	 * @param book
	 * @return
	 */
	public boolean editBook(String title, String ISBN, int maxLeaseDays, List<Author> authors, List<BookCopy> copies) {

		 for (BookInfo bookInfo : dataAccess.getAll()) {
			
			 if(bookInfo.getISBN().equals(ISBN)) {
				 
				
				 BookInfo newBookInfo = new BookInfo(maxLeaseDays,title, ISBN, authors, copies);
				 dataAccess.update(newBookInfo);
				 
				 return true;
			 }
			
		}
		 
		 return false;

		
	}

	/**
	 * add author
	 * 
	 * @param author
	 */
	public void addAuthor(Author author) {

//			authorDAO=new AuthorDAO();
//			
//			authorDAO.add(author);

	}

	/**
	 * get authors from DAO
	 */
	public List<Author> getAuthors() {

		return authorDAO.getAuthors();
	}

	/**
	 * Get a single author from the DAO
	 * @param id
	 * @return
	 */
	public Author getAuthor(String id) {

		return authorDAO.getAuthor(id);
	}

}
