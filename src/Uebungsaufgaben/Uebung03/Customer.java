package Uebungsaufgaben.Uebung03;

public class Customer {
	
	private String name;
	private Account[] accounts;
	private Adress homeAdress;
	private Adress workAdress;
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public Account[] getAccounts() { return accounts; }
	
	public void setAccounts(Account[] accounts) { this.accounts = accounts; }
	
	public Adress getHomeAdress() { return homeAdress; }
	
	public void setHomeAdress(Adress homeAdress) { this.homeAdress = homeAdress; }
	
	public Adress getWorkAdress() { return workAdress; }
	
	public void setWorkAdress(Adress workAdress) { this.workAdress = workAdress; }

}
