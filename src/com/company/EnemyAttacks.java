package com.company;

import java.util.ArrayList;
import java.util.Random;

public class EnemyAttacks extends Pokemon implements EnemyAbility {
    Random rnd=new Random();

    @Override
    public int pcAttackingYouWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).name + " attacking you with LOW ability" );
        System.out.println(yourPokemon.get(0).name + "'s health: " + yourPokemon.get(0).HP);
        int defence = (int)(yourPokemon.get(0).DP * 0.6);
        System.out.println("Enemy attack power: "+enemyPokemon.get(0).AP);
        yourPokemon.get(0).HP = (yourPokemon.get(0).HP + defence) - enemyPokemon.get(0).AP;
        System.out.println(yourPokemon.get(0).name + " hp: " + yourPokemon.get(0).HP);
        System.out.println();
        return yourPokemon.get(0).HP;
    }

    @Override
    public int pcAttackingYouWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).name + " attacking you with MEDIUM ability");
        System.out.println(yourPokemon.get(0).name + "'s health: " + yourPokemon.get(0).HP);
        int defence = (int)(yourPokemon.get(0).DP * 0.6);
        System.out.println("Enemy attack power: "+enemyPokemon.get(0).AP);
        yourPokemon.get(0).HP = (yourPokemon.get(0).HP + defence) - (enemyPokemon.get(0).AP +5);
        System.out.println(yourPokemon.get(0).name + " hp: " + yourPokemon.get(0).HP);
        System.out.println();
        return yourPokemon.get(0).HP;
    }

    @Override
    public int pcAttackingYouWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).name + " attacking you with HIGH ability");
        System.out.println(yourPokemon.get(0).name + "'s health: " + yourPokemon.get(0).HP);
        int defence = (int)(yourPokemon.get(0).DP * 0.6);
        System.out.println("Enemy attack power: "+enemyPokemon.get(0).AP);
        yourPokemon.get(0).HP = (yourPokemon.get(0).HP + defence) - (enemyPokemon.get(0).AP + 10);
        System.out.println(yourPokemon.get(0).name + " hp: " + yourPokemon.get(0).HP);
        return yourPokemon.get(0).HP;
    }

    @Override
    public int pcUseShield(ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy used shield. Enemy defence power increase with 5 points" );
        enemyPokemon.get(0).DP += 5;
        System.out.println(enemyPokemon.get(0).name + "'s defence power after shield is used: " + enemyPokemon.get(0).DP);
        System.out.println();
        return enemyPokemon.get(0).DP;
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
