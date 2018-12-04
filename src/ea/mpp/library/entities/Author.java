package ea.mpp.library.entities;

import java.util.List;

public class Author {
	private String credentials;
	private String shortBio;
	private Person person;
	private List<BookInfo> bookInfo;
	
	public Author(String credentials, String shortBio, Person person) {
		this.credentials = credentials;
		this.shortBio = shortBio;
		this.person = person;
	}
	
	public Author(String credentials, String shortBio, Person person, List<BookInfo> bookInfo) {
		this.credentials = credentials;
		this.shortBio = shortBio;
		this.person = person;
		this.bookInfo = bookInfo;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<BookInfo> getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(List<BookInfo> bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	
}
