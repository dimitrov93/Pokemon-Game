package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourTeam extends MyPokemon implements YourPokemons {
    private String trainerName;
    public ArrayList<Pokemon> myPokemon = new ArrayList<>();
    public ArrayList<Pokemon> removedPokemon = new ArrayList<>();
    public Pokemon yourChoose;

    Scanner scanner=new Scanner(System.in);

    public String getTrainerName(){
        return trainerName;
    }

    public void setTrainerName(String trainerName){
        this.trainerName=trainerName;
    }

    public String trainerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        setTrainerName(in.next());
        return getTrainerName();
    }

    @Override
    public ArrayList<Pokemon> choosePokemonInBattle(int selectedPokemon) {
        myPokemon.add(pokemon[selectedPokemon - 1]);

        return myPokemon;
    }

    public Pokemon restorePokemon() {
        for (int i = 0; i < removedPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + removedPokemon.get(i).getName());
        }
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                myPokemon.add(removedPokemon.get(0));
                break;
            case 2:
                myPokemon.add(removedPokemon.get(1));
                break;
            case 3:
                myPokemon.add(removedPokemon.get(2));
                break;
        }
        return yourChoose;

    }

    @Override
    public void printMyPokemons() {
        System.out.println("Your pokemons are: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(myPokemon.get(i));
        }
    }

    @Override
    public Pokemon youChooseOnePokemon() {
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + myPokemon.get(i).getName());
        }
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                this.yourChoose=myPokemon.get(0);
                System.out.println("Your Pokemon is: " +this.yourChoose.getName());
            }
            case 2 -> {
                this.yourChoose=myPokemon.get(1);
                System.out.println("Your Pokemon is: " +this.yourChoose.getName());
            }
            case 3 -> {
                this.yourChoose=myPokemon.get(2);
                System.out.println("Your Pokemon is: " +this.yourChoose.getName());
            }
        }
        return this.yourChoose;
    }

    public void choiceNewPokemonForBattle(YourAttacks yourAttacks, Pokemon enemyChoose) {
        this.yourChoose=null;
        this.yourChoose=youChooseOnePokemon();
        System.out.println("Choice attack!");
        yourAttacks.AbilityChoice(yourChoose, enemyChoose);
    }


    public void yourPokemonDied( int healthBar) {
        System.out.println(this.yourChoose.getName() + " is dead");
        this.yourChoose.setHealthPoints(healthBar);
        removedPokemon.add(this.yourChoose);
        myPokemon.remove(this.yourChoose);
    }
}
