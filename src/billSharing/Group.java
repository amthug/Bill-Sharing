package billSharing;

import java.util.List;
import java.util.Map;

public class Group {
	String name;
	Map<User, Integer> users;

	List<Bill> listOfBills;

	public Map<User, Integer> getUsers() {
		return users;
	}

	public void setUsers(Map<User, Integer> users) {
		this.users = users;
	}

	public List<Bill> getListOfBills() {
		return listOfBills;
	}

	public void setListOfBills(List<Bill> listOfBills) {
		this.listOfBills = listOfBills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
