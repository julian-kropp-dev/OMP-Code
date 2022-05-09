package Uebungsaufgaben.Uebung03.A1;

public class BankUser {
    private String name;
    private HomeAdress homeAdress;
    private WorkAdress workAdress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomeAdress getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAddress(HomeAdress homeAdress) {
        this.homeAdress = homeAdress;
    }

    public WorkAdress getWorkAdress() {
        return workAdress;
    }

    public void setWorkAddress(WorkAdress workAdress) {
        this.workAdress = workAdress;
    }
}
