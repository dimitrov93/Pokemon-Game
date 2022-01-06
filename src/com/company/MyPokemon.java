package com.company;

import java.util.*;

public class MyPokemon{
    protected Pokemon[] pokemon;
    public MyPokemon() {
        this.pokemon = new Pokemon[5];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 5, 55, 40);
        pokemon[1] = new Pokemon("Squirtle", "Aqual", "Small", 55, 48, 65);
        pokemon[2] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        pokemon[3] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        pokemon[4] = new Pokemon("Fearow", "Flying", "Medium", 65, 90, 65);

        for (int i = 0; i < 5; i++) {
            if (pokemon[i].getSize().equals("Small")) {
                pokemon[i].setHealthPoints((int) (pokemon[i].getHealthPoints() - (pokemon[i].getHealthPoints() * 0.2)));
                pokemon[i].setAttackPower((int) (pokemon[i].getAttackPower() - (pokemon[i].getAttackPower() * 0.2)));
                pokemon[i].setDefense((int) (pokemon[i].getDefense() - (pokemon[i].getDefense() * 0.2)));
            } else if (pokemon[i].getSize().equals("Big")) {
                pokemon[i].setHealthPoints((int) (pokemon[i].getHealthPoints() + (pokemon[i].getHealthPoints() * 0.2)));
                pokemon[i].setAttackPower((int) (pokemon[i].getAttackPower() + (pokemon[i].getAttackPower() * 0.2)));
                pokemon[i].setDefense( (int) (pokemon[i].getDefense() + (pokemon[i].getDefense() * 0.2)));
            }
        }
    }
}
