package ea.mpp.library.data;

import java.util.HashMap;
import java.util.Map;

import ea.mpp.library.entities.CheckOutRecord;

public class CheckOutRecordDAO {
	private Map<Integer, CheckOutRecord> checkOutRecordDataMap = new HashMap<Integer, CheckOutRecord>();
	
	public CheckOutRecord add(Integer memberId, CheckOutRecord value) {
		return checkOutRecordDataMap.put(memberId, value);
	}

	public CheckOutRecord update(Integer memberId, CheckOutRecord value) {
		return checkOutRecordDataMap.put(memberId, value);
	}

	public CheckOutRecord get(Integer memberId) {
		return checkOutRecordDataMap.get(memberId);
	}

	public CheckOutRecord delete(Integer memberId) {
		return checkOutRecordDataMap.remove(memberId);
	}
}
