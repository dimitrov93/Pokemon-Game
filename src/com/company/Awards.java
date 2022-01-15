package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Awards {
    private int crystals;
    Scanner scanner = new Scanner(System.in);

    public int getCrystal(){
        return this.crystals;
    }

    public void setCrystals(int newCrystals){
        this.crystals=newCrystals;
    }

    public boolean pokemonRebirth(YourTeam yourTeam) {
        boolean flag=true;
        System.out.println("Do you want to resurrect a pokemon? ");
        System.out.println("1-Yes");
        System.out.println("2-No");
        loop: while (true) {
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    yourTeam.restorePokemon();
                    int declineCrystal=getCrystal()-11;
                    setCrystals(declineCrystal);
                    break loop;
                case 2:
                    System.out.println("You didn't want to resurrect a pokemon");
                    flag=false;
                    break loop;
                default:
                    System.out.println("Incorrect input!");
            }
        }

        return flag;
    }

    public int crystalGenerator() {
        int bonusCrystal = 11;
        int currentCrystal=getCrystal();
        currentCrystal+=bonusCrystal;
        setCrystals(currentCrystal);
        return getCrystal();
    }
}
