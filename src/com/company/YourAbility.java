package com.company;

import java.util.ArrayList;

public interface YourAbility {
    public void youAttackingPcWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public void youAttackingPcWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public void youAttackingPcWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public void youUseShield(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);
}
