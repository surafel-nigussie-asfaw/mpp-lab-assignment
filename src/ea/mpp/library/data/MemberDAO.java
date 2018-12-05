package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.LibraryMember;

public class MemberDAO {
	private Map<Integer, LibraryMember> libraryMemberDataMap = new HashMap<Integer, LibraryMember>();
	
	public LibraryMember add(Integer key, LibraryMember value) {
		return libraryMemberDataMap.put(key, value);
	}

	public LibraryMember update(Integer key, LibraryMember value) {
		return libraryMemberDataMap.put(key, value);
	}

	public LibraryMember get(Integer key) {
		return libraryMemberDataMap.get(key);
	}

	public LibraryMember delete(Integer key) {
		return libraryMemberDataMap.remove(key);
	}
}
