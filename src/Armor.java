public class Armor extends Item implements Equippable {
    private int defense;

    public Armor(String name, double weight, int value, int defense) {
        super(name, weight, value);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public String toString() {
        return super.toString() + ("Defense: " + defense + "\n");
    }

    @Override
    public void equipItem() {
        System.out.println(getName() + " equipped. It has " + defense + " defense-points.");
    }
}