public class Shop {
    private Inventory inventory;

    public Shop() {
        this.inventory = new Inventory();
    }

    public void addShopItem(Item item) {
        inventory.addItem(item);
    }

    public boolean sellShopItem(Item item) {
        if (inventory.getItems().contains(item)) {
            inventory.removeItem(item);
            return true;
        }
        return false;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
