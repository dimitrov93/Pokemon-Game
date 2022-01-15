import com.company.Pokemon;
import org.junit.Assert;
import org.junit.Test;

public class EnemyPokemonTest {
    public Pokemon[] pokemon;

    @Test
    public void EnemyPokemonNameTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Assert.assertEquals("Something is wrong with the name!","Bulbasaur",pokemon[0].getName());
    }

    @Test
    public void EnemyPokemonAPWithNoTypeTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Assert.assertEquals("Something is wrong with the AP!",56,pokemon[0].getAttackPower());
    }

    @Test
    public void EnemyPokemonAPWithTypeSmallTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Roselia", "Grass", "Small", 50, 60, 45);
        addingExtraType();
        Assert.assertEquals("Something is wrong with the AP!",48,pokemon[0].getAttackPower());
    }

    @Test
    public void EnemyPokemonAPWithTypeBigTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Corsola", "Water", "Big", 65, 65, 95);
        addingExtraType();
        Assert.assertEquals("Something is wrong with the AP!",78,pokemon[0].getAttackPower());
    }

    @Test
    public void EnemyPokemonHPWithTypeBigTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Corsola", "Water", "Big", 65, 65, 95);
        addingExtraType();
        Assert.assertEquals("Something is wrong with the HP!",78,pokemon[0].getHealthPoints());
    }

    @Test
    public void EnemyPokemonHPWithTypeSmallTest() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Roselia", "Grass", "Small", 50, 60, 45);
        addingExtraType();
        Assert.assertEquals("Something is wrong with the HP!",40,pokemon[0].getHealthPoints());
    }

    @Test
    public void DefenceWithNoType() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Roselia", "Grass", "Small", 50, 60, 45);
        Assert.assertEquals("Something is wrong!",45,pokemon[0].getDefensePoints());
    }

    @Test
    public void DefenceWithSmallType() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Roselia", "Grass", "Small", 50, 60, 45);
        addingExtraType();
        Assert.assertEquals("Something is wrong!",36,pokemon[0].getDefensePoints());
    }

    @Test
    public void DefenceWithBigType() {
        this.pokemon = new Pokemon[1];
        pokemon[0] = new Pokemon("Corsola", "Water", "Big", 65, 65, 95);
        addingExtraType();
        Assert.assertEquals("Something is wrong!",114,pokemon[0].getDefensePoints());
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
