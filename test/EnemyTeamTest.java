import com.company.EnemyTeam;
import com.company.Pokemon;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public  class EnemyTeamTest  implements  Comparable {
    EnemyTeam enemyTeam=new EnemyTeam();
    @Override
    public int compareTo(Object o) {
        int compared=((EnemyTeam)o).name.length();
        return enemyTeam.name.length()-compared;
    }

    @Test
    public void testRandomEnemyPokemonInBattle(){
//        String msg="Wrong pokemons! ";
//        ArrayList<Pokemon>expected=new ArrayList<Pokemon>();
//        ArrayList<Pokemon>actual=enemyTeam.randomEnemyPokemonInBattle();
//        expected.add(enemyTeam.pokemon[0]);
//        expected.add(enemyTeam.pokemon[1]);
//        expected.add(enemyTeam.pokemon[2]);
//        Collections.sort(expected);
//
//        Assert.assertEquals(msg,expected,actual);
    }


}