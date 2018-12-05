package ea.mpp.library.controllers;

import java.util.Date;

import ea.mpp.library.data.BookInfoDAO;
import ea.mpp.library.data.CheckOutRecordDAO;
import ea.mpp.library.data.MemberDAO;
import ea.mpp.library.data.UserDAO;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.CheckOutEntry;
import ea.mpp.library.entities.CheckOutRecord;
import ea.mpp.library.entities.LibraryMember;
import ea.mpp.library.entities.User;

public class UserController {
	private static UserController instance = new UserController();

	private UserDAO userDAO = new UserDAO();
	
	private UserController() {}
	
	public static UserController getInstance() {return instance;}
	
	public User login(String username, String password) {
		User user = userDAO.get(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
