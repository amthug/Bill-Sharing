package billSharing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BillSharing {
	public static void main(String[] args) {
		User ashish = createUser("Ashish");
		User devbrat = createUser("Devbrat");
		User anmol = createUser("Anmol");
		User abhishek = createUser("Abhishek");
		User rohit = createUser("Rohit");
		List<User> listOfAllGlobalUsers = new LinkedList<>();
		listOfAllGlobalUsers.add(ashish);
		listOfAllGlobalUsers.add(abhishek);
		listOfAllGlobalUsers.add(devbrat);
		listOfAllGlobalUsers.add(anmol);
		listOfAllGlobalUsers.add(rohit);

		List<User> listOfUsers = new LinkedList<>();

		listOfUsers.add(ashish);
		listOfUsers.add(devbrat);
		listOfUsers.add(anmol);
		listOfUsers.add(abhishek);
		Group flipkartParty = createGroup("FLIPKART_PARTY", listOfUsers);
		listOfUsers.clear();

		listOfUsers.add(ashish);
		listOfUsers.add(rohit);
		Group schoolFriends = createGroup("SCHOOL_FRIENDS", listOfUsers);

		Map<User, Integer> paidMap = new HashMap<>();
		paidMap.put(ashish, 40);
		paidMap.put(devbrat, 160);
		Bill bill1 = new Bill();
		bill1.setPaidMap(paidMap);
		addTransaction(flipkartParty, paidMap, bill1);

		Map<User, Integer> paidMap1 = new HashMap<>();
		paidMap1.put(ashish, 30);
		paidMap1.put(abhishek, 60);
		paidMap1.put(anmol, 110);
		Bill bill2 = new Bill();
		bill2.setPaidMap(paidMap1);
		addTransaction(flipkartParty, paidMap1, bill2);

		Map<User, Integer> paidMap2 = new HashMap<>();
		paidMap2.put(ashish, 100);
		paidMap2.put(rohit, 60);
		Bill bill3 = new Bill();
		bill3.setPaidMap(paidMap2);
		addTransaction(schoolFriends, paidMap2, bill3);

		updateOverall(listOfAllGlobalUsers);

		System.out.println("Ashish's balance in flipkart party:");
		System.out.println(balanceOfUserInGroup(ashish, flipkartParty));

		System.out.println("Balance of all users in group flipkartParty:");
		balanceOfUsersInGroup(flipkartParty);

		System.out.println("Ashish's overall balance:");
		System.out.println(balanceOfUserOverall(ashish));
		System.out.println("Balance of all users in group schoolFriends:");
		balanceOfUsersInGroup(schoolFriends);
	}

	public static void updateOverall(List<User> listOfUsers) {
		for (User u : listOfUsers) {
			for (Group gp : u.getListOfGroups()) {
				u.setBalance(u.getBalance() + gp.getUsers().get(u));
			}
		}
	}

	public static void balanceOfUsersInGroup(Group flipkartParty) {
		for (Map.Entry<User, Integer> entry : flipkartParty.getUsers().entrySet()) {
			System.out.println(entry.getKey().getName() + " " + ":" + " " + entry.getValue());
		}
	}

	public static String balanceOfUserOverall(User user) {
		return user.getName() + " " + ":" + " " + user.getBalance();
	}

	public static String balanceOfUserInGroup(User user, Group group) {
		return user.getName() + " " + ":" + " " + group.getUsers().get(user);
	}

	public static void addTransaction(Group flipkartParty, Map<User, Integer> paidMap, Bill bill) {
		flipkartParty.getListOfBills().add(bill);
		int paidSum = 0;
		for (Map.Entry<User, Integer> entry : paidMap.entrySet()) {
			paidSum += entry.getValue();
		}
		int share = paidSum / flipkartParty.getUsers().size();
		for (Map.Entry<User, Integer> entry : flipkartParty.getUsers().entrySet()) {
			flipkartParty.getUsers().put(entry.getKey(),
					entry.getValue() + paidMap.getOrDefault(entry.getKey(), 0) - share);
		}
	}

	public static Group createGroup(String name, List<User> listOfUsers) {
		Group group1 = new Group();
		group1.setName(name);
		group1.setUsers(addUsers(listOfUsers, group1));
		group1.setListOfBills(new LinkedList<>());
		return group1;
	}

	public static Map<User, Integer> addUsers(List<User> listOfUsers, Group group1) {
		Map<User, Integer> map = new HashMap<>();
		for (User u : listOfUsers) {
			u.getListOfGroups().add(group1);
			map.put(u, 0);
		}
		return map;
	}

	public static User createUser(String name) {
		User u = new User();
		u.setName(name);
		u.setBalance(0);
		u.setListOfGroups(new LinkedList<>());
		return u;
	}

}
