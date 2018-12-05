package ea.mpp.library.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ea.mpp.library.entities.Person;
import ea.mpp.library.entities.Role;
import ea.mpp.library.entities.User;

public class UserDAO {
	private Map<String, User> userDataMap = new HashMap<String, User>();
	
	public UserDAO() {
		//only admins roles
		List<Role> admin = new ArrayList(); 
		admin.add(new Role(Constants.Roles.ADMINSTRATOR.name()));
		
		//only librarian roles
		List<Role> librarian = new ArrayList(); 
		librarian.add(new Role(Constants.Roles.LIBRARIAN.name()));
		
		//both roles
		List<Role> both_admin_librarian = new ArrayList(); 
		both_admin_librarian.add(new Role(Constants.Roles.ADMINSTRATOR.name()));
		both_admin_librarian.add(new Role(Constants.Roles.LIBRARIAN.name()));
		
		userDataMap.put("librarian", new User("librarian","abc", new Person("Abebe", "Belay", "555-6666"), librarian));
		userDataMap.put("admin", new User("admin","abc", new Person("Steve", "Belete", "555-9999"), admin));
		userDataMap.put("both", new User("both","abc", new Person("Hiwot", "Surafel", "555-9999"), both_admin_librarian));
	}

	public User add(String username, User value) {
		return userDataMap.put(username, value);
	}

	public User update(String username, User value) {
		return userDataMap.put(username, value);
	}

	public User get(String username) {
		return userDataMap.get(username);
	}

	public User delete(String username) {
		return userDataMap.remove(username);
	}

}
