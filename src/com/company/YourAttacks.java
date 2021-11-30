package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YourAttacks extends Pokemon implements YourAbility{
    Scanner scanner=new Scanner(System.in);

    @Override
    public void youAttackingPcWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You attacking enemy pokemon with low ability ");
        System.out.println("His health: " + enemyPokemon.get(0).HP);
        System.out.println("His defence power: "+enemyPokemon.get(0).DP);
        int defence = (int)(enemyPokemon.get(0).DP * 0.6);
        System.out.println("His defence = 60% his defence power");
        System.out.println("His defence: " + defence);
        System.out.println("Your attack power: " + yourPokemon.get(0).AP);
        enemyPokemon.get(0).HP = (enemyPokemon.get(0).HP + defence) - yourPokemon.get(0).AP;
        System.out.println("His health=(his health + his defence)- your attack power");
        System.out.println("Enemy pokemon: " + enemyPokemon.get(0).name + " hp: " + enemyPokemon.get(0).HP);
        System.out.println();
    }

    @Override
    public void youAttackingPcWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You attacking enemy pokemon with medium ability");
        System.out.println("His health: " + enemyPokemon.get(0).HP);
        System.out.println("His defence power: "+enemyPokemon.get(0).DP);
        int defence = (int)(enemyPokemon.get(0).DP * 0.6);
        System.out.println("His defence = 60% his defence power");
        System.out.println("His defence: " + defence);
        System.out.println("Your attack power: " + yourPokemon.get(0).AP);
        enemyPokemon.get(0).HP = (enemyPokemon.get(0).HP + defence) - (yourPokemon.get(0).AP + 5);
        System.out.println("His health=(his health + his defence)- (your attack power + 5)");
        System.out.println("Enemy pokemon: " + enemyPokemon.get(0).name + " hp: " + enemyPokemon.get(0).HP);
        System.out.println();
    }

    @Override
    public void youAttackingPcWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon) {
        System.out.println("You attacking enemy pokemon with high ability");
        System.out.println("His health: " + enemyPokemon.get(0).HP);
        System.out.println("His defence power: "+enemyPokemon.get(0).DP);
        int defence = (int)(enemyPokemon.get(0).DP * 0.6);
        System.out.println("His defence = 60% his defence power");
        System.out.println("His defence: " + defence);
        System.out.println("Your attack power: " + yourPokemon.get(0).AP);
        enemyPokemon.get(0).HP = (enemyPokemon.get(0).HP + defence) - (yourPokemon.get(0).AP + 10);
        System.out.println("His health=(his health + his defence)- (your attack power + 10)");
        System.out.println("Enemy pokemon: " + enemyPokemon.get(0).name + " hp: " + enemyPokemon.get(0).HP);
        System.out.println();
    }

    @Override
    public void youUseShield(ArrayList<Pokemon> yourPokemon) {
        System.out.println("You use shield");
        System.out.println("Defence power before shield: "+yourPokemon.get(0).DP);
        yourPokemon.get(0).DP += 5;
        System.out.println("Your defense power increase with five points");
        System.out.println("Defense power after shield on "+yourPokemon.get(0).name+" is "+yourPokemon.get(0).DP);
        System.out.println();
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
