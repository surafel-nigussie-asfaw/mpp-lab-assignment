package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ea.mpp.library.entities.LibraryMember;

public class MemberDAO {
	private static Map<Integer, LibraryMember> libraryMemberDataMap = new HashMap<Integer, LibraryMember>();
	
	public LibraryMember add(Integer key, LibraryMember value) {
		return libraryMemberDataMap.put(key, value);
	}

	public LibraryMember update(Integer key, LibraryMember value) {
		return libraryMemberDataMap.put(key, value);
	}

	public LibraryMember get(Integer key) {
		return libraryMemberDataMap.get(key);
	}
	
	public Map<Integer, LibraryMember> getAll() {
		return libraryMemberDataMap;
	}

	public LibraryMember delete(Integer key) {
		return libraryMemberDataMap.remove(key);
	}
	
	/**
	 * generate unique random IDs for use as library member IDs
	 * @return
	 */
	public static Integer generateUniqueId() {
		Random rand = new Random();
		Integer id = (Integer)rand.nextInt(20000);

		while (libraryMemberDataMap.containsKey(id)) {
			id = (Integer)rand.nextInt(20000);
		};

		return id;
	}
}
