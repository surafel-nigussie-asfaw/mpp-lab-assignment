package ea.mpp.library.entities;

import java.util.List;

public class User {
	private String userName;
	private String password;
	private Person person;
	private List<Role> roles;
	
	public User(String userName, String password, Person person, List<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.person = person;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Person getPerson() {
		return person;
	}
	
}
