public abstract class AbstractMon implements PokemonInterface{
    public void createPokemon(String name, int health, String type){
        Pokemon pokemon = new Pokemon(name, health, type);
    }
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
    }
}