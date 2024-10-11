import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        //Version 1
        Inventory inventory = new Inventory();

        Weapon w1 = new MeleeWeapon("Broadsword", 20, 250, 15, 100, 10);
        Weapon w2 = new RangedWeapon("Longbow", 7.5, 125, 10, 80, 20);
        Weapon w3 = new MeleeWeapon("Axe", 25, 180, 18, 120, 8);
        Armor a1 = new Armor("MagicOgreArmor", 50, 100, 25);
        Consumable c1 = new OffensiveConsumable("Bomb", 10, 25, 5, 50);
        Consumable c2 = new DefensiveConsumable("HealingPotion", 1.5, 15, 0, 75);

        inventory.addItem(w1);
        inventory.addItem(w2);
        inventory.addItem(a1);
        inventory.addItem(c1);
        inventory.addItem(c2);

        //Version 2
        Shop shop = new Shop();
        Player p1 = new Player("Conan the Barbarian");

        shop.addShopItem(c1);
        shop.addShopItem(c2);
        shop.addShopItem(w2);
        shop.addShopItem(w3);

        p1.getInventory().addItem(a1);
        p1.getInventory().addItem(w1);
        p1.getInventory().addItem(c2);

        /* Jag bestämde mig för att lägga till fler switch / case (samt loopar) istället för att ändra om hela programmet.
        Det blev för mycket för min hjärna annars (hade även ont om tid).
        Skapade därför val mellan 2 versioner (version 1 är den jag redovisade).*/

        while (running) {
            System.out.println("\nChoose one of the following options:");
            System.out.println("1. Version 1 (G-nivå)");
            System.out.println("2. Version 2 (VG-nivå)");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // behövs för att det inte ska bugga av någon anledning (rensa buffern?)

            switch (mainChoice) {
                case 1:
                    boolean version1Running = true;
                    while (version1Running) {
                        System.out.println("\nVersion 1:");
                        System.out.println("1. Add an item (GM privilege)");
                        System.out.println("2. Delete an item");
                        System.out.println("3. Show all items");
                        System.out.println("4. Use / equip an item");
                        System.out.println("5. <---");
                        System.out.print("Your choice: ");
                        int version1Choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (version1Choice) {
                            case 1:
                                System.out.println("\nChoose which type of item you wish to add:");
                                System.out.println("1. Weapon");
                                System.out.println("2. Armor");
                                System.out.println("3. Consumable");
                                System.out.print("Your choice: ");
                                int itemType = scanner.nextInt();
                                scanner.nextLine();

                                switch (itemType) {
                                    case 1:
                                        System.out.println("\nChoose which type of weapon you wish to add:");
                                        System.out.println("1. Melee Weapon");
                                        System.out.println("2. Ranged Weapon");
                                        System.out.print("Your choice: ");
                                        int weaponType = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Name: ");
                                        String weaponName = scanner.nextLine();
                                        System.out.print("Weight (kg): ");
                                        double weaponWeight = scanner.nextDouble();
                                        System.out.print("Value (gold): ");
                                        int weaponValue = scanner.nextInt();
                                        System.out.print("Damage: ");
                                        int weaponDamage = scanner.nextInt();
                                        System.out.print("Durability: ");
                                        int weaponDurability = scanner.nextInt();

                                        switch (weaponType) {
                                            case 1:
                                                System.out.print("Sharpness (1-10): ");
                                                int weaponSharpness = scanner.nextInt();
                                                MeleeWeapon meleeWeapon = new MeleeWeapon(weaponName, weaponWeight, weaponValue, weaponDamage, weaponDurability, weaponSharpness);
                                                inventory.addItem(meleeWeapon);
                                                break;
                                            case 2:
                                                System.out.print("Range (m): ");
                                                int weaponRange = scanner.nextInt();
                                                RangedWeapon rangedWeapon = new RangedWeapon(weaponName, weaponWeight, weaponValue, weaponDamage, weaponDurability, weaponRange);
                                                inventory.addItem(rangedWeapon);
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Name: ");
                                        String armorName = scanner.nextLine();
                                        System.out.print("Weight (kg): ");
                                        double armorWeight = scanner.nextDouble();
                                        System.out.print("Value (gold): ");
                                        int armorValue = scanner.nextInt();
                                        System.out.print("Defense: ");
                                        int armorDefense = scanner.nextInt();
                                        Armor armor = new Armor(armorName, armorWeight, armorValue, armorDefense);
                                        inventory.addItem(armor);
                                        break;
                                    case 3:
                                        System.out.println("\nChoose which type of consumable you wish to add:");
                                        System.out.println("1. Offensive Consumable");
                                        System.out.println("2. Defensive Consumable");
                                        System.out.print("Your choice: ");
                                        int consumableType = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Name: ");
                                        String consumableName = scanner.nextLine();
                                        System.out.print("Weight: ");
                                        double consumableWeight = scanner.nextDouble();
                                        System.out.print("Value: ");
                                        int consumableValue = scanner.nextInt();
                                        System.out.print("Duration: ");
                                        int consumableDuration = scanner.nextInt();

                                        switch (consumableType) {
                                            case 1:
                                                System.out.print("Damage: ");
                                                int consumableDamage = scanner.nextInt();
                                                OffensiveConsumable offensiveConsumable = new OffensiveConsumable(consumableName, consumableWeight, consumableValue, consumableDuration, consumableDamage);
                                                inventory.addItem(offensiveConsumable);
                                                break;
                                            case 2:
                                                System.out.print("Health restored: ");
                                                int consumableRestore = scanner.nextInt();
                                                DefensiveConsumable defensiveConsumable = new DefensiveConsumable(consumableName, consumableWeight, consumableValue, consumableDuration, consumableRestore);
                                                inventory.addItem(defensiveConsumable);
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                        }
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                }
                                break;
                            case 2:
                                System.out.print("\nEnter the name of the item you wish to remove: ");
                                String itemName = scanner.nextLine();
                                Item itemToRemove = inventory.findItemByName(itemName);
                                if (itemToRemove != null) {
                                    inventory.removeItem(itemToRemove);
                                } else {
                                    System.out.println("Item not found.");
                                }
                                break;
                            case 3:
                                inventory.showItems();
                                break;
                            case 4:
                                System.out.print("\nName of the item you wish to use: ");
                                String itemNameToUse = scanner.nextLine();
                                Item itemToUse = null;
                                for (Item item : inventory.getItems()) {
                                    if (item.getName().equalsIgnoreCase(itemNameToUse)) {
                                        itemToUse = item;
                                        break;
                                    }
                                }
                                if (itemToUse != null) {
                                    if (itemToUse instanceof Equippable) {
                                        ((Equippable) itemToUse).equipItem();
                                    } else if (itemToUse instanceof Usable) {
                                        ((Usable) itemToUse).useItem();
                                    } else {
                                        System.out.println("Item cannot be used.");
                                    }
                                } else {
                                    System.out.println("Item not found");
                                }
                                break;
                            case 5:
                                version1Running = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;
                case 2:
                    boolean version2Running = true;
                    while (version2Running) {
                        System.out.println("\nVersion 2:");
                        System.out.println("1. Buy an item from the shop");
                        System.out.println("2. Sell an item to the shop");
                        System.out.println("3. Show the player's inventory");
                        System.out.println("4. Show the shop's inventory");
                        System.out.println("5. Show the player's current gold");
                        System.out.println("6. <---");
                        System.out.print("Your choice: ");
                        int version2Choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (version2Choice) {
                            case 1:
                                System.out.println("\nItems available in the shop:");
                                shop.getInventory().showItems();
                                System.out.print("Enter the name of the item you wish to buy: ");
                                String buyItemName = scanner.nextLine();
                                Item itemToBuy = shop.getInventory().findItemByName(buyItemName);
                                if (itemToBuy != null) {
                                    p1.buyItem(shop, itemToBuy);
                                } else {
                                    System.out.println("Item not found in the shop.");
                                }
                                break;
                            case 2:
                                System.out.println("\nItems available in the player's inventory:");
                                p1.getInventory().showItems();
                                System.out.print("Enter the name of the item you wish to sell: ");
                                String sellItemName = scanner.nextLine();
                                Item itemToSell = p1.getInventory().findItemByName(sellItemName);
                                if (itemToSell != null) {
                                    p1.sellItem(shop, itemToSell);
                                } else {
                                    System.out.println("Item not found in the player's inventory.");
                                }
                                break;
                            case 3:
                                System.out.println("\n-----Player's inventory-----");
                                p1.getInventory().showItems();
                                break;
                            case 4:
                                System.out.println("\n-----Shop's inventory-----");
                                shop.getInventory().showItems();
                                break;

                            case 5:
                                p1.showCoinPurse();
                                break;
                            case 6:
                                version2Running = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}