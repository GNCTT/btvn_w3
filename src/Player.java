public class Player {

    private String name;
    private String playID;
    private String type;

    public Player() {
    }

    public Player(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Player(String name, String playID, String type) {
        this.name = name;
        this.playID = playID;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPlayID() {
        return playID;
    }

    public void setPlayID(String playID) {
        this.playID = playID;
    }
}
