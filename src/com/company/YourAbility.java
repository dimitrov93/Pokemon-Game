package com.company;

import java.util.ArrayList;

public interface YourAbility {
    public int youAttackingPcWithLowAbility(Pokemon yourPokemon,Pokemon enemyPokemon);

    public int youAttackingPcWithMediumAbility(Pokemon yourPokemon,Pokemon enemyPokemon);

    public int youAttackingPcWithHighAbility(Pokemon yourPokemon,Pokemon enemyPokemon);

    public int youUseShield(Pokemon yourPokemon);
}
