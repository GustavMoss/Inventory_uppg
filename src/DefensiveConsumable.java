public class DefensiveConsumable extends Consumable {
    private int hpRestore;

    public DefensiveConsumable(String name, double weight, int value, int duration, int hpRestore) {
        super(name,weight,value,duration);
        this.hpRestore = hpRestore;
    }

    public int getDamage() {
        return hpRestore;
    }

    @Override
    public String toString() {
        return super.toString() + ("Restores: " + hpRestore + " health points\n");
    }
}
