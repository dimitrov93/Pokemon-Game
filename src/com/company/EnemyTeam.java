package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EnemyTeam extends EnemyPokemon implements EnemyPokemons {

    @Override
    public ArrayList<Pokemon> randomEnemyPokemonInBattle() {
        Random rnd = new Random();
        ArrayList<Integer> randomCounts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int n = rnd.nextInt(5);

            while (randomCounts.contains(n)) {
                n = rnd.nextInt(5);
            }
            randomCounts.add(n);
            enemyPokemonList.add(pokemon[n]);
        }
        return enemyPokemonList;
    }

    @Override
    public void printEnemyPokemon() {
        System.out.println("Enemy pokemons are:");
        for (int i = 0; i < 3; i++) {
            System.out.println(enemyPokemonList.get(i));
        }

    }

    @Override
    public ArrayList<Pokemon> enemyChoosePokemon() {
        Collections.shuffle(enemyPokemonList);
        enemyChoose.add(0, enemyPokemonList.get(0));
        System.out.println(enemyChoose.get(0).name);
        enemyPokemonList.remove(0);
        return enemyChoose;
    }

    public void enemyChoiceNewPokemonForBattle(Awards awards, EnemyTeam enemyTeam) {
        System.out.print("Enemy player choose: ");
        enemyChoose = enemyTeam.enemyChoosePokemon();
        System.out.println("Crystals amount: " + awards.crystals);
    }
}
