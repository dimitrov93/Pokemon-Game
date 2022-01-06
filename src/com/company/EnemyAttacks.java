package com.company;

import java.util.ArrayList;
import java.util.Random;

public class EnemyAttacks extends Pokemon implements EnemyAbility {
    Random rnd = new Random();

    private int attackHelper(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon, int attackStrength) {
        System.out.println(yourPokemon.get(0).getName() + "'s health: " + yourPokemon.get(0).getHealthPoints());
        int defence = (int) (yourPokemon.get(0).getDefense() * 0.6);
        System.out.println("Enemy attack power: " + enemyPokemon.get(0).getAttackPower());
        int healthPointsAfterAttack= (yourPokemon.get(0).getHealthPoints() + defence) -
                (enemyPokemon.get(0).getAttackPower() + attackStrength);
        yourPokemon.get(0).setHealthPoints(healthPointsAfterAttack);
        System.out.println(yourPokemon.get(0).getName() + " hp: " + yourPokemon.get(0).getHealthPoints());
        System.out.println();
        return yourPokemon.get(0).getHealthPoints();
    }

    @Override
    public int pcAttackingYouWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).getName() + " attacking you with LOW ability");
        return attackHelper(yourPokemon, enemyPokemon, 0);
    }

    @Override
    public int pcAttackingYouWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).getName() + " attacking you with MEDIUM ability");
        return attackHelper(yourPokemon, enemyPokemon, 5);
    }

    @Override
    public int pcAttackingYouWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).getName() + " attacking you with HIGH ability");
        return attackHelper(yourPokemon, enemyPokemon, 10);
    }

    @Override
    public int pcUseShield(ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy used shield. Enemy defence power increase with 5 points");
        int currentDefense=enemyPokemon.get(0).getDefense();
        currentDefense+=5;
        enemyPokemon.get(0).setDefense(currentDefense);
        System.out.println(enemyPokemon.get(0).getName() + "'s defence power after shield is used: " + enemyPokemon.get(0).getDefense());
        System.out.println();
        return enemyPokemon.get(0).getDefense();
    }


    public void AbilityChoice(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
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
