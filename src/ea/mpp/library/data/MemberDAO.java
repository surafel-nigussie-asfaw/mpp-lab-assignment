package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.LibraryMember;

public class MemberDAO {
	private Map<Integer, LibraryMember> libraryMemberDataMap = new HashMap<Integer, LibraryMember>();
	
	public LibraryMember add(LibraryMember value) {
		return libraryMemberDataMap.put(generateUniqueId(), value);
	}

	public LibraryMember update(Integer memberId, LibraryMember value) {
		return libraryMemberDataMap.put(memberId, value);
	}

	public LibraryMember get(Integer memberId) {
		return libraryMemberDataMap.get(memberId);
	}

	public LibraryMember delete(Integer memberId) {
		return libraryMemberDataMap.remove(memberId);
	}
}
