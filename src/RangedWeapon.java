public class RangedWeapon extends Weapon {

    private int range;

    public RangedWeapon(String name, double weight, int value, int damage, int durability, int range) {
        super(name, weight, value, damage, durability);
        this.range = range;
    }

    @Override
    public String toString() {
        return super.toString() + ("Range: " + range + " m\n");
    }
}
