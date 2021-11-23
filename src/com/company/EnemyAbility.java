package com.company;

import java.util.ArrayList;

public interface EnemyAbility {
//    public void pcAttackingYouWithLowAbility();
//    public void pcAttackingYouWithMediumAbility();
//    public void pcAttackingYouWithHighAbility();
//    public void pcUseShield();
public void pcAttackingYouWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
    public void pcAttackingYouWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
    public void pcAttackingYouWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
    public void pcUseShield(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
}
