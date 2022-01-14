import com.company.EnemyAttacks;
import com.company.Pokemon;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnemyAttacksTest {
    public Pokemon[]yourPokemon;
    public Pokemon[]enemyPokemon;
    @Test
    public void testPcAttackingYouWithLowAbility(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.yourPokemon=new Pokemon[1];
        this.enemyPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon yourChoice=yourPokemon[0];
        Pokemon enemyChoice=enemyPokemon[0] ;
        Assert.assertEquals("Wrong HP!",3,enemyAttacks.pcAttackingYouWithLowAbility(yourChoice,enemyChoice));

    }

    @Test
    public void testPcAttackingYouWithMediumAbility(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.yourPokemon=new Pokemon[1];
        this.enemyPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon yourChoice=yourPokemon[0];
        Pokemon enemyChoice=enemyPokemon[0] ;
        Assert.assertEquals("Wrong HP!",-2,enemyAttacks.pcAttackingYouWithMediumAbility(yourChoice,enemyChoice));

    }

    @Test
    public void testPcAttackingYouWithHighAbility(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.yourPokemon=new Pokemon[1];
        this.enemyPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon yourChoice=yourPokemon[0];
        Pokemon enemyChoice=enemyPokemon[0] ;
        Assert.assertEquals("Wrong HP!",-7,enemyAttacks.pcAttackingYouWithHighAbility(yourChoice,enemyChoice));

    }

    @Test
    public void testPcUseShield(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.enemyPokemon=new Pokemon[1];
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon enemyChoice=enemyPokemon[0] ;
        Assert.assertEquals("Wrong DP!",54,enemyAttacks.pcUseShield(enemyChoice));
    }
}
