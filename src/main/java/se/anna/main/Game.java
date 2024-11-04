package se.anna.main;

import se.anna.main.fight.Burglar;
import se.anna.main.fight.FightMechanics;
import se.anna.main.fight.Resident;
import se.anna.main.rooms.*;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Rooms hallway;
    private final Rooms kitchen;
    private final Rooms bedroom;
    private final Rooms office;
    private Resident resident;
    private Burglar burglar;

    public Game() {
        resident = new Resident("the resident", 12, 3);
        burglar = new Burglar("the burglar", 12, 4);
        FightMechanics fightMechanics = new FightMechanics(scanner);
        hallway = new Hallway(scanner, fightMechanics, resident, burglar);
        kitchen = new Kitchen(scanner, resident);
        bedroom = new Bedroom(scanner);
        office = new Office(scanner, burglar, false);
    }

    public void start() {
        printIntroduction();
        basicMenu();
    }

    private void printIntroduction() {
        System.out.println("WELCOME TO HOME INVASION SIM 2024!");
        System.out.println("""
                
                You are sleeping on your couch.
                You are startled awake by a sound from the hallway.
                It appears to be an intruder.""");
    }

    public void basicMenu() {
        boolean running = true;
        while (running) {
            if (((Office) office).isCalledPolice()){
                running = false;
            } else {
                System.out.println("\nWhere are you going to go?\n*) Hallway\n*) Office\n*) Bedroom\n*) Kitchen\n*) Quit game");
                String userInput = scanner.nextLine().toLowerCase().trim();
                switch (userInput) {
                    case "hallway" -> travel("hallway", hallway);
                    case "office" -> travel("office", office);
                    case "bedroom" -> travel("bedroom", bedroom);
                    case "kitchen" -> travel("kitchen", kitchen);
                    case "quit game" -> {
                        System.out.print("\nThank you for playing!\nQuitting game");
                        scanner.close();
                        running = false;
                    }
                    default -> System.out.println("\nInvalid input");
                }
            }
        }
    }

    public void travel(String roomName, Rooms name) {
        System.out.println("\nGoing to the " + roomName + "...");
        name.description();
        name.menu();
    }
}
