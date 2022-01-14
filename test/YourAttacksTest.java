import com.company.Pokemon;
import com.company.YourAttacks;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class YourAttacksTest {
    public Pokemon[]yourPokemon;
    public Pokemon[]enemyPokemon;
    @Test
    public void testYouAttackingPcWithLowAbility(){
        YourAttacks yourAttacks=new YourAttacks();
        this.yourPokemon=new Pokemon[1];
        this.enemyPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon yourChoice=yourPokemon[0];
        Pokemon enemyChoice=enemyPokemon[0] ;
        Assert.assertEquals("Wrong HP!",19,yourAttacks.youAttackingPcWithLowAbility(yourChoice,enemyChoice));
    }

    @Test
    public void testYouAttackingPcWithMediumAbility(){
        YourAttacks yourAttacks=new YourAttacks();
        this.yourPokemon=new Pokemon[1];
        this.enemyPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon yourChoice=yourPokemon[0];
        Pokemon enemyChoice=enemyPokemon[0] ;;
        Assert.assertEquals("Wrong HP!",14,yourAttacks.youAttackingPcWithMediumAbility(yourChoice,enemyChoice));
    }
    @Test
    public void testYouAttackingPcWithHighAbility(){
        YourAttacks yourAttacks=new YourAttacks();
        this.yourPokemon=new Pokemon[1];
        this.enemyPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyPokemon[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        Pokemon yourChoice=yourPokemon[0];
        Pokemon enemyChoice=enemyPokemon[0] ;
        Assert.assertEquals("Wrong HP!",9,yourAttacks.youAttackingPcWithHighAbility(yourChoice,enemyChoice));
    }

    @Test
    public void testYouUseShied(){
        YourAttacks yourAttacks=new YourAttacks();
        this.yourPokemon=new Pokemon[1];
        yourPokemon[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        Pokemon yourChoice=yourPokemon[0];
        Assert.assertEquals("Wrong DP!",45,yourAttacks.youUseShield(yourChoice));


    }
}
