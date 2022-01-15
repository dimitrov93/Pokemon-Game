package com.company;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    static byte userOption, selectedPokemon;

    public static void main(String[] args) {

        Battle battle = new Battle();
        Winner winner = new Winner();
        YourTeam yourTeam = new YourTeam();
        EnemyTeam enemyTeam = new EnemyTeam();
        YourAttacks yourAttacks = new YourAttacks();
        EnemyAttacks enemyAttacks = new EnemyAttacks();

        printPokemonChars();
        menuOption();
        switchMenuOptions(battle, winner, yourTeam, enemyTeam, yourAttacks, enemyAttacks);
    }

    private static void printPokemonChars() {
        try {
            printPokemonText();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void menuOption() {
        System.out.println("1. Play a game!");
        System.out.println("2. Check logs");
        System.out.println("3. Exit");
        System.out.print("Please, select an option from the menu: " + "\n");
    }

    public static void switchMenuOptions(Battle battle, Winner winner, YourTeam yourTeam
            , EnemyTeam enemyTeam, YourAttacks yourAttacks, EnemyAttacks enemyAttacks) {
        Scanner scanner = new Scanner(System.in);

        userOption(scanner);


        switch (userOption) {
            case 1 -> {
                yourTeam.trainerName();
                System.out.println(yourTeam.getTrainerName() + " - Welcome to the tournament!");
                System.out.println("Select your pokemons:" + selectPokemons());
                while (yourTeam.myPokemon.size() < 3) {
                    try {
                        selectedPokemon = scanner.nextByte();
                        yourTeam.choosePokemonInBattle(selectedPokemon);
                    } catch (Exception e) {
                        System.out.println("Incorrect input!");
                    }

                }
                yourTeam.printMyPokemons();
                System.out.println();
                enemyTeam.randomEnemyPokemonInBattle();
                enemyTeam.printEnemyPokemon();
                System.out.println();
                battle.playTheGame(yourTeam, enemyTeam, yourAttacks, enemyAttacks);
            }
            case 2 -> winner.winnerReader();
            case 3 -> System.out.println("Have a great day!");
            default -> {
                System.out.println("Incorrect input!");
                switchMenuOptions(battle, winner, yourTeam, enemyTeam, yourAttacks, enemyAttacks);
            }
        }
    }

    private static void userOption(Scanner scanner) {
        try {
            if (scanner.hasNextByte()) {
                userOption = scanner.nextByte();
            }
        } catch (Exception e) {
            System.out.println("Something is wrong with the input!");
        }
    }

    public static void printPokemonText() throws FileNotFoundException {
        File pokemonFile = new File("Pokemon.txt");
        Scanner scan = new Scanner(pokemonFile);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }

    public static String selectPokemons() {

        return " 1.Pikachu 2.Squirtle 3.Charizard 4.Crobat 5.Fearow";
    }
}

