package com.company;

import java.util.ArrayList;
import java.util.Random;

public class EnemyAttacks extends Pokemon implements EnemyAbility {
    Random rnd = new Random();

    private int attackHelper(Pokemon yourPokemon, Pokemon enemyPokemon, int attackStrength) {
        System.out.println(yourPokemon.getName() + "'s health: " + yourPokemon.getHealthPoints());
        int defence = (int) (yourPokemon.getDefensePoints() * 0.6);
        System.out.println("Enemy attack power: " + enemyPokemon.getAttackPower());
        int healthPointsAfterAttack= (yourPokemon.getHealthPoints() + defence) -
                (enemyPokemon.getAttackPower() + attackStrength);
        yourPokemon.setHealthPoints(healthPointsAfterAttack);
        System.out.println(yourPokemon.getName() + " hp: " + yourPokemon.getHealthPoints());
        System.out.println();
        return yourPokemon.getHealthPoints();
    }

    @Override
    public int pcAttackingYouWithLowAbility(Pokemon yourPokemon, Pokemon enemyPokemon) {
        System.out.println(enemyPokemon.getName() + " attacking you with LOW ability");
        return attackHelper(yourPokemon, enemyPokemon, 0);
    }

    @Override
    public int pcAttackingYouWithMediumAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(enemyPokemon.getName() + " attacking you with MEDIUM ability");
        return attackHelper(yourPokemon, enemyPokemon, 5);
    }

    @Override
    public int pcAttackingYouWithHighAbility(Pokemon yourPokemon, Pokemon enemyPokemon) {
        System.out.println(enemyPokemon.getName() + " attacking you with HIGH ability");
        return attackHelper(yourPokemon, enemyPokemon, 10);
    }

    @Override
    public int pcUseShield(Pokemon enemyPokemon) {
        System.out.println("Enemy used shield. Enemy defence power increase with 5 points");
        int currentDefense=enemyPokemon.getDefensePoints();
        currentDefense+=5;
        enemyPokemon.setDefensePoints(currentDefense);
        System.out.println(enemyPokemon.getName() + "'s defence power after shield is used: " + enemyPokemon.getDefensePoints());
        System.out.println();
        return enemyPokemon.getDefensePoints();
    }

    public void AbilityChoice(Pokemon yourPokemon, Pokemon enemyPokemon) {
        int n = rnd.nextInt(4) + 1;

        switch (n) {
            case 1:
                pcAttackingYouWithLowAbility(yourPokemon, enemyPokemon);
                break;
            case 2:
                pcAttackingYouWithMediumAbility(yourPokemon, enemyPokemon);
                break;
            case 3:
                pcAttackingYouWithHighAbility(yourPokemon, enemyPokemon);
                break;
            case 4:
                pcUseShield(enemyPokemon);
                break;
        }
    }
}
