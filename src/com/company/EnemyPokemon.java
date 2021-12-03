package com.company;

import java.util.*;

public class EnemyPokemon extends Pokemon{
   public Pokemon[] pokemon;
   public Pokemon enemyChoose;
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


    private void typeCheckForSmallAndBig() {//да бъде отделен клас
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
}
