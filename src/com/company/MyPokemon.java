package com.company;

public class MyPokemon extends PokemonPoints {
    protected Pokemon[] pokemon;

    public MyPokemon() {
        this.pokemon = new Pokemon[5];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        pokemon[1] = new Pokemon("Squirtle", "Aqual", "Small", 55, 48, 65);
        pokemon[2] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        pokemon[3] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        pokemon[4] = new Pokemon("Fearow", "Flying", "Medium", 65, 90, 65);

        changePokemonPointsAboutTheirType(pokemon);
    }
}
