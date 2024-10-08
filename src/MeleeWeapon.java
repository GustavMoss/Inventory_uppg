public class MeleeWeapon extends Weapon {

    private int sharpness;

    public MeleeWeapon(String name, double weight, int value, int damage, int durability, int sharpness) {
        super(name, weight, value, damage, durability);
        this.sharpness = sharpness;
    }

    public int getSharpness() {
        return sharpness;
    }

    @Override
    public String toString() {
        return super.toString() + ("Sharpness: " + sharpness + "\n");
    }
}
