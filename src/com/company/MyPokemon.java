package com.company;

import java.util.*;

public class MyPokemon  {
    public Pokemon[] pokemon;
    Pokemon yourChoose;

    Scanner scanner = new Scanner(System.in);

    public MyPokemon() {
        this.pokemon = new Pokemon[5];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        pokemon[1] = new Pokemon("Squirtle", "Aqual", "Small", 55, 48, 65);
        pokemon[2] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        pokemon[3] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        pokemon[4] = new Pokemon("Fearow", "Flying", "Medium", 65, 90, 65);

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
