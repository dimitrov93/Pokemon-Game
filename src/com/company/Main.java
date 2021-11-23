package com.company;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static String trainerName;
    static int crystals;

    public static void main(String[] args) {
        MyPokemon ourPokemon = new MyPokemon();
        EnemyPokemon enemyPokemon = new EnemyPokemon();

        printPokemonChars();
        menuOption();
        switchMenuOptions(ourPokemon,enemyPokemon);

    }

    private static void printPokemonChars() {
        try {
            printPokemonText();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void playTheGame(MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        Scanner scanner = new Scanner(System.in);
        trainerName();
        System.out.println(trainerName + " - Welcome to the tournament!");

        System.out.println("Select your pokemons:" + selectPokemons());
        ourPokemon.choosePokemonInBattle();
        ourPokemon.printMyPokemons();

        enemyPokemon.randomEnemyPokemonInBattle();
        enemyPokemon.printEnemyPokemon();
        printLine();
        int roundCounter = 1;
        System.out.println("The battle begins");
        System.out.println("Choose pokemon to play with: ");
        ourPokemon.youChooseOnePokemon();
        System.out.print("Enemy player choose: ");
        enemyPokemon.enemyChoosePokemon();
        crystals = 0;
        loop: while(enemyPokemon.enemyPokemonList.size()!=0 || ourPokemon.myPokemon.size()!=0 || roundCounter <= 5){
             int healthBar = ourPokemon.yourChoose.get(0).HP;

            loop2: while (true) {  // while 2 start
                printLine();
                roundCounter(roundCounter);
                printLine();
                if (roundCounter % 2 != 0) {
                    System.out.println("Your pokemon HP is: " + ourPokemon.yourChoose.get(0).HP);
                    System.out.println(enemyPokemon.enemyChoose.get(0).name + " is attacking with: " +  enemyPokemon.enemyChoose.get(0).AP + " Attack power");
                    System.out.println("Your pokemon HP now is: " + (ourPokemon.yourChoose.get(0).HP - enemyPokemon.enemyChoose.get(0).AP) );
                    ourPokemon.yourChoose.get(0).HP -= enemyPokemon.enemyChoose.get(0).AP;
                } else {
                    System.out.println(trainerName + " - your turn! Please, select an ability to strike with: ");
                    System.out.println("1.Low ability 2.Medium ability 3.High ability 4.No ability");
                    int ability = scanner.nextInt();
                    if (ability == 1) {
                        lowAbilityUsed(ourPokemon, enemyPokemon);
                    } else if (ability == 2) {
                        mediumAbilityUsed(ourPokemon, enemyPokemon);
                    } else if (ability == 3) {
                        highAbilityUsed(ourPokemon, enemyPokemon);
                    } else {
                        noAbilityUsed(ourPokemon, enemyPokemon);
                    }

                }

                if (ourPokemon.yourChoose.get(0).HP < 0 ) {
                    ourPokemon.yourChoose.get(0).HP = healthBar;
                    ourPokemon.removedPokemon.add(ourPokemon.yourChoose.get(0));
                    ourPokemon.myPokemon.remove(ourPokemon.yourChoose.get(0));
                    System.out.println(ourPokemon.yourChoose.get(0).name + " is dead");
                    if (ourPokemon.myPokemon.size() <= 0) {
                        break loop;
                    } else {
                        if (crystals > 10) {
                            System.out.println("Do you want to resurrect a pokemon? ");
                            ourPokemon.returnPokemon();

                        }
                        ourPokemon.youChooseOnePokemon();
                        roundCounter++;
                        break;
                    }

                } else if (enemyPokemon.enemyChoose.get(0).HP < 0) {
                    System.out.println(enemyPokemon.enemyChoose.get(0).name + " is dead");
                    crystals += randomCrystalGenerator() ;
                    if (enemyPokemon.enemyPokemonList.size() <= 0)  {
                        System.out.println("All enemy pokemons are dead.");
                        break loop;
                    } else  {
                        System.out.print("Enemy player choose: ");
                        enemyPokemon.enemyChoosePokemon();
                        roundCounter++;
                        continue;
                    }

                }
                roundCounter++;
            } // while 2 end
            System.out.println("Crystals amount: " + crystals);
        } // while 1 end

        printLine();
        whoWins(ourPokemon);
    }

    private static void noAbilityUsed(MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        System.out.println("Enemy pokemon HP is: " + enemyPokemon.enemyChoose.get(0).HP);
        System.out.println(ourPokemon.yourChoose.get(0).name + " is attacking with: " +  ourPokemon.yourChoose.get(0).AP + " Attack power");
        System.out.println("Enemy pokemon HP now is: " + (enemyPokemon.enemyChoose.get(0).HP - ourPokemon.yourChoose.get(0).AP) );
        enemyPokemon.enemyChoose.get(0).HP -= ourPokemon.yourChoose.get(0).AP;
    }

    private static void highAbilityUsed(MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        System.out.println("Enemy pokemon HP is: " + enemyPokemon.enemyChoose.get(0).HP);
        System.out.println(ourPokemon.yourChoose.get(0).name + " is attacking with: " +  ourPokemon.highAbility() + " Attack power");
        System.out.println("Enemy pokemon HP now is: " + (enemyPokemon.enemyChoose.get(0).HP - ourPokemon.highAbility()) );
        enemyPokemon.enemyChoose.get(0).HP -= ourPokemon.highAbility();
    }

    private static void mediumAbilityUsed(MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        System.out.println("Enemy pokemon HP is: " + enemyPokemon.enemyChoose.get(0).HP);
        System.out.println(ourPokemon.yourChoose.get(0).name + " is attacking with: " +  ourPokemon.mediumAbility() + " Attack power");
        System.out.println("Enemy pokemon HP now is: " + (enemyPokemon.enemyChoose.get(0).HP - ourPokemon.mediumAbility()) );
        enemyPokemon.enemyChoose.get(0).HP -= ourPokemon.mediumAbility();
    }

    private static void lowAbilityUsed(MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        System.out.println("Enemy pokemon HP is: " + enemyPokemon.enemyChoose.get(0).HP);
        System.out.println(ourPokemon.yourChoose.get(0).name + " is attacking with: " +  ourPokemon.lowAbility() + " Attack power");
        System.out.println("Enemy pokemon HP now is: " + (enemyPokemon.enemyChoose.get(0).HP - ourPokemon.lowAbility()) );
        enemyPokemon.enemyChoose.get(0).HP -= ourPokemon.lowAbility();
    }

    public static void menuOption() {
        System.out.println("1. Play a game!");
        System.out.println("2. Check logs");
        System.out.println("3. Exit");
        System.out.print("Please, select an option from the menu: " + "\n");
    }

    public static void switchMenuOptions (MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        Scanner scanner = new Scanner(System.in);
        byte userOption = scanner.nextByte();
        switch (userOption) {
           case 1 -> playTheGame(ourPokemon, enemyPokemon);
           case 2 -> winnerReader(ourPokemon, enemyPokemon);
            default -> System.out.println("Have a great day!");
        }
    }

    private static void whoWins(MyPokemon ourPokemon) {
        String winner;
        if (ourPokemon.myPokemon.size() <= 0) {
            System.out.println("The enemy wins!");
            winner = "The enemy";
        } else {
            System.out.println(trainerName + " you win!");
            winner = trainerName;
        }

        winnerWritter(winner);
    }

    private static void winnerWritter(String winner) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        File date = new File("winner.txt");
        try {
            FileWriter fw = new FileWriter(date.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dtf.format(now) + " --- The winner is: " + winner + "\n");
            bw.close();
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    private static void winnerReader(MyPokemon ourPokemon, EnemyPokemon enemyPokemon) {
        try {
            File winner = new File("winner.txt");
            Scanner myReader = new Scanner(winner);
            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading");
            e.printStackTrace();
        }

        menuOption();
        switchMenuOptions(ourPokemon,enemyPokemon);
    }

    private static void roundCounter(int roundCounter) {
        if (roundCounter % 2 != 0) {
            System.out.println("Round: " + roundCounter + " - Enemy attack!");
        } else {
            System.out.println("Round: " + roundCounter + " - You attack!");
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

    public static void trainerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        trainerName = in.nextLine();
    }

    public static String selectPokemons() {

        return " 1.Pikachu 2.Squirtle 3.Charizard 4.Crobat 5.Fearow";
    }

    public static void printLine() {
        System.out.println();
    }

    public static int randomCrystalGenerator() {
        Random rand = new Random();
        int randomCrystal = rand.nextInt(20)+1;
        return randomCrystal;
    }
}
