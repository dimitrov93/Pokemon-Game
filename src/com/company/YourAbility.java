package com.company;

import java.util.ArrayList;

public interface YourAbility {
    public int youAttackingPcWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public int youAttackingPcWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public int youAttackingPcWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public int youUseShield(ArrayList<Pokemon> yourPokemon);
}
