package ea.mpp.library.entities;

import java.util.List;

public class CheckOutRecord {
	private LibraryMember libraryMember;
	private List<CheckOutEntries> checkOutEntries;
	
	public CheckOutRecord(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}

	public LibraryMember getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}

	public List<CheckOutEntries> getCheckOutEntries() {
		return checkOutEntries;
	}

	public void setCheckOutEntries(List<CheckOutEntries> checkOutEntries) {
		this.checkOutEntries = checkOutEntries;
	}
	
	
}
