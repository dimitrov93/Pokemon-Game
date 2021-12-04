package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourAttacks extends Pokemon implements YourAbility {
    Scanner scanner = new Scanner(System.in);

    private int attackHelper(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon, int attackStrength) {
        System.out.println(enemyPokemon.get(0).name + "'s health: " + enemyPokemon.get(0).HP);
        int defence = (int) (enemyPokemon.get(0).DP * 0.6);
        System.out.println(yourPokemon.get(0).name + "'s attack power: " + yourPokemon.get(0).AP);
        enemyPokemon.get(0).HP = (enemyPokemon.get(0).HP + defence) - (yourPokemon.get(0).AP + attackStrength);
        System.out.println(enemyPokemon.get(0).name + " hp: " + enemyPokemon.get(0).HP);
        System.out.println();
        return enemyPokemon.get(0).HP;
    }

    @Override
    public int youAttackingPcWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(yourPokemon.get(0).name + " attacking enemy pokemon with LOW ability ");
        return this.attackHelper(yourPokemon, enemyPokemon, 0);
    }

    @Override
    public int youAttackingPcWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(yourPokemon.get(0).name + " attacking enemy pokemon with Medium ability ");
        return this.attackHelper(yourPokemon, enemyPokemon, 5);
    }

    @Override
    public int youAttackingPcWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(yourPokemon.get(0).name + " attacking enemy pokemon with HIGH ability ");
        return this.attackHelper(yourPokemon, enemyPokemon, 10);
    }

    @Override
    public int youUseShield(ArrayList<Pokemon> yourPokemon) {
        System.out.println(yourPokemon.get(0).name + " use shield. Your defense power increase with 5 points");
        yourPokemon.get(0).DP += 5;
        System.out.println("Defense power after shield on " + yourPokemon.get(0).name + " is " + yourPokemon.get(0).DP);
        System.out.println();
        return yourPokemon.get(0).DP;
    }

    public void AbilityChoice(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Choose 1 for low attack");
        System.out.println("Choose 2 for medium attack");
        System.out.println("Choose 3 for high attack");
        System.out.println("Choose 4 for shield");
        byte attackAbility = scanner.nextByte();
        switch (attackAbility) {
            case 1:
                youAttackingPcWithLowAbility(yourPokemon, enemyPokemon);
                break;
            case 2:
                youAttackingPcWithMediumAbility(yourPokemon, enemyPokemon);
                break;
            case 3:
                youAttackingPcWithHighAbility(yourPokemon, enemyPokemon);
                break;
            case 4:
                youUseShield(yourPokemon);
                break;
        }
    }
}