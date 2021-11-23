package com.company;

import java.util.ArrayList;
import java.util.Random;

public class EnemyAttacks extends Pokemon implements EnemyAbility {
    Random rnd=new Random();

    @Override
    public void pcAttackingYouWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).name+" attacking you with low ability");
        yourPokemon.get(0).HP-=enemyPokemon.get(0).AP;
        System.out.println(yourPokemon.get(0).name+" hp: "+yourPokemon.get(0).HP);
    }

    @Override
    public void pcAttackingYouWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).name+" attacking you with medium ability");
        yourPokemon.get(0).HP-=(enemyPokemon.get(0).AP+5);
        System.out.println(yourPokemon.get(0).name+" hp: "+yourPokemon.get(0).HP);
    }

    @Override
    public void pcAttackingYouWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println(enemyPokemon.get(0).name+" attacking you with high ability");
        yourPokemon.get(0).HP-=(enemyPokemon.get(0).AP+10);
        System.out.println(yourPokemon.get(0).name+" hp: "+yourPokemon.get(0).HP);
    }

    @Override
    public void pcUseShield(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Enemy used shield");
        enemyPokemon.get(0).DP+=5;
    }


    public void AbilityChoice(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon){
        int n=rnd.nextInt(4)+1;

        switch (n){
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
                pcUseShield(yourPokemon,enemyPokemon);
                break;
        }
    }
}
