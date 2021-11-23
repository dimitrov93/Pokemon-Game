package com.company;

import java.util.ArrayList;

public interface YourAbility {
//    public int lowAbility();
//    public int mediumAbility();
//    public int highAbility();
//    public void youUseShield();
public void youAttackingPcWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
    public void youAttackingPcWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
    public void youAttackingPcWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
    public void youUseShield(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
}
