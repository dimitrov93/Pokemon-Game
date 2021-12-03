import com.company.Pokemon;
import com.company.Winner;
import com.company.YourTeam;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class WinnerTest extends YourTeam {
    YourTeam yourTeam = new YourTeam();
    public ArrayList<Pokemon> myPokemon = new ArrayList<>();

    @Test
    public void enemyWinsTesting() {
        String winner = "";
        if (yourTeam.myPokemon.size() <= 0) {
            winner = "The enemy";
        } else {
            System.out.println(yourTeam.trainerName() + " you win!");
            winner = yourTeam.trainerName();
        }
        Assert.assertEquals("Error","The enemy",winner);
    }

    @Test
    public void weWinTesting() {
        myPokemon.add(0,new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40));
        String winner = "";
        if (myPokemon.size() <= 0) {
            winner = "The enemy";
        } else {
            winner = "I win";
        }
        Assert.assertEquals("Error","I win",winner);
    }
}
