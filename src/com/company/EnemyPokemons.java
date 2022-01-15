package com.company;

import java.util.ArrayList;

public interface EnemyPokemons {
    ArrayList<Pokemon> randomEnemyPokemonInBattle();

    void printEnemyPokemon();

    Pokemon enemyChoosePokemon();
}
