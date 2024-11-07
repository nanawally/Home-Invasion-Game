package se.anna.main.rooms;

import se.anna.main.fight.Burglar;
import se.anna.main.fight.FightMechanics;
import se.anna.main.fight.Resident;

import java.util.Scanner;

public class Hallway implements Rooms {
    private final Scanner scanner;
    private final FightMechanics fightMechanics;
    private boolean isBurglarDown;
    private final Resident resident;
    private final Burglar burglar;

    public Hallway(Scanner scanner, FightMechanics fightMechanics, Resident resident, Burglar burglar) {
        this.scanner = scanner;
        this.fightMechanics = fightMechanics;
        this.resident = resident;
        this.burglar = burglar;
        this.isBurglarDown = false;
    }

    @Override
    public void description() {
        if (isBurglarDown) {
            System.out.println("\nYou enter the hallway. The burglar is laying unconscious on the floor.");
        } else {
            System.out.println("\nYou enter the hallway. The burglar is there.");
        }
    }

    @Override
    public void menu() {
        boolean running = true;
        while (running) {
            if (isBurglarDown) {
                mostBasicMenu();
                String userInput = scanner.nextLine().toLowerCase().trim();
                switch (userInput) {
                    case "look around" -> System.out.println("\nYou look around the room. It does not contain " +
                            "anything useful.");
                    case "exit the room" -> {
                        System.out.println("\nYou go back to the living room.");
                        running = false;
                    }
                    default -> System.out.println("\nInvalid input");
                }
            } else {
                resident.setHealth(12);
                burglar.setHealth(12);
                System.out.println("\nDo you attack first?\n*) Yes\n*) No");
                String userInput = scanner.nextLine().toLowerCase().trim();
                switch (userInput) {
                    case "yes" -> {
                        fightMechanics.fightRound(resident, burglar);
                        isFightWon();
                        running = false;
                    }
                    case "no" -> {
                        fightMechanics.fightRound(burglar, resident);
                        isFightWon();
                        running = false;
                    }
                    default -> System.out.println("\nInvalid input");
                }
            }
        }
    }

    @Override
    public void mostBasicMenu() {
        System.out.println("\nWhat do you want to do?\n*) Look around\n*) Exit the room");
    }

    public void isFightWon() {
        if (burglar.isConscious() && !resident.isConscious()) {
            System.out.println("\nYou wake up in the living room. The burglar must have dragged you here.");
        } else if (!burglar.isConscious()) {
            System.out.println("\nThe burglar has been defeated! You return to the living room.");
            winFight();
        } else if (burglar.isConscious() && resident.isConscious()) {
            System.out.println("\nYou flee back to the living room.");
        }
    }

    public void winFight() {
        isBurglarDown = true;
    }
}
