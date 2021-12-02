package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourTeam extends MyPokemon implements YourPokemons{

    @Override
    public ArrayList<Pokemon> choosePokemonInBattle(int selectedPokemon) {
//        Scanner scanner = new Scanner(System.in);
//        int count = 0;
//        while (count < 3) {
//            int n = scanner.nextInt();
//            myPokemon.add(pokemon[n - 1]);
////            copyYourTeam.add(pokemon[n - 1]);
//            count++;
//        }
        myPokemon.add(pokemon[selectedPokemon - 1]);

        return myPokemon;
    }
//    public ArrayList<Pokemon> restorePokemon(){
//        for (int i = 0; i < copyYourTeam.size(); i++) {
//            System.out.println((i + 1) + ":" +copyYourTeam.get(i).name);
//        }
//        int choice = scanner.nextInt();
//
//        switch (choice) {
//            case 1:
//                yourChoose.add(0, copyYourTeam.get(0));
//                System.out.println("Your Pokemon is: " + yourChoose.get(0).name+" hp:"+ yourChoose.get(0).HP);
//                break;
//            case 2:
//                yourChoose.add(0, copyYourTeam.get(1));
//                System.out.println("Your Pokemon is: " + yourChoose.get(0).name+" hp:"+ yourChoose.get(0).HP);
//                break;
//            case 3:
//                yourChoose.add(0, copyYourTeam.get(2));
//                System.out.println("Your Pokemon is: " + yourChoose.get(0).name+" hp:"+ yourChoose.get(0).HP);
//                break;
//        }
//        return yourChoose;
//    }

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

    public  void choiceNewPokemonForBattle(YourAttacks yourAttacks,ArrayList<Pokemon> enemyChoose) {
        yourChoose.remove(0);
        yourChoose = youChooseOnePokemon();
        System.out.println("Choice attack!");
        yourAttacks.AbilityChoice(yourChoose, enemyChoose);
    }

    public void yourPokemonDied(YourTeam yourTeam) {
        System.out.println(yourTeam.yourChoose.get(0).name + " is dead");
        yourTeam.myPokemon.remove(yourChoose.get(0));
        yourChoose.remove(0);
    }
}
