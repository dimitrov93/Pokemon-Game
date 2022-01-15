package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class YourTeam extends MyPokemon implements YourPokemons {
    private String trainerName;
    public ArrayList<Pokemon> myPokemon = new ArrayList<>();
    public ArrayList<Pokemon> removedPokemon = new ArrayList<>();
    public Pokemon yourChoose;

    Scanner scanner = new Scanner(System.in);

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String trainerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        setTrainerName(in.next());
        return getTrainerName();
    }

    @Override
    public ArrayList<Pokemon> choosePokemonInBattle(int selectedPokemon) {
        boolean stopper = false;

        for (Pokemon value : myPokemon) {
            if (Objects.equals(value.getName(), pokemon[selectedPokemon - 1].getName())) {
                stopper = true;
                System.out.println("You already choose that pokemon. Try again: ");
                break;
            }
        }

        if (!stopper) {
            myPokemon.add(pokemon[selectedPokemon - 1]);
        }

        return myPokemon;
    }

    public Pokemon restorePokemon() {
        for (int i = 0; i < removedPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + removedPokemon.get(i).getName());
        }
        int size = removedPokemon.size();
        loop:
        while (true) {
            int choice = scanner.nextInt();
            if (size == 1) {
                switch (choice) {
                    case 1 -> {
                        myPokemon.add(removedPokemon.get(0));
                        break loop;
                    }
                    default -> System.out.println("Error");
                }
            } else if (size == 2) {
                switch (choice) {
                    case 1 -> {
                        myPokemon.add(removedPokemon.get(0));
                        break loop;
                    }
                    case 2 -> {
                        myPokemon.add(removedPokemon.get(1));
                        break loop;
                    }
                    default -> System.out.println("Error");
                }
            }
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

        int size = myPokemon.size();

        loop:
        while (true) {
            int choice = scanner.nextInt();

            if (size == 3) {
                if (youChooseOnePokemonSize3(choice)) break loop;
            } else if (size == 2) {
                if (youChooseOnePokemonSize2(choice)) break loop;
            } else {
                switch (choice) {
                    case 1 -> {
                        this.yourChoose = myPokemon.get(0);
                        System.out.println("Your Pokemon is: " + this.yourChoose.getName());
                        break loop;
                    }
                    default -> System.out.println("Incorrect input");
                }
            }
        }

        return this.yourChoose;
    }

    private boolean youChooseOnePokemonSize2(int choice) {
        switch (choice) {
            case 1 -> {
                this.yourChoose = myPokemon.get(0);
                System.out.println("Your Pokemon is: " + this.yourChoose.getName());
                return true;
            }
            case 2 -> {
                this.yourChoose = myPokemon.get(1);
                System.out.println("Your Pokemon is: " + this.yourChoose.getName());
                return true;
            }
            default -> System.out.println("Incorrect input");
        }
        return false;
    }

    private boolean youChooseOnePokemonSize3(int choice) {
        switch (choice) {
            case 1 -> {
                this.yourChoose = myPokemon.get(0);
                System.out.println("Your Pokemon is: " + this.yourChoose.getName());
                return true;
            }
            case 2 -> {
                this.yourChoose = myPokemon.get(1);
                System.out.println("Your Pokemon is: " + this.yourChoose.getName());
                return true;
            }
            case 3 -> {
                this.yourChoose = myPokemon.get(2);
                System.out.println("Your Pokemon is: " + this.yourChoose.getName());
                return true;
            }
            default -> System.out.println("Incorrect input");
        }
        return false;
    }

    public void choiceNewPokemonForBattle(YourAttacks yourAttacks, Pokemon enemyChoose) {
        this.yourChoose = null;
        this.yourChoose = youChooseOnePokemon();
        System.out.println("Choice attack!");
        yourAttacks.AbilityChoice(yourChoose, enemyChoose);
    }


    public void yourPokemonDied(int healthBar) {
        System.out.println(this.yourChoose.getName() + " is dead");
        this.yourChoose.setHealthPoints(healthBar);
        removedPokemon.add(this.yourChoose);
        myPokemon.remove(this.yourChoose);
    }
}
