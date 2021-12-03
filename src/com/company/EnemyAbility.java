package com.company;

import java.util.ArrayList;

public interface EnemyAbility {
    public int pcAttackingYouWithLowAbility(Pokemon yourPokemon,Pokemon enemyPokemon);

    public int pcAttackingYouWithMediumAbility(Pokemon yourPokemon,Pokemon enemyPokemon);

    public int pcAttackingYouWithHighAbility(Pokemon yourPokemon,Pokemon enemyPokemon);

    public int pcUseShield(Pokemon enemyPokemon);
}
