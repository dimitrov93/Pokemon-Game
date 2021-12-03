package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourTeam extends MyPokemon implements YourPokemons{
    public ArrayList<Pokemon> myPokemon = new ArrayList<>();
    public ArrayList<Pokemon> removedPokemon = new ArrayList<>();

    @Override
    public ArrayList<Pokemon> choosePokemonInBattle(int selectedPokemon) {
        myPokemon.add(pokemon[selectedPokemon - 1]);

        return myPokemon;
    }
    public Pokemon restorePokemon(YourTeam yourTeam){
        for (int i = 0; i < removedPokemon.size(); i++) {
            System.out.println((i + 1) + ":" +removedPokemon.get(i).name);
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

    public void printOnlyNamesOnPokemonInMyTeam(){
        System.out.println("Your pokemons are: ");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + ":" +myPokemon.get(i).name);
        }
    }

    @Override
    public Pokemon youChooseOnePokemon(int choice) { ;
        yourChoose= myPokemon.get(choice-1);
        System.out.println("Your Pokemon is: " + yourChoose.name);
        return yourChoose;
    }

    public Pokemon choiceNewPokemonForBattle(Pokemon enemyPokemon,YourAttacks yourAttacks, int choice) {
        yourChoose = youChooseOnePokemon(choice);
        System.out.println("Choice attack!");
        yourAttacks.AbilityChoice(yourChoose,enemyPokemon);
        return yourChoose;
    }

    public void yourPokemonDied( int healthBar) {
        System.out.println(this.yourChoose.name + " is dead");
        yourChoose.HP = healthBar;
        removedPokemon.add(this.yourChoose);
        myPokemon.remove(this.yourChoose);
    }
}
