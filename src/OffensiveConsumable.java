public class OffensiveConsumable extends Consumable {
    private int damage;

    public OffensiveConsumable(String name, double weight, int value, int duration, int damage) {
        super(name,weight,value,duration);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + ("Damage: " + damage + "\n");
    }
}
