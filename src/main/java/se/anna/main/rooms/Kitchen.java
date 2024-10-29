package se.anna.main.rooms;

import se.anna.main.fight.Resident;

import java.util.Scanner;

public class Kitchen implements Rooms {
    private final Scanner scanner;
    private boolean takenFryingpan;
    private Resident resident;

    public Kitchen(Scanner scanner, Resident resident) {
        this.scanner = scanner;
        this.resident = resident;
        this.takenFryingpan = false;
    }

    @Override
    public void description() {
        System.out.println("\nYou enter the kitchen. There must be plenty of weapons in here.");
    }

    @Override
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n*) Look around\n*) Exit the room");
            String userInput = scanner.nextLine().toLowerCase().trim();
            switch (userInput) {
                case "look around" -> {
                    if (takenFryingpan) {
                        System.out.println("\nYou look around the room. There is nothing else useful here.");
                    } else {
                        System.out.println("\nYou look around the room. You see a frying pan " +
                                "on the stove.");
                        takeFryingPan();
                    }
                }
                case "exit the room" -> {
                    System.out.println("\nYou go back to the living room.");
                    running = false;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    public void takeFryingPan() {
        System.out.println("\nTake frying pan?");
        String userInput = scanner.nextLine().toLowerCase().trim();
        if (userInput.equals("yes")) {
            System.out.println("\nYou take the frying pan.");
            setTakenFryingPan();
        } else if (userInput.equals("no")) {
            System.out.println("\nYou do not take the frying pan.");
        } else {
            System.out.println("Invalid input.");
        }
    }

    public void setTakenFryingPan() {
        resident.setDamage(resident.getDamage()+3);
        takenFryingpan = true;
    }
}