import com.company.EnemyAttacks;
import com.company.Pokemon;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnemyAttacksTest {
    public Pokemon[]yourChoice;
    public Pokemon[]enemyChoice;
    @Test
    public void testPcAttackingYouWithLowAbility(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.yourChoice=new Pokemon[1];
        this.enemyChoice=new Pokemon[1];
        yourChoice[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyChoice[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        ArrayList<Pokemon> yourChoice1=new ArrayList<>(Arrays.asList(yourChoice)) ;
        ArrayList<Pokemon> enemyChoice1=new ArrayList<>(Arrays.asList(enemyChoice)) ;
        Assert.assertEquals("Wrong HP!",3,enemyAttacks.pcAttackingYouWithLowAbility(yourChoice1,enemyChoice1));

    }

    @Test
    public void testPcAttackingYouWithMediumAbility(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.yourChoice=new Pokemon[1];
        this.enemyChoice=new Pokemon[1];
        yourChoice[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyChoice[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        ArrayList<Pokemon> yourChoice1=new ArrayList<>(Arrays.asList(yourChoice)) ;
        ArrayList<Pokemon> enemyChoice1=new ArrayList<>(Arrays.asList(enemyChoice)) ;
        Assert.assertEquals("Wrong HP!",-2,enemyAttacks.pcAttackingYouWithMediumAbility(yourChoice1,enemyChoice1));

    }

    @Test
    public void testPcAttackingYouWithHighAbility(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.yourChoice=new Pokemon[1];
        this.enemyChoice=new Pokemon[1];
        yourChoice[0]=new Pokemon("Pikachu", "Electric", "Medium", 35, 55, 40);
        enemyChoice[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        ArrayList<Pokemon> yourChoice1=new ArrayList<>(Arrays.asList(yourChoice)) ;
        ArrayList<Pokemon> enemyChoice1=new ArrayList<>(Arrays.asList(enemyChoice)) ;
        Assert.assertEquals("Wrong HP!",-7,enemyAttacks.pcAttackingYouWithHighAbility(yourChoice1,enemyChoice1));

    }

    @Test
    public void testPcUseShield(){
        EnemyAttacks enemyAttacks=new EnemyAttacks();
        this.enemyChoice=new Pokemon[1];
        enemyChoice[0]=new Pokemon("Bulbasaur", "Grass", "Medium", 45, 56, 49);
        ArrayList<Pokemon> enemyChoice1=new ArrayList<>(Arrays.asList(enemyChoice)) ;
        Assert.assertEquals("Wrong DP!",54,enemyAttacks.pcUseShield(enemyChoice1));
    }
}
