package billSharing;

import java.util.List;

public class User {
	String name;
	int balance;
	List<Group> listOfGroups;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Group> getListOfGroups() {
		return listOfGroups;
	}

	public void setListOfGroups(List<Group> listOfGroups) {
		this.listOfGroups = listOfGroups;
	}
}
