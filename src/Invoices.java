import java.util.ArrayList;

public class Invoices {

    private Customer customer;
    private ArrayList<performance> performances = new ArrayList<performance>();
    public Invoices() {
    }

    public Invoices(String customerName, ArrayList<performance> performances) {
        this.customer = new Customer(customerName);
        this.performances = performances;
    }

    public Invoices(Customer customer, ArrayList<performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public void setPerformances(ArrayList<performance> performances) {
        this.performances = performances;
    }

    public void addPerformance(performance perf) {
        performances.add(perf);
    }

    public void removePerformance(performance perf) {
        performances.remove(perf);
    }

    public String getCustomer() {
        return customer.getName();
    }

    public ArrayList<performance> getPerformances() {
        return performances;
    }
}
