package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EnemyTeam extends EnemyPokemon implements EnemyPokemons {
    public Pokemon enemyChoose;
    public ArrayList<Pokemon> enemyPokemonList = new ArrayList<>();

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
            this.enemyPokemonList.add(pokemon[n]);
        }
        return enemyPokemonList;
    }

    @Override
    public void printEnemyPokemon() {
        System.out.println("Enemy pokemons are:");
        for (int i = 0; i < 3; i++) {
            System.out.println(this.enemyPokemonList.get(i));
        }

    }

    @Override
    public Pokemon enemyChoosePokemon() {
        Collections.shuffle(this.enemyPokemonList);
        this.enemyChoose=this.enemyPokemonList.get(0);
        System.out.println(enemyChoose.getName());
        enemyPokemonList.remove(0);
        return enemyChoose;
    }

    public void enemyChoiceNewPokemonForBattle(Awards awards, EnemyTeam enemyTeam) {
        System.out.print("Enemy player choose: ");
        this.enemyChoose = enemyTeam.enemyChoosePokemon();
        System.out.println("Crystals amount: " + awards.getCrystal());
    }
}
