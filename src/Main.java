import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Inventory inventory = new Inventory();

        Weapon w1 = new MeleeWeapon("Broadsword", 20, 250, 15, 100, 10);
        Weapon w2 = new RangedWeapon("Longbow", 7.5, 125, 10, 80, 20);
        Armor a1 = new Armor("MagicOgreArmor", 50, 100, 25);
        Consumable c1 = new OffensiveConsumable("Bomb", 10, 25, 5, 50);
        Consumable c2 = new DefensiveConsumable("HealingPotion", 1.5, 15, 0, 75);

        inventory.addItem(w1);
        inventory.addItem(w2);
        inventory.addItem(a1);
        inventory.addItem(c1);
        inventory.addItem(c2);

        while (running) {
            System.out.println("\nChoose one of the following options:");
            System.out.println("1. Add an item (GM privilege)");
            System.out.println("2. Delete an item");
            System.out.println("3. Show all items");
            System.out.println("4. Use / equip an item");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //behövs för att det inte ska bugga av någon anledning

            switch (choice) {
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
                                    OffensiveConsumable offensiveconsumable = new OffensiveConsumable(consumableName, consumableWeight, consumableValue, consumableDuration, consumableDamage);
                                    inventory.addItem(offensiveconsumable);
                                    break;
                                case 2:
                                    System.out.print("Health restored: ");
                                    int consumableRestore = scanner.nextInt();
                                    DefensiveConsumable defensiveconsumable = new DefensiveConsumable(consumableName, consumableWeight, consumableValue, consumableDuration, consumableRestore);
                                    inventory.addItem(defensiveconsumable);
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
                    System.out.print("\nName of the item you wish to remove: ");
                    String itemName = scanner.nextLine();
                    Item itemToRemove = null;
                    for (Item item : inventory.getItems()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToRemove = item;
                            break;
                        }
                    }
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
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}