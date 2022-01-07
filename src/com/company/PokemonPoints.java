package com.company;

public abstract class PokemonPoints {

    public void changePokemonPointsAboutTheirType(Pokemon[] pokemon){
        changeHealthPointAboutTheirType(pokemon);
        changeAttackPowerAboutTheirType(pokemon);
        changeDefenceAboutTheirType(pokemon);
    }

    private int[] changeAttackPowerAboutTheirType(Pokemon[]pokemon){
        int attackPower[]=new int[pokemon.length];
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i].getSize().equals("Small")) {
                pokemon[i].setAttackPower((int) (pokemon[i].getAttackPower() - (pokemon[i].getAttackPower() * 0.2)));
                attackPower[i]=pokemon[i].getAttackPower();
            } else if (pokemon[i].getSize().equals("Big")) {
                pokemon[i].setAttackPower((int) (pokemon[i].getAttackPower() + (pokemon[i].getAttackPower() * 0.2)));
                attackPower[i]=pokemon[i].getAttackPower();
            }
        }
        return attackPower;
    }

    private int[] changeHealthPointAboutTheirType(Pokemon[]pokemon){
        int healthPoints[]=new int[pokemon.length];
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i].getSize().equals("Small")) {
                pokemon[i].setHealthPoints((int) (pokemon[i].getHealthPoints() - (pokemon[i].getHealthPoints() * 0.2)));
               healthPoints[i]=pokemon[i].getHealthPoints();
            } else if (pokemon[i].getSize().equals("Big")) {
                pokemon[i].setHealthPoints((int) (pokemon[i].getHealthPoints() + (pokemon[i].getHealthPoints() * 0.2)));
                healthPoints[i]=pokemon[i].getHealthPoints();
            }
        }
        return healthPoints;
    }

    private int[] changeDefenceAboutTheirType(Pokemon[] pokemon){
        int defence[]=new int[pokemon.length];
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i].getSize().equals("Small")) {
                pokemon[i].setDefense((int) (pokemon[i].getDefense() - (pokemon[i].getDefense() * 0.2)));
                defence[i]=pokemon[i].getDefense();
            } else if (pokemon[i].getSize().equals("Big")) {
                pokemon[i].setDefense( (int) (pokemon[i].getDefense() + (pokemon[i].getDefense() * 0.2)));
                defence[i]=pokemon[i].getDefense();
            }
        }
        return defence;
    }
}
