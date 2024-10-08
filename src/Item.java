public abstract class Item {
    private String name;
    private double weight;
    private int value;

    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return ("---" + name + "---\nWeight: " + weight + " kg\nValue: " + value + " gold\n");
    }
}