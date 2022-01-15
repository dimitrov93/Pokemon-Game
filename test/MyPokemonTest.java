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
        String actual = pokemon[0].getName();
        String msg = "Something is wrong with the name of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonAPWithoutTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        int expected = 55;
        int actual = pokemon[0].getAttackPower();
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonAPWithTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        addingExtraType();
        int expected = 100;
        int actual = pokemon[0].getAttackPower();
        String msg = "Something is wrong with the AP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonHPWitouthTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        int expected = 78;
        int actual = pokemon[0].getHealthPoints();
        String msg = "Something is wrong with the HP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonHPWithTypeBigTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Charizard", "Flame", "Big", 78, 84,78 );
        addingExtraType();
        int expected = 93;
        int actual = pokemon[0].getHealthPoints();
        String msg = "Something is wrong with the HP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }


    @Test
    public void pokemonHPWithOutTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        int expected = 85;
        int actual = pokemon[0].getHealthPoints();
        String msg = "Something is wrong with the HP of the pokemon!";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void pokemonHPWithTypeSmallTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Crobat", "Flying", "Small", 85, 90, 85);
        addingExtraType();
        int expected = 68;
        int actual = pokemon[0].getHealthPoints();
        String msg = "Something is wrong with the HP of the pokemon!";
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

        String expected = "name:Fearow; type:Flying; size:Medium; healthPoints:65; attackPower:90; defense:65";
        Pokemon actual = pokemon[4];
        String msg = "Something went wrong with the printing";
        Assert.assertEquals(msg,expected,actual.toString());
    }

    private void addingExtraType() {
        for (int i = 0; i < 1; i++) {
            if (pokemon[i].getSize().equals("Small")) {
                pokemon[i].setHealthPoints((int) (pokemon[i].getHealthPoints() - (pokemon[i].getHealthPoints() * 0.2)));
                pokemon[i].setAttackPower((int) (pokemon[i].getAttackPower() - (pokemon[i].getAttackPower() * 0.2)));
                pokemon[i].setDefensePoints((int) (pokemon[i].getDefensePoints() - (pokemon[i].getDefensePoints() * 0.2)));
            } else if (pokemon[i].getSize().equals("Big")) {
                pokemon[i].setHealthPoints((int) (pokemon[i].getHealthPoints() + (pokemon[i].getHealthPoints() * 0.2)));
                pokemon[i].setAttackPower((int) (pokemon[i].getAttackPower() + (pokemon[i].getAttackPower() * 0.2)));
                pokemon[i].setDefensePoints( (int) (pokemon[i].getDefensePoints() + (pokemon[i].getDefensePoints() * 0.2)));
            }
        }
    }
}