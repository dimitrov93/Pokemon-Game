package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static String trainerName;

    public static void main(String[] args) {
        MyPokemon ourPokemon = new MyPokemon();
        EnemyPokemon enemyPokemon = new EnemyPokemon();

        try {
            printPokemonText();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

        loop: while(enemyPokemon.enemyPokemonList.size()!=0 || ourPokemon.myPokemon.size()!=0 || roundCounter <= 5){


            while (true) {  // while 2 start
                printLine();
                roundCounter(roundCounter);
                printLine();
                if (roundCounter % 2 != 0) {
                    System.out.println("Your pokemon HP is: " + ourPokemon.yourChoose.get(0).HP);
                    System.out.println(enemyPokemon.enemyChoose.get(0).name + " is attacking with: " +  enemyPokemon.enemyChoose.get(0).AP + " Attack power");
                    System.out.println("Your pokemon HP now is: " + (ourPokemon.yourChoose.get(0).HP - enemyPokemon.enemyChoose.get(0).AP) );
                    ourPokemon.yourChoose.get(0).HP -= enemyPokemon.enemyChoose.get(0).AP;
                } else {
                    System.out.println(trainerName + " - your turn! Choose attack to hit with: 1,2,3");
                    System.out.println("Enemy pokemon HP is: " + enemyPokemon.enemyChoose.get(0).HP);
                    System.out.println(ourPokemon.yourChoose.get(0).name + " is attacking with: " +  ourPokemon.yourChoose.get(0).AP + " Attack power");
                    System.out.println("Enemy pokemon HP now is: " + (enemyPokemon.enemyChoose.get(0).HP - ourPokemon.yourChoose.get(0).AP) );
                    enemyPokemon.enemyChoose.get(0).HP -= ourPokemon.yourChoose.get(0).AP;
                }

                if (ourPokemon.yourChoose.get(0).HP < 0 ) {
                    ourPokemon.myPokemon.remove(ourPokemon.yourChoose.get(0));
                    System.out.println(ourPokemon.yourChoose.get(0).name + " is dead");
                    if (ourPokemon.myPokemon.size() <= 0) {
                        break loop;
                    } else {
                        ourPokemon.youChooseOnePokemon();
                        roundCounter++;
                        break;
                    }

                } else if (enemyPokemon.enemyChoose.get(0).HP < 0) {
                    System.out.println(enemyPokemon.enemyChoose.get(0).name + " is dead");
                    if (enemyPokemon.enemyPokemonList.size() <= 0)  {
                        System.out.println("All enemy pokemons are dead.");
                        break loop;
                    } else  {
                        System.out.print("Enemy player choose: ");
                        enemyPokemon.enemyChoosePokemon();
                        roundCounter++;
                        break;
                    }

                }
                roundCounter++;
            } // while 2 end
        } // while 1 end

        printLine();
        whoWins(ourPokemon);
    }

    private static void whoWins(MyPokemon ourPokemon) {
        if (ourPokemon.myPokemon.size() <= 0) {
            System.out.println("The enemy wins!");
        } else {
            System.out.println(trainerName + " you win!");
        }
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
}
