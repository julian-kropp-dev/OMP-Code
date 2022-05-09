package Uebungsaufgaben.Uebung03.A1;

public class WorkAdress extends Adress {
    private String companyName;
    WorkAdress(String companyName){
        super();
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


}
