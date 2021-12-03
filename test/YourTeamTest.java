import com.company.Main;
import com.company.MyPokemon;
import com.company.Pokemon;
import com.company.YourTeam;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class YourTeamTest extends YourTeam {
    @Test
    public  void testChoosePokemonInBattle(){
        String msg="Wrong pokemon";
        ArrayList<Pokemon>actual=choosePokemonInBattle(1);
        ArrayList<Pokemon>expected=new ArrayList<>();
        expected.add(pokemon[0]);
        Assert.assertEquals(msg,expected,actual);
    }

    @Test
    public void testYouChooseOnePokemonWeChooseFirstPokemon(){
        YourTeam yourTeam=new YourTeam();
        Pokemon pokemon=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        yourTeam.myPokemon.add(pokemon);
        yourTeam.myPokemon.add(new Pokemon("Squirtle", "Aqual", "Small", 55, 48, 65));
        yourTeam.myPokemon.add(new Pokemon("Charizard", "Flame", "Big", 78, 84,78));
        Pokemon actual=yourTeam.youChooseOnePokemon(1);
        Pokemon expected=yourTeam.myPokemon.get(0);
        Assert.assertEquals("Wrong pokemon!",expected,actual);

    }

}
