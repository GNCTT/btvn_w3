public class Comedy extends Player{

    static final int COMEDYMOUNT = 30000;

    public Comedy(String name, String playID, String type) {
        super(name, playID, type);
    }

    public Comedy(String name, String type) {
        super(name, type);
    }

    public Comedy() {
        super();
    }
    @Override
    public int calAmount(performance perf) {
        int thisAmount = COMEDYMOUNT;
        thisAmount += perf.getComedyMountAdd();
        return thisAmount;
    }

    public int calVolumCredits(performance perf) {
        return perf.getFloorAudience();
    }

}
