package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourAttacks implements YourAbility{//actions
    Scanner scanner=new Scanner(System.in);

    private int attackHelper(Pokemon yourPokemon,Pokemon enemyPokemon,int attackStrength){
            System.out.println(enemyPokemon.name + "'s health: " +enemyPokemon.HP);
            int defence = (int)(enemyPokemon.DP * 0.6);
            System.out.println(yourPokemon.name + "'s attack power: " + yourPokemon.AP);
            enemyPokemon.HP = (enemyPokemon.HP + defence) - (yourPokemon.AP+attackStrength);
            System.out.println(enemyPokemon.name + " hp: " + enemyPokemon.HP);
            System.out.println();
            return enemyPokemon.HP;
    }

    @Override
    public int youAttackingPcWithLowAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(yourPokemon.name + " attacking enemy pokemon with LOW ability ");
        return this.attackHelper(yourPokemon,enemyPokemon,0);
    }

    @Override
    public int youAttackingPcWithMediumAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(yourPokemon.name + " attacking enemy pokemon with MEDIUM ability");
        return this.attackHelper(yourPokemon,enemyPokemon,5);
    }

    @Override
    public int youAttackingPcWithHighAbility(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println(yourPokemon.name + " attacking enemy pokemon with HIGH ability");
        return this.attackHelper(yourPokemon,enemyPokemon,10);
    }

    @Override
    public int youUseShield(Pokemon yourPokemon) {
        System.out.println(yourPokemon.name + " use shield. Your defense power increase with 5 points");
        yourPokemon.DP += 5;
        System.out.println("Defense power after shield on "+yourPokemon.name+" is "+yourPokemon.DP);
        System.out.println();
        return yourPokemon.DP;
    }

    public void AbilityChoice(Pokemon yourPokemon,Pokemon enemyPokemon) {
        System.out.println("Choose 1 for low attack");
        System.out.println("Choose 2 for medium attack");
        System.out.println("Choose 3 for high attack");
        System.out.println("Choose 4 for shield");
        byte attackAbility = scanner.nextByte();
        switch (attackAbility) {
            case 1:
                youAttackingPcWithLowAbility(yourPokemon,enemyPokemon);
                break;
            case 2:
                youAttackingPcWithMediumAbility(yourPokemon,enemyPokemon);
                break;
            case 3:
                youAttackingPcWithHighAbility(yourPokemon,enemyPokemon);
                break;
            case 4:
                youUseShield(yourPokemon);
                break;
        }
    }
}
