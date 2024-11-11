package se.anna.main.rooms;

import se.anna.main.fight.Burglar;

import java.util.Scanner;

public class Office implements Rooms {
    private final Scanner scanner;
    private boolean seenPhone;
    private final Burglar burglar;
    private boolean calledPolice;

    public Office(Scanner scanner, Burglar burglar, boolean calledPolice) {
        this.scanner = scanner;
        this.burglar = burglar;
        this.seenPhone = false;
        this.calledPolice = calledPolice;
    }

    @Override
    public void description() {
        System.out.println("\nYou enter the office. It contains many things.");
    }

    @Override
    public void menu() {
        boolean running = true;
        while (running) {
            if (!seenPhone) {
                mostBasicMenu();
                String userInput = scanner.nextLine().toLowerCase().trim();
                switch (userInput) {
                    case "look around" -> {
                        System.out.println("\nYou look around the room. You see a phone on the desk.");
                        seenPhone = true;
                    }
                    case "exit the room" -> {
                        System.out.println("\nYou go back to the living room.");
                        running = false;
                    }
                    default -> System.out.println("Invalid input");
                }
            } else {
                System.out.println("\nWhat do you want to do?\n*) Look around\n*) Call the police\n*) Exit room");
                String userInput = scanner.nextLine().toLowerCase().trim();
                switch (userInput) {
                    case "look around" -> System.out.println("""
                            
                            You look around the room. The phone is still on the desk.
                            There is nothing else of use in here.""");
                    case "call the police" -> {
                        if (!burglar.isConscious()) {
                            callPolice();
                            running = false;
                        } else {
                            System.out.println("\nCalling the police would make too much noise. Knock out the burglar first.");
                        }
                    }
                    case "exit room" -> {
                        System.out.println("\nYou go back to the living room.");
                        running = false;
                    }
                    default -> System.out.println("Invalid input");
                }
            }
        }
    }

    @Override
    public void mostBasicMenu() {
        System.out.println("\nWhat do you want to do?\n*) Look around\n*) Exit the room");
    }

    public boolean callPolice() {
        calledPolice = true;
        System.out.println("\nYou call the police. You're safe!");
        return calledPolice;
    }

    public boolean isCalledPolice() {
        return calledPolice;
    }
}
