package ea.mpp.library.entities;

import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord {
	private LibraryMember libraryMember;
	private List<CheckOutEntry> checkOutEntries;
	private boolean hasError;
	private String errorMessage;
	
	public CheckOutRecord(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
		this.checkOutEntries = new ArrayList<>();
	}

	public LibraryMember getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}

	public List<CheckOutEntry> getCheckOutEntries() {
		return checkOutEntries;
	}

	public void setCheckOutEntries(List<CheckOutEntry> checkOutEntries) {
		this.checkOutEntries = checkOutEntries;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

}
