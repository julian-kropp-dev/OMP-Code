package Uebungsaufgaben.Uebung03.A1;

public class Banking {
	
	public static void main(String[] args) {
		Bank sbt = new Bank("Smaug Bank & Trust");
		sbt.setAccounts(new Account[1]);
		sbt.getAccounts()[0] = new Account("ER99123412341234123412");
		sbt.getAccounts()[0].setBalance(54100000000L);
		Customer thorin = new Customer();
		thorin.setAccounts(new Account[1]);
		thorin.getAccounts()[0] = sbt.getAccounts()[0];
		thorin.setName("Thorin");
		Adress home = new Adress();
		home.setStreet("Kingsroad 1");
		home.setPostCode("12345");
		home.setCity("Dunland");
		thorin.setHomeAdress(home);
		Adress work = new Adress();
		work.setStreet("Throneroom 1");
		work.setPostCode("54321");
		work.setCity("Erebor");
		thorin.setWorkAdress(work);
		sbt.getAccounts()[0].setHolders(new Customer[] { thorin });
	}

}
