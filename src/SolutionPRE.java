import java.util.HashMap;
import java.util.ArrayList;
public class SolutionPRE {

    public static class player{
        public String name;
        public String type;

        public player() {

        }

        public player(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    public static class invoices{
        public String customer;
        public ArrayList<performance> performances = new ArrayList<>();

        public invoices(String customer, ArrayList<performance> performances) {
            this.customer = customer;
            this.performances = performances;
        }
    }

    public static class performance{
        public String playID;
        public int audience;

        public performance(String playID, int audience) {
            this.playID = playID;
            this.audience = audience;
        }
    }


    public static String statement (invoices invoice, HashMap<String, player> playss) throws Exception {
        int totalAmount = 0;
        int volumCredits = 0;
        String result = "statement for " + invoice.customer + "\n";

        int format = 2;
        for (int i = 0; i < invoice.performances.size(); i++) {
            performance perf = invoice.performances.get(i);
            player play = new player();
            play = playss.get(perf.playID);
            int thisAmount = 0;
            switch(play.type) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.audience > 30) {
                        thisAmount += 10000 + 500 * (perf.audience - 20);
                    }
                    thisAmount += 300 * perf.audience;
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.audience > 20) {
                        thisAmount += 1000 + 500 * (perf.audience - 20);
                    }
                    thisAmount += 300 * perf.audience;
                    break;
                default:
                    throw new Exception("Exception message");
            }

            volumCredits += Math.max(perf.audience - 30, 0);

            if ("comedy".equals(play.type)) {
                volumCredits += Math.floor(perf.audience / 5);
            }
            result += play.name + " " + thisAmount + "$ " + perf.audience + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "you earn " + volumCredits + "\n";
        return result;
    }

    public static void main(String []args) {
        ArrayList<performance> performances = new ArrayList<performance>();
        performances.add(new performance("hamlet", 55));
        performances.add(new performance("as-like", 35));
        performances.add(new performance("othello", 40));
        invoices invoice = new invoices ("BigCo", performances);

        HashMap<String, player> plays = new HashMap<String, player>();
        plays.put("hamlet", new player("Hamlet", "tragedy"));
        plays.put("as-like", new player("As You Like It", "comedy"));
        plays.put("othello", new player("Othello", "tragedy"));
        try {
            System.out.println(statement(invoice, plays));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
