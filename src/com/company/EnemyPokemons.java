package com.company;

import java.util.ArrayList;

public interface EnemyPokemons {
    ArrayList<Pokemon> randomEnemyPokemonInBattle();

    void printEnemyPokemon();

    ArrayList<Pokemon> enemyChoosePokemon();
}
