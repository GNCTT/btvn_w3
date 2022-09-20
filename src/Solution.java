import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

        Object obj;
        try {
            obj = new JSONParser().parse(new FileReader("C:\\Users\\nghia\\Desktop\\btvn_w3-master\\btvn_w3-master\\src\\plays.json"));
            JSONObject jsonObject = (JSONObject) obj;

            // đọc hamlet
            String a = null,b=null; int i=1;
            Map hamlet = ((Map) jsonObject.get("hamlet"));
            // đọc hamlet Map
            Iterator<Map.Entry> itr1 = hamlet.entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                if(i==1) {a = (String) pair.getValue();i++;}
                if(i==2) {b = (String) pair.getValue();i=1;}
                plays.put("hamlet", new Player(a, b));
                a=null;b=null;
            }

            // đọc aslike
            Map Aslike = ((Map) jsonObject.get("as-like"));
            // đọc hamlet Map
            Iterator<Map.Entry> itr2 = Aslike.entrySet().iterator();
            while (itr2.hasNext()) {
                Map.Entry pair = itr2.next();
                if(i==1) {a = (String) pair.getValue();i++;}
                if(i==2) {b = (String) pair.getValue();i=1;}
                plays.put("as-like", new Player(a, b));
                a=null;b=null;
            }

            // đọc othello
            Map othello = ((Map) jsonObject.get("othello"));
            // đọc hamlet Map
            Iterator<Map.Entry> itr3 = othello.entrySet().iterator();
            while (itr3.hasNext()) {
                Map.Entry pair = itr3.next();
                if(i==1) {a = (String) pair.getValue();i++;}
                if(i==2) {b = (String) pair.getValue();i=1;}
                plays.put("othello", new Player(a, b));
                a=null;b=null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


       
        try {
            System.out.println(statement(invoice, plays));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
