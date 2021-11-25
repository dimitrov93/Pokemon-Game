package com.company;

import java.util.*;

public class EnemyPokemon extends Pokemon{
    Pokemon[] pokemon;
    ArrayList<Pokemon> enemyPokemonList = new ArrayList<>();

    public EnemyPokemon() {
        this.pokemon = new Pokemon[5];
        pokemon[0] = new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        pokemon[1] = new Pokemon("Butterfree", "Flying", "Small", 60, 45, 50);
        pokemon[2] = new Pokemon("Corsola", "Water", "Big", 65, 65, 95);
        pokemon[3] = new Pokemon("Roselia", "Grass", "Small", 50, 60, 45);
        pokemon[4] = new Pokemon("Yanma", "Flying", "Medium", 65, 65, 45);

        typeCheckForSmallAndBig();
    }


    private void typeCheckForSmallAndBig() {
        for (int i = 0; i < 5; i++) {
            if (pokemon[i].size.equals("Small")) {
                pokemon[i].HP = (int) (pokemon[i].HP - (pokemon[i].HP * 0.2));
                pokemon[i].AP = (int) (pokemon[i].AP - (pokemon[i].AP * 0.2));
                pokemon[i].DP = (int) (pokemon[i].DP - (pokemon[i].DP * 0.2));
            } else if (pokemon[i].size.equals("Big")) {
                pokemon[i].HP = (int) (pokemon[i].HP + (pokemon[i].HP * 0.2));
                pokemon[i].AP = (int) (pokemon[i].AP + (pokemon[i].AP * 0.2));
                pokemon[i].DP = (int) (pokemon[i].DP + (pokemon[i].DP * 0.2));
            }
        }
    }

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

    public void printEnemyPokemon() {
        System.out.println("Enemy pokemons are:");
        for (int i = 0; i < 3; i++) {
            System.out.println(enemyPokemonList.get(i));
        }

    }

    public ArrayList<Pokemon> enemyChoosePokemon() {
        Collections.shuffle(enemyPokemonList);
        enemyChoose.add(0, enemyPokemonList.get(0));
        System.out.println(enemyChoose.get(0).name);
        enemyPokemonList.remove(0);
        return enemyChoose;
    }
}
