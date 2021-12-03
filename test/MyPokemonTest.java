import com.company.Pokemon;
import org.junit.Assert;
import org.junit.Test;

public class MyPokemonTest {
    public Pokemon[] pokemon;

    @Test
    public void pokemonNameTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        String expected = "Pikachu";
        String actual = pokemon[0].name;
        String msg = "Something is wrong with the name of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonAPWithoutTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        int expected = 55;
        int actual = pokemon[0].AP;
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonAPWithTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        addingExtraType();
        int expected = 100;
        int actual = pokemon[0].AP;
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonHPWitouthTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        int expected = 78;
        int actual = pokemon[0].HP;
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonHPWithTypeBigTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        addingExtraType();
        int expected = 93;
        int actual = pokemon[0].HP;
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }


    @Test
    public void pokemonHPWithOutTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        int expected = 85;
        int actual = pokemon[0].HP;
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonHPWithTypeSmallTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        addingExtraType();
        int expected = 68;
        int actual = pokemon[0].HP;
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void printLastPokeonTest() {
        this.pokemon = new Pokemon[5];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        pokemon[1] = new Pokemon("Squirtle", "Aqual", "Small", 55, 48, 65);
        pokemon[2] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        pokemon[3] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        pokemon[4] = new Pokemon("Fearow", "Flying", "Medium", 65, 90, 65);

        addingExtraType();

        String expected = "name:Fearow; type:Flying; size:Medium; HP:65; AP:90; DP:65";
        Pokemon actual = pokemon[4];
        String msg = "Something went wrong with the printing";
        Assert.assertEquals(msg,expected,actual.toString());
    }

    private void addingExtraType() {
        for (int i = 0; i < pokemon.length; i++) {
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
