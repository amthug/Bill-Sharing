package billSharing;

import java.util.Map;

public class Bill {
	Map<User, Integer> paidMap;

	public Map<User, Integer> getPaidMap() {
		return paidMap;
	}

	public void setPaidMap(Map<User, Integer> paidMap) {
		this.paidMap = paidMap;
	}
}
