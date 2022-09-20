import java.util.HashMap;
import java.util.ArrayList;
public class Solution {
    public static String statement (Invoices invoice, HashMap<String, Player> playss) throws Exception {
        int totalAmount = 0;
        int volumCredits = 0;
        String result = "statement for " + invoice.getCustomer() + "\n";

        for (int i = 0; i < invoice.getPerformances().size(); i++) {
            performance perf = invoice.getPerformances().get(i);
            Player play = playss.get(perf.getPlayID());
            perf.setPlayer(play);
            int thisAmount = perf.calThisAmount();
            volumCredits += perf.calVolumCredits();
            result += perf.getBill(thisAmount);
            totalAmount += thisAmount;
        }
        result += billAll(totalAmount, volumCredits);
        return result;
    }

    public static String billAll(int totalAmount, int volumCredits) {
        String result = "";
        result += "Amount owed is " + totalAmount + "$\n";
        result += "You earn " + volumCredits + "$\n";
        return result;
    }


    public static void main(String []args) {
        ArrayList<performance> performances = new ArrayList<performance>();
        performances.add(new performance("hamlet", 55));
        performances.add(new performance("as-like", 35));
        performances.add(new performance("othello", 40));
        Invoices invoice = new Invoices ("BigCo", performances);

        HashMap<String, Player> plays = new HashMap<String, Player>();
        plays.put("hamlet", new Player("Hamlet", "tragedy"));
        plays.put("as-like", new Player("As You Like It", "comedy"));
        plays.put("othello", new Player("Othello", "tragedy"));
        try {
            System.out.println(statement(invoice, plays));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}