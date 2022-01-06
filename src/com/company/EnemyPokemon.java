package com.company;

import java.util.*;

public class EnemyPokemon{
    protected Pokemon[] pokemon;
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
