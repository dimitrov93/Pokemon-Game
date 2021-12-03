package com.company;

import java.util.ArrayList;
import java.util.Random;

public class EnemyAttacks implements EnemyAbility {
    Random rnd=new Random();

    private int attackHelper(Pokemon yourPokemon,Pokemon enemyPokemon, int attackStrength){
        System.out.println(yourPokemon.name + "'s health: " + yourPokemon.HP);
        int defence = (int)(yourPokemon.DP * 0.6);
        System.out.println("Enemy attack power: "+enemyPokemon.AP);
        yourPokemon.HP = (yourPokemon.HP + defence) - (enemyPokemon.AP+attackStrength);
        System.out.println(yourPokemon.name + " hp: " + yourPokemon.HP);
        System.out.println();
        return yourPokemon.HP;
    }

    @Override
    public int pcAttackingYouWithLowAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(enemyPokemon.name + " attacking you with LOW ability" );
        return attackHelper(yourPokemon,enemyPokemon,0);
    }

    @Override
    public int pcAttackingYouWithMediumAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(enemyPokemon.name + " attacking you with MEDIUM ability");
        return attackHelper(yourPokemon,enemyPokemon,5);

    }

    @Override
    public int pcAttackingYouWithHighAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(enemyPokemon.name + " attacking you with HIGH ability");
        return attackHelper(yourPokemon,enemyPokemon,10);

    }

    @Override
    public int pcUseShield(Pokemon enemyPokemon) {
        System.out.println("Enemy used shield. Enemy defence power increase with 5 points" );
        enemyPokemon.DP += 5;
        System.out.println(enemyPokemon.name + "'s defence power after shield is used: " + enemyPokemon.DP);
        System.out.println();
        return enemyPokemon.DP;

    }


    public void AbilityChoice(Pokemon yourPokemon,Pokemon enemyPokemon) {
        int n = rnd.nextInt(4) + 1;

        switch (n) {
            case 1:
                pcAttackingYouWithLowAbility(yourPokemon,enemyPokemon);
                break;
            case 2:
                pcAttackingYouWithMediumAbility(yourPokemon,enemyPokemon);
                break;
            case 3:
                pcAttackingYouWithHighAbility(yourPokemon,enemyPokemon);
                break;
            case 4:
                pcUseShield(enemyPokemon);
                break;
        }
    }
}
