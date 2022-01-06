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

    public ArrayList<Pokemon> pokemonRebirth(YourTeam yourTeam) {

        System.out.println("Do you want to resurrect a pokemon? ");
        System.out.println("1-Yes");
        System.out.println("2-No");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                yourTeam.yourChoose = yourTeam.restorePokemon(yourTeam);
                int declineCrystal=getCrystal()-11;
                setCrystals(declineCrystal);
                break;
            case 2:
                System.out.println("Good luck!");
                break;
        }
        return yourTeam.yourChoose;
    }

    public int crystalGenerator() {
        int bonusCrystal = 11;
        int currentCrystal=getCrystal();
        currentCrystal+=bonusCrystal;
        setCrystals(currentCrystal);
        return getCrystal();
    }
}
