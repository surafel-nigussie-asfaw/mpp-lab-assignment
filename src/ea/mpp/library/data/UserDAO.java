package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.User;

public class UserDAO {
	private Map<Integer, User> userDataMap = new HashMap<Integer, User>();
	
	public User add(Integer key, User value) {
		return userDataMap.put(key, value);
	}

	public User update(Integer key, User value) {
		return userDataMap.put(key, value);
	}

	public User get(Integer key) {
		return userDataMap.get(key);
	}

	public User delete(Integer key) {
		return userDataMap.remove(key);
	}

}
