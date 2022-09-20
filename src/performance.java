public class performance {

    static final int AUDIENCETRAGEDY = 30;
    static final int AUDIENCECOMEDY = 20;

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

    public int getTragedyMountAdd() {
        if (audience > AUDIENCETRAGEDY) {
            return 1000 + 500 * (audience - AUDIENCETRAGEDY);
        }
        return 0;
    }

    public int getComedyMountAdd() {
        int result = 0;
        if (audience > AUDIENCECOMEDY) {
            result += 10000 + 500 * (audience - 20);
        }
        result += getAddComedyMountAdd();
        return result;
    }

    public int getAddComedyMountAdd() {
        return 300 * audience;
    }

    public int getMaxaudience() {
        return Math.max(audience - AUDIENCETRAGEDY, 0);
    }

    public int getFloorAudience() {
        return (int) Math.floor(audience / 5);
    }

    public String getBill(int thisAmount) {
        return player.getName() + " " + thisAmount + "$ " + audience + "\n";
    }
}
