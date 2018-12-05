package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ea.mpp.library.entities.LibraryMember;

public class MemberDAO {
	private static Map<Integer, LibraryMember> libraryMemberDataMap = new HashMap<Integer, LibraryMember>();
	
	public LibraryMember add(LibraryMember value) {
		return libraryMemberDataMap.put(generateUniqueId(), value);
	}

	public LibraryMember update(Integer memberId, LibraryMember value) {
		return libraryMemberDataMap.put(memberId, value);
	}

	public LibraryMember get(Integer memberId) {
		return libraryMemberDataMap.get(memberId);
	}
	
	public Map<Integer, LibraryMember> getAll() {
		return libraryMemberDataMap;
	}

	public LibraryMember delete(Integer memberId) {
		return libraryMemberDataMap.remove(memberId);
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
