public abstract class Consumable extends Item implements Usable {
    private int duration;

    public Consumable(String name, double weight, int value, int duration) {
        super(name, weight, value);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return super.toString() + ("Duration: " + duration + " seconds\n");
    }

    @Override
    public void useItem() {
        System.out.println(getName() + " used. It lasts for " + duration + " seconds");
    }
}