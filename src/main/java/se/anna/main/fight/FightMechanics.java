package se.anna.main.fight;

import java.util.Scanner;

public class FightMechanics {
    private final Scanner scanner;
    private static boolean running = true;

    public FightMechanics(Scanner scanner) {
        this.scanner = scanner;
    }

    public void fightRound(Entity attacker, Entity defender) {
        while (running && attacker.isConscious() && defender.isConscious()) {
            executeAttack(attacker, defender);
            if (defender.isConscious()) {
                executeAttack(defender, attacker);
            }
            if (attacker.isConscious() && defender.isConscious()) {
                String userInput;
                do {
                    System.out.println("\nDo you wish to continue fighting?");
                    userInput = scanner.nextLine().toLowerCase().trim();
                    if (userInput.equals("no")) {
                        running = false;
                    } else if (!userInput.equals("yes")) {
                        System.out.println("\nInvalid input");
                    }
                } while (!userInput.equals("yes") && running);
            }
        }
        running = true;
    }

    static void executeAttack(Entity attacker, Entity defender) {
        attacker.attack(defender);
        System.out.println("\n" + attacker.getRole() + " has attacked " + defender.getRole() + " and done " +
                attacker.getDamage()+" health points worth of damage.");
        if (defender.isConscious()) {
            System.out.println("\n" + defender.getRole() + " has " + defender.getHealth() + " health points left.");
        } else {
            System.out.println("\n" + defender.getRole() + " has gotten knocked unconscious.");
        }
    }
}
