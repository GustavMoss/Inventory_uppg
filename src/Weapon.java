public abstract class Weapon extends Item implements Equippable {
    private int damage;
    private int durability;

    public Weapon(String name, double weight, int value, int damage, int durability) {
        super(name, weight, value);
        this.damage = damage;
        this.durability = durability;
    }

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return super.toString() + ("Damage: " + damage + "\nDurability: " + durability + "\n");
    }

    @Override
    public void equipItem() {
        System.out.println(getName() + " equipped.\nDurability: " + durability + "\nDamage: " + damage);
    }
}