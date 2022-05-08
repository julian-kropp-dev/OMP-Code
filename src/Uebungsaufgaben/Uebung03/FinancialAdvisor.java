package Uebungsaufgaben.Uebung03;

public class FinancialAdvisor extends BankUser {
    private Customer[] customer;

    public Customer[] getCustomer() {
        return customer;
    }

    public void setCustomer(Customer[] customer) {
        this.customer = customer;
    }
}
