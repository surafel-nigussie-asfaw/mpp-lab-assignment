package ea.mpp.library.entities;

import java.util.List;
import java.util.Random;

public class Author {
	private int id;
	private String credentials;
	private String shortBio;
	private Person person;
	private List<BookInfo> bookInfo;

	public Author(String credentials, String shortBio, Person person) {

		Random random = new Random();

		this.id = random.nextInt(1000);
		this.credentials = credentials;
		this.shortBio = shortBio;
		this.person = person;
	}

	public Author(String credentials, String shortBio, Person person, List<BookInfo> bookInfo) {
		Random random = new Random();

		this.id = random.nextInt(1000);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		
		return person.getFirstName()+" "+person.getLastName();
	}
}
