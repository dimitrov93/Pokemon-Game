package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Awards extends Pokemon {
    Scanner scanner = new Scanner(System.in);
    public int crystals;

    public ArrayList<Pokemon> pokemonRebirth(YourTeam yourTeam) {
        System.out.println("Do you want to resurrect a pokemon? ");
        System.out.println("1-Yes");
        System.out.println("2-No");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                yourChoose = yourTeam.restorePokemon(yourTeam);
                crystals = 0;
                break;
            case 2:
                System.out.println("Good luck!");
                break;
        }
        return yourChoose;
    }
    public int crystalGenerator() {
        Random rand = new Random();
        // int randomCrystal = rand.nextInt(20) + 1;
        int randomCrystal = 11;
        this.crystals += randomCrystal;
        return this.crystals;
    }
}
