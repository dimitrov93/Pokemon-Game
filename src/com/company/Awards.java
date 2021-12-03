package com.company;

import java.util.Random;
import java.util.Scanner;

public class Awards extends Pokemon {
    Scanner scanner = new Scanner(System.in);
    public int crystals;
//    Awards(){
//        this.crystals=0;
//    }

    public  void pokemonRebirth(YourTeam yourTeam) {
        System.out.println("Do you want to resurrect a pokemon? ");
        System.out.println("1-Yes");
        System.out.println("2-No");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                yourChoose =yourTeam.restorePokemon(yourTeam);
                crystals = 0;
                break;
            case 2:
                System.out.println("Have a great day!");
                break;
        }
    }
    public  int crystalGenerator() {
        Random rand = new Random();
        // int randomCrystal = rand.nextInt(20) + 1;
         int randomCrystal=11;
        crystals+=randomCrystal;
        return randomCrystal;
    }
}
