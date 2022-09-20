public class performance {

    static final int TRAGEDYMOUNT = 40000;
    static final int COMEDYMOUNT = 30000;

    private Player player;
    private int audience;

    public performance() {
    }

    public performance(String playID, int audience) {
        player = new Player();
        player.setPlayID(playID);
        this.audience = audience;
    }

    public performance(Player player, int audience) {
        this.player = player;
        this.audience = audience;
    }

    public String getPlayID() {
        return player.getPlayID();
    }

    public int getAudience() {
        return audience;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int calThisAmount() throws Exception{
        int thisAmount = 0;

        int tragedymountadd = 1000 + 500 * (audience - 30);
        int comedymountadd = 10000 + 500 * (audience - 20);
        int addcomedymountadd = 300 * audience;

        switch(player.getType()) {
            case "tragedy":
                thisAmount = TRAGEDYMOUNT;
                if (audience > 30) {
                    thisAmount += tragedymountadd;
                }
                break;
            case "comedy":
                thisAmount = COMEDYMOUNT;
                if (audience > 20) {
                    thisAmount += comedymountadd;
                }
                thisAmount += addcomedymountadd;
                break;
            default:
                throw new Exception("Exception message");
        }
        return thisAmount;
    }

    public int calVolumCredits() {
        int result = Math.max(audience - 30, 0);
        if ("comedy".equals(player.getType())) {
            result += Math.floor(audience / 5);
        }
        return result;
    }

    public String getBill(int thisAmount) {
        return player.getName() + " " + thisAmount + "$ " + audience + "\n";
    }
}
