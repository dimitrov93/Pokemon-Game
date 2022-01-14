package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourAttacks extends Pokemon implements YourAbility {
    Scanner scanner = new Scanner(System.in);

    private int attackHelper(Pokemon yourPokemon, Pokemon enemyPokemon, int attackStrength) {
        System.out.println(enemyPokemon.getName() + "'s health: " + enemyPokemon.getHealthPoints());
        int defence = (int) (enemyPokemon.getDefensePoints() * 0.6);
        System.out.println(yourPokemon.getName() + "'s attack power: " + yourPokemon.getAttackPower());
        int healthPointsAfterAttack=(enemyPokemon.getHealthPoints() + defence) -
                (yourPokemon.getAttackPower() + attackStrength);
        enemyPokemon.setHealthPoints(healthPointsAfterAttack);
        System.out.println(enemyPokemon.getName() + " hp: " + enemyPokemon.getHealthPoints());
        System.out.println();
        return enemyPokemon.getHealthPoints();
    }

    @Override
    public int youAttackingPcWithLowAbility(Pokemon yourPokemon, Pokemon enemyPokemon) {
        System.out.println(yourPokemon.getName() + " attacking enemy pokemon with LOW ability ");
        return this.attackHelper(yourPokemon, enemyPokemon, 0);
    }

    @Override
    public int youAttackingPcWithMediumAbility(Pokemon yourPokemon, Pokemon enemyPokemon) {
        System.out.println(yourPokemon.getName() + " attacking enemy pokemon with Medium ability ");
        return this.attackHelper(yourPokemon, enemyPokemon, 5);
    }

    @Override
    public int youAttackingPcWithHighAbility(Pokemon yourPokemon, Pokemon enemyPokemon) {
        System.out.println(yourPokemon.getName() + " attacking enemy pokemon with HIGH ability ");
        return this.attackHelper(yourPokemon, enemyPokemon, 10);
    }

    @Override
    public int youUseShield(Pokemon yourPokemon) {
        System.out.println(yourPokemon.getName() + " use shield. Your defense power increase with 5 points");
        int currentDefense=yourPokemon.getDefensePoints();
        currentDefense+=5;
        yourPokemon.setDefensePoints(currentDefense);
        System.out.println("Defense power after shield on " + yourPokemon.getName() + " is " + yourPokemon.getDefensePoints());
        System.out.println();
        return yourPokemon.getDefensePoints();
    }

    public void AbilityChoice(Pokemon yourPokemon, Pokemon enemyPokemon) {
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