package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle  {
    Pokemon yourChoose,enemyChoose;
    Scanner scanner = new Scanner(System.in);
    Awards awards=new Awards();
    Winner winner=new Winner();
// razbivame playTheGame na private metodi
    //da mahnem Trainer
    public void playTheGame(Trainer trainer,YourTeam yourTeam, EnemyTeam enemyTeam,
                            YourAttacks yourAttacks, EnemyAttacks enemyAttacks, int choice) {
        int roundCounter = 1;
        this.yourChoose=yourTeam.youChooseOnePokemon(choice);
        System.out.print("Enemy player choose: ");
        this.enemyChoose = enemyTeam.enemyChoosePokemon();
        System.out.println(" ");
        loop: while (enemyTeam.enemyPokemonList.size() != 0 || yourTeam.myPokemon.size() != 0 || roundCounter <= 5) {
            int healthBar = this.yourChoose.HP;

            while (true) {
                if (roundCounter % 2 != 0) {
                    System.out.println("Round: " + roundCounter + " - Enemy attack! " + "Crystals amount: " + + awards.crystals+ '\n');
                    enemyAttacks.AbilityChoice(yourChoose,enemyChoose);
                    if (this.yourChoose.HP <= 0) {
                        yourTeam.yourPokemonDied(healthBar);
                        if (yourTeam.myPokemon.size() <= 0 && awards.crystals < 10) {
                            break;
                        } else if (awards.crystals > 10) {
                            awards.pokemonRebirth(yourTeam);
                            yourTeam.printOnlyNamesOnPokemonInMyTeam();
                            yourTeam.youChooseOnePokemon(Scanner());
                        } else {
                            if (yourTeam.myPokemon.size() == 1) {
                                System.out.println(" ");
                                this.yourChoose=(yourTeam.myPokemon.get(0));
                                System.out.println("There is only one Pokemon left. You play with: " + this.yourChoose.name);
                            } else if (yourTeam.myPokemon.size() > 1) {
                                yourTeam.printOnlyNamesOnPokemonInMyTeam();
                                yourChoose = yourTeam.youChooseOnePokemon(Scanner());
                            }
                        }
                    }

                } else {
                    if (yourTeam.myPokemon.size() > 1) {
                        System.out.println("Round: " + roundCounter + " - You attack!" + " Crystals amount: " + awards.crystals + '\n');
                        System.out.println("Press 1 for attack choice");
                        System.out.println("Press 2 for new pokemon");
                        int choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1 : yourAttacks.AbilityChoice(yourChoose,enemyChoose);
                            break ;
                            case 2 : yourTeam.printOnlyNamesOnPokemonInMyTeam();
                            yourChoose=yourTeam.choiceNewPokemonForBattle(enemyChoose,yourAttacks,Scanner());
                            break ;
                        }
                    } else if (yourTeam.myPokemon.size() == 1) {
                        System.out.println("Choice your attack");
                        yourAttacks.AbilityChoice(yourChoose,enemyChoose);
                    }

                }
                if (this.enemyChoose.HP <= 0) {
                    System.out.println(this.enemyChoose.name + " is dead");
                    awards.crystals = awards.crystalGenerator();
                    if (enemyTeam.enemyPokemonList.size() <= 0) {
                        System.out.println("All enemy pokemons are dead.");
                        break loop;
                    } else {
                        this.enemyChoose=enemyTeam.enemyChoiceNewPokemonForBattle(awards);
                        roundCounter++;
                        continue;
                    }
                }
                roundCounter++;
            }
        }

        System.out.println();
        winner.whoWins(yourTeam,trainer);
    }
    //whoWins da doide tuk

    private int Scanner(){
        Scanner scanner=new Scanner(System.in);
          int n=scanner.nextInt();
          return n;
    }
}
