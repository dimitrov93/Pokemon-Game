package com.company;

import java.util.ArrayList;
import java.util.Random;

public class EnemyAttacks extends Pokemon implements EnemyAbility {
    Random rnd=new Random();

    @Override
    public int pcAttackingYouWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy pokemon attacking you with low ability");
        System.out.println("Your health: " + yourPokemon.get(0).HP);
        System.out.println("Your defence power: "+yourPokemon.get(0).DP);
        int defence = (int)(yourPokemon.get(0).DP * 0.6);
        System.out.println("Your defence = 60% your defence power");
        System.out.println("Your defence: " + defence);
        System.out.println("Enemy attack power: "+enemyPokemon.get(0).AP);
        yourPokemon.get(0).HP = (yourPokemon.get(0).HP + defence) - enemyPokemon.get(0).AP;
        System.out.println("Your health=(your health + your defence)-enemy attack power");
        System.out.println("Your pokemon: "+yourPokemon.get(0).name + " hp: " + yourPokemon.get(0).HP);
        System.out.println();
        return yourPokemon.get(0).HP;
    }

    @Override
    public int pcAttackingYouWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy pokemon attacking you with medium ability");
        System.out.println("Your health: " + yourPokemon.get(0).HP);
        System.out.println("Your defence power: "+yourPokemon.get(0).DP);
        int defence = (int)(yourPokemon.get(0).DP * 0.6);
        System.out.println("Your defence = 60% your defence power");
        System.out.println("Your defence is: " + defence);
        System.out.println("Enemy attack power: "+enemyPokemon.get(0).AP);
        yourPokemon.get(0).HP = (yourPokemon.get(0).HP + defence) - (enemyPokemon.get(0).AP +5);
        System.out.println("Your health=(your health + your defence)-(enemy attack power + 5)");
        System.out.println("Your pokemon: "+yourPokemon.get(0).name + " hp: " + yourPokemon.get(0).HP);
        System.out.println();
        return yourPokemon.get(0).HP;
    }

    @Override
    public int pcAttackingYouWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy pokemon attacking you with high ability");
        System.out.println("Your health: " + yourPokemon.get(0).HP);
        System.out.println("Your defence power: "+yourPokemon.get(0).DP);
        int defence = (int)(yourPokemon.get(0).DP * 0.6);
        System.out.println("Your defence = 60% your defence power");
        System.out.println("Your defence is: " + defence);
        System.out.println("Enemy attack power: "+enemyPokemon.get(0).AP);
        yourPokemon.get(0).HP = (yourPokemon.get(0).HP + defence) - (enemyPokemon.get(0).AP + 10);
        System.out.println("Your health=(your health + your defence)-(enemy attack power + 10)");
        System.out.println("Your pokemon: "+yourPokemon.get(0).name + " hp: " + yourPokemon.get(0).HP);
        System.out.println();
        return yourPokemon.get(0).HP;
    }

    @Override
    public int pcUseShield(ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy used shield");
        System.out.println("Defence power before shield: "+enemyPokemon.get(0).DP);
        enemyPokemon.get(0).DP += 5;
        System.out.println("Enemy defence power increase with five points");
        System.out.println("Defence power after shield on "+enemyPokemon.get(0).name+ " is "+ enemyPokemon.get(0).DP);
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
