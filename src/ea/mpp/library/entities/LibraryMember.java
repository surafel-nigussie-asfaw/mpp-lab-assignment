package ea.mpp.library.entities;

public class LibraryMember {
	private int libraryMemberId;
	private Person person;
	
	public LibraryMember(int libraryMemberId, Person person) {
		this.libraryMemberId = libraryMemberId;
		this.person = person;
	}

	public int getLibraryMemberId() {
		return libraryMemberId;
	}

	public void setLibraryMemberId(int libraryMemberId) {
		this.libraryMemberId = libraryMemberId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
