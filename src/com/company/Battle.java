package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle{
    static String theWinner;
    ArrayList<Pokemon> yourChoose = new ArrayList<>();
    ArrayList<Pokemon> enemyChoose = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Awards awards = new Awards();
    Winner winner = new Winner();

    public void playTheGame(YourTeam yourTeam, EnemyTeam enemyTeam,
                            YourAttacks yourAttacks, EnemyAttacks enemyAttacks) {

        int roundCounter = 1;
        System.out.println("The battle begins");
        System.out.println("Choose pokemon to play with: ");
        yourChoose = yourTeam.youChooseOnePokemon();
        System.out.print("Enemy player choose: ");
        enemyChoose = enemyTeam.enemyChoosePokemon();
        System.out.println(" ");
        loop:
        while (enemyTeam.enemyPokemonList.size() != 0 || yourTeam.myPokemon.size() != 0 || roundCounter <= 5) {
            int healthBar = yourChoose.get(0).getHealthPoints();

            while (true) {
                if (roundCounter % 2 != 0) {
                    System.out.println("Round: " + roundCounter + " - Enemy attack! " + "Crystals amount: " + +awards.getCrystal() + '\n');
                    enemyAttacks.AbilityChoice(yourChoose, enemyChoose);
                    if (yourChoose.get(0).getHealthPoints() <= 0) {
                        yourTeam.yourPokemonDied(yourTeam, healthBar);

                        if (yourTeam.myPokemon.size() == 0 && awards.getCrystal()<11) {
                            break;
                        } else if (yourTeam.myPokemon.size() >= 0 &&awards.getCrystal() >=11) {
                            awards.pokemonRebirth(yourTeam);
                            System.out.println("Choose pokemon to play with: ");
                            yourTeam.youChooseOnePokemon();
                        } else {
                            if (yourTeam.myPokemon.size() == 1) {
                                System.out.println(" ");
                                yourChoose.add(yourTeam.myPokemon.get(0));
                                System.out.println("There is only one Pokemon left. You play with: " + yourChoose.get(0).getName());
                            } else if (yourTeam.myPokemon.size() > 1) {
                                System.out.println("Choose pokemon to play with: ");
                                yourChoose = yourTeam.youChooseOnePokemon();
                            }
                        }
                        roundCounter++;
                        break;
                    }

                } else {
                    if (yourTeam.myPokemon.size() > 1) {
                        System.out.println("Round: " + roundCounter + " - You attack!" + " Crystals amount: " + awards.getCrystal() + '\n');
                        System.out.println("Press 1 for attack choice");
                        System.out.println("Press 2 for new pokemon");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1 -> yourAttacks.AbilityChoice(yourChoose, enemyChoose);
                            case 2 -> yourTeam.choiceNewPokemonForBattle(yourAttacks, enemyChoose);
                        }
                    } else if (yourTeam.myPokemon.size() == 1) {
                        System.out.println("Round: " + roundCounter + " - You attack!" + " Crystals amount: " + awards.getCrystal() + '\n');
                        System.out.println();
                        System.out.println("Choice your attack");
                        yourAttacks.AbilityChoice(yourChoose, enemyChoose);
                    }

                }
                if (enemyChoose.get(0).getHealthPoints() <= 0) {
                    System.out.println(enemyTeam.enemyChoose.get(0).getName() + " is dead");
                    enemyChoose.remove(0);
                    awards.crystalGenerator();
                    if (enemyTeam.enemyPokemonList.size() <= 0) {
                        System.out.println("All enemy pokemons are dead.");
                        break loop;
                    } else {
                        enemyTeam.enemyChoiceNewPokemonForBattle(awards, enemyTeam);
                        roundCounter++;
                        continue;
                    }
                }
                roundCounter++;
            }
        }
        System.out.println();
        whoWins(yourTeam);
        winner.winnerWriter(theWinner);
    }

    public String whoWins(YourTeam yourTeam) {

        if (yourTeam.myPokemon.size() <= 0) {
            System.out.println("The enemy wins!");
            theWinner = "The enemy";
        } else {
            System.out.println(yourTeam.getTrainerName() + " you win!");
            theWinner = yourTeam.getTrainerName();
        }
        return theWinner;
    }

}
