public class performance {

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

        int tragedymount = 1000 + 500 * (audience - 30);
        int comedymount = 10000 + 500 * (audience - 20);
        int addcomedymount = 300 * audience;

        switch(player.getType()) {
            case "tragedy":
                thisAmount = 40000;
                if (audience > 30) {
                    thisAmount += tragedymount;
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (audience > 20) {
                    thisAmount += comedymount;
                }
                thisAmount += addcomedymount;
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
