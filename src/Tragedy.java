public class Tragedy extends Player{

    static final int TRAGEDYMOUNT = 40000;

    public Tragedy(String name, String playID, String type) {
        super(name, playID, type);
    }

    public Tragedy() {
        super();
    }

    public Tragedy(String name, String type) {
        super(name, type);
    }

    @Override
    public int calAmount(performance perf) {
        int thisAmount = TRAGEDYMOUNT;
        thisAmount += perf.getTragedyMountAdd();
        return thisAmount;
    }

    public int calVolumCredits(performance perf) {
        return perf.getMaxaudience();
    }
}
