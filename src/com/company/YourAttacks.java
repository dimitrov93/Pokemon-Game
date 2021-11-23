package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourAttacks extends Pokemon implements YourAbility{
    Scanner scanner=new Scanner(System.in);

    @Override
    public void youAttackingPcWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You attacking enemy pokemon with low ability");
        enemyPokemon.get(0).HP-=yourPokemon.get(0).AP;
        System.out.println("Enemy pokemon: "+enemyPokemon.get(0).name+ " hp: "+enemyPokemon.get(0).HP);
    }

    @Override
    public void youAttackingPcWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You attacking enemy pokemon with medium ability");
        enemyPokemon.get(0).HP-=(yourPokemon.get(0).AP+5);
        System.out.println("Enemy pokemon: "+enemyPokemon.get(0).name+ " hp: "+enemyPokemon.get(0).HP);
    }

    @Override
    public void youAttackingPcWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You attacking enemy pokemon with high ability");
        enemyPokemon.get(0).HP-=(yourPokemon.get(0).AP+10);
        System.out.println("Enemy pokemon: "+enemyPokemon.get(0).name+ " hp: "+enemyPokemon.get(0).HP);
    }

    @Override
    public void youUseShield(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You use shield");
        yourPokemon.get(0).DP+=5;
    }

    public void AbilityChoice(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("Choose 1 for low attack");
        System.out.println("Choose 2 for medium attack");
        System.out.println("Choose 3 for high attack");
        System.out.println("Choose 4 for shield");
        byte attackAbility=scanner.nextByte();
        switch (attackAbility){
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
                youUseShield(yourPokemon,enemyPokemon);
                break;
        }
    }
}
