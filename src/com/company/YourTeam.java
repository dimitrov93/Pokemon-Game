package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourTeam extends MyPokemon implements YourPokemons {


    String trainerName;

    public String trainerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        this.trainerName = in.next();
        return trainerName;
    }

    @Override
    public ArrayList<Pokemon> choosePokemonInBattle(int selectedPokemon) {
        myPokemon.add(pokemon[selectedPokemon - 1]);

        return myPokemon;
    }

    public ArrayList<Pokemon> restorePokemon(YourTeam yourTeam) {
        for (int i = 0; i < removedPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + removedPokemon.get(i).name);
        }
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                yourTeam.myPokemon.add(removedPokemon.get(0));
                break;
            case 2:
                yourTeam.myPokemon.add(removedPokemon.get(1));
                break;
            case 3:
                yourTeam.myPokemon.add(removedPokemon.get(1));
                break;
        }
        return this.yourChoose;

    }

    @Override
    public void printMyPokemons() {
        System.out.println("Your pokemons are: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(myPokemon.get(i));
        }
    }

    @Override
    public ArrayList<Pokemon> youChooseOnePokemon() {
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + myPokemon.get(i).name);
        }
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                yourChoose.add(0, myPokemon.get(0));
                System.out.println("Your Pokemon is: " + yourChoose.get(0).name);
                break;
            case 2:
                yourChoose.add(0, myPokemon.get(1));
                System.out.println("Your Pokemon is: " + yourChoose.get(0).name);
                break;
            case 3:
                yourChoose.add(0, myPokemon.get(2));
                System.out.println("Your Pokemon is: " + yourChoose.get(0).name);
                break;
        }
        return yourChoose;
    }

    public void choiceNewPokemonForBattle(YourAttacks yourAttacks, ArrayList<Pokemon> enemyChoose) {
        yourChoose.remove(0);
        yourChoose = youChooseOnePokemon();
        System.out.println("Choice attack!");
        yourAttacks.AbilityChoice(yourChoose, enemyChoose);
    }

    public void yourPokemonDied(YourTeam yourTeam, int healthBar) {
        System.out.println(yourTeam.yourChoose.get(0).name + " is dead");
        yourChoose.get(0).HP = healthBar;
        yourTeam.removedPokemon.add(yourChoose.get(0));
        yourTeam.myPokemon.remove(yourChoose.get(0));
        yourChoose.remove(0);
    }
}
