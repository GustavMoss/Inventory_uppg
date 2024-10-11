public class Player {
    private String name;
    private Inventory inventory;
    private int coinPurse;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.coinPurse = 1000;
    }

    public void buyItem(Shop shop, Item item) {
        if (shop.sellShopItem(item) && coinPurse >= item.getValue()) {
            inventory.addItem(item);
            coinPurse -= item.getValue();
            System.out.println(item.getName() + " bought. Removed " + item.getValue() + " gold from " + name + "'s coin purse");
        } else {
            System.out.println(name + " could not buy " + item.getName() + " from the shop.");
        }
    }

    public void sellItem(Shop shop, Item item) {
        if (inventory.getItems().contains(item)) {
            inventory.removeItem(item);
            shop.addShopItem(item);
            coinPurse += item.getValue();
            System.out.println(item.getName() + " sold. Added " + item.getValue() + " gold to " + name + "'s coin purse");
        } else {
            System.out.println(name + " does not have " + item.getName() + " in their possession.");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getCoinPurse() {
        return coinPurse;
    }

    public void showCoinPurse() {
        System.out.println("\n" + name + " currently has " + coinPurse + " gold in their possession.");
    }
}
