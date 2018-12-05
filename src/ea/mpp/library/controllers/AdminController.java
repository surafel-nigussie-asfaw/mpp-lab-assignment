package ea.mpp.library.controllers;

import java.util.Map;
import ea.mpp.library.entities.*;
import ea.mpp.library.data.*;

public class AdminController {
	private static MemberDAO memberDAO = new MemberDAO();
	
	public AdminController() {
		
	}
	
	/**
	 * get a list of all library members
	 * @return
	 */
	public Map<Integer, LibraryMember> getLibraryMembers(){
		return memberDAO.getAll();
	}
	
	/**
	 * edit library member 
	 * @param member library member id
	 * @return LibraryMember edited copy of the library member details
	 */
	public LibraryMember editLibraryMember(LibraryMember member) {
		memberDAO.update(member.getLibraryMemberId(), member);
		
		return member;
	}
	
	/**
	 * add new library members
	 * @param member a fresh copy of the library member
	 * @return
	 */
	public LibraryMember addLibraryMember(Person personDetails) {
		Integer libraryMemberId = memberDAO.generateUniqueId();
		LibraryMember member = new LibraryMember(libraryMemberId, personDetails);
		
		memberDAO.add(libraryMemberId, member);
		
		return member;
	}
}
