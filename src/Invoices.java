import java.util.ArrayList;

public class Invoices {

    private String customer;
    private ArrayList<performance> performances = new ArrayList<performance>();
    public Invoices() {
    }

    public Invoices(String customer, ArrayList<performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String getCustomer() {
        return customer;
    }

    public ArrayList<performance> getPerformances() {
        return performances;
    }
}
