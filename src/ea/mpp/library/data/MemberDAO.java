package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ea.mpp.library.entities.LibraryMember;
import ea.mpp.library.entities.Person;

public class MemberDAO {
	private static Map<Integer, LibraryMember> libraryMemberDataMap = new HashMap<Integer, LibraryMember>();
	
	public MemberDAO() {
		libraryMemberDataMap.put(1, new LibraryMember(1, new Person("MemberF1", "MemberL1", "1209933")));
		libraryMemberDataMap.put(2, new LibraryMember(2, new Person("MemberF2", "MemberL2", "1209933")));
		libraryMemberDataMap.put(3, new LibraryMember(3, new Person("MemberF3", "MemberL3", "1209933")));
	}
	
	public LibraryMember add(int libraryMemberId, LibraryMember value) {
		return libraryMemberDataMap.put(libraryMemberId, value);
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
