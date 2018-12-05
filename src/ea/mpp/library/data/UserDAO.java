package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.Person;
import ea.mpp.library.entities.User;

public class UserDAO {
	private Map<String, User> userDataMap = new HashMap<String, User>();
	
	public UserDAO() {
		userDataMap.put("a", new User("a","abc", new Person("Abebe", "Belay", "555-6666")));
		userDataMap.put("b", new User("b","abc", new Person("Belay", "Abebe", "555-9999")));
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
