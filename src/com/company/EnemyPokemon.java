package com.company;

public class EnemyPokemon extends PokemonPoints{
    protected Pokemon[] pokemon;

    public EnemyPokemon() {
        this.pokemon = new Pokemon[5];
        pokemon[0] = new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        pokemon[1] = new Pokemon("Butterfree", "Flying", "Small", 60, 45, 50);
        pokemon[2] = new Pokemon("Corsola", "Water", "Big", 65, 65, 95);
        pokemon[3] = new Pokemon("Roselia", "Grass", "Small", 50, 60, 45);
        pokemon[4] = new Pokemon("Yanma", "Flying", "Medium", 65, 65, 45);

        changePokemonPointsAboutTheirType(pokemon);
    }
}
