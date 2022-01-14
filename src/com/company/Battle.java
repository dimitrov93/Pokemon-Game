package com.company;

import java.util.Scanner;

public class Battle{
    static String theWinner;
    Scanner scanner = new Scanner(System.in);
    Awards awards = new Awards();
    Winner winner = new Winner();

    public void playTheGame(YourTeam yourTeam, EnemyTeam enemyTeam,
                            YourAttacks yourAttacks, EnemyAttacks enemyAttacks) {

        int roundCounter = 1;
        System.out.println("The battle begins");
        choosePokemonToPlayWith(yourTeam);
        System.out.print("Enemy player choose: ");
        enemyTeam.enemyChoose = enemyTeam.enemyChoosePokemon();
        System.out.println(" ");
        loop: while (enemyTeam.enemyPokemonList.size() != 0 || yourTeam.myPokemon.size() != 0 || roundCounter <= 5) {
            int healthBar = yourTeam.yourChoose.getHealthPoints();

            while (true) {
                if (roundCounter % 2 != 0) {
                    enemyTurn(yourTeam,enemyAttacks,enemyTeam,roundCounter);
                    if(yourTeam.yourChoose.getHealthPoints() <=0&&yourTeam.myPokemon.size() == 0){
                        break loop;
                    }else {
                        if ( yourTeam.yourChoose.getHealthPoints() <=0) {
                            yourTeam.yourPokemonDied( healthBar);

                            if (yourTeam.myPokemon.size() == 0&& awards.getCrystal()<11 ) {
                                break loop;
                            } else if (yourTeam.myPokemon.size() >= 0 && awards.getCrystal() >=11) {
                                if(yourTeam.myPokemon.size() == 0 &&resurrectAPokemon(yourTeam)==false){
                                    break loop;
                                }
                            } else {
                                checkIfYouHaveOnlyOneOrMoreLivePokemonLeft(yourTeam);
                            }
                            roundCounter++;
                            break;
                        }
                    }

                }else {
                    yourTurn(yourTeam,yourAttacks,enemyTeam,roundCounter);
                }
                if ( enemyTeam.enemyChoose.getHealthPoints() <= 0) {
                    enemyPokemonIsDead(enemyTeam);
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

    private void checkIfYouHaveOnlyOneOrMoreLivePokemonLeft(YourTeam yourTeam){
        checkIfYouHaveMoreThan1LivePokemon(yourTeam);
        checkIfYouHaveOnly1LivePokemonLeft(yourTeam);
    }

    private void checkIfYouHaveOnly1LivePokemonLeft(YourTeam yourTeam){
        if (yourTeam.myPokemon.size() == 1) {
            onePokemonLeftToPlayWith(yourTeam);
        }
    }

    private void checkIfYouHaveMoreThan1LivePokemon(YourTeam yourTeam){
        if (yourTeam.myPokemon.size() > 1) {
            choosePokemonToPlayWith(yourTeam);
        }
    }

    private void yourTurn(YourTeam yourTeam, YourAttacks yourAttacks,EnemyTeam enemyTeam,int roundCounter){
        if (yourTeam.myPokemon.size() > 1) {
            selectAnOptionFromTheMenu(yourTeam, yourAttacks,enemyTeam, roundCounter);
        } else if (yourTeam.myPokemon.size() == 1) {
            selectAttack(yourTeam,yourAttacks,enemyTeam, roundCounter);

        }
    }

    private void enemyPokemonIsDead(EnemyTeam enemyTeam) {
        System.out.println(enemyTeam.enemyChoose.getName() + " is dead");
        awards.crystalGenerator();
    }

    private void selectAttack(YourTeam yourTeam,YourAttacks yourAttacks,EnemyTeam enemyTeam, int roundCounter) {
        System.out.println("Round: " + roundCounter + " - You attack!" + " Crystals amount: " + awards.getCrystal() + '\n');
        System.out.println();
        System.out.println("Choice your attack");
        yourAttacks.AbilityChoice(yourTeam.yourChoose, enemyTeam.enemyChoose);
    }

    private void enemyTurn(YourTeam yourTeam,EnemyAttacks enemyAttacks,EnemyTeam enemyTeam, int roundCounter ){
        System.out.println("Round: " + roundCounter + " - Enemy attack! " + "Crystals amount: " + +awards.getCrystal() + '\n');
        enemyAttacks.AbilityChoice(yourTeam.yourChoose, enemyTeam.enemyChoose);
    }

    private void selectAnOptionFromTheMenu(YourTeam yourTeam, YourAttacks yourAttacks,EnemyTeam enemyTeam, int roundCounter) {
        System.out.println("Round: " + roundCounter + " - You attack!" + " Crystals amount: " + awards.getCrystal() + '\n');
        System.out.println("Press 1 for attack choice");
        System.out.println("Press 2 for new pokemon");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> yourAttacks.AbilityChoice(yourTeam.yourChoose, enemyTeam.enemyChoose);
            case 2 -> yourTeam.choiceNewPokemonForBattle(yourAttacks, enemyTeam.enemyChoose);
        }
    }

    private void choosePokemonToPlayWith(YourTeam yourTeam) {
        System.out.println("Choose pokemon to play with: ");
        yourTeam.yourChoose = yourTeam.youChooseOnePokemon();
    }

    private void onePokemonLeftToPlayWith(YourTeam yourTeam) {
        System.out.println(" ");
        yourTeam.yourChoose=(yourTeam.myPokemon.get(0));
        System.out.println("There is only one Pokemon left. You play with: " + yourTeam.yourChoose.getName());
    }

    private boolean resurrectAPokemon(YourTeam yourTeam) {
        boolean flag= awards.pokemonRebirth(yourTeam);
        if(yourTeam.myPokemon.size()==1){
            onePokemonLeftToPlayWith(yourTeam);
        }else if(yourTeam.myPokemon.size()>1) {
            System.out.println("Choose pokemon to play with: ");
            yourTeam.youChooseOnePokemon();
        }
        return flag;
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