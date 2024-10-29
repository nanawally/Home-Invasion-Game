package se.anna.main.rooms;

import java.util.Scanner;

public class Bedroom implements Rooms {
    private final Scanner scanner;

    public Bedroom(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void description() {
        System.out.println("\nYou enter the bedroom. It has a bed and is a room.");
    }

    @Override
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n*) Look around\n*) Exit the room");
            String userInput = scanner.nextLine().toLowerCase().trim();
            switch (userInput) {
                case "look around" -> System.out.println("\nYou look around the room. It does not contain " +
                        "anything useful.");
                case "exit the room" -> {
                    System.out.println("\nYou go back to the living room.");
                    running = false;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
