public interface PokemonInterface{
    void createPokemon(String name, int health, String type);
    void attackPokemon(Pokemon pokemon);
    Pokemon pokemonInfo(Pokemon pokemon);
}