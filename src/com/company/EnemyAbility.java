package com.company;

import java.util.ArrayList;

public interface EnemyAbility {
    public int pcAttackingYouWithLowAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public int pcAttackingYouWithMediumAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public int pcAttackingYouWithHighAbility(ArrayList<Pokemon> yourPokemon, ArrayList<Pokemon> enemyPokemon);

    public int pcUseShield(ArrayList<Pokemon> enemyPokemon);
}
