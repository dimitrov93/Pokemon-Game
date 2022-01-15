import com.company.Awards;
import org.junit.Assert;
import org.junit.Test;

public class AwardsTest {
    @Test
    public void testCrystalGenerator(){
        Awards awards=new Awards();
        Assert.assertEquals("Wrong count crystals",11,awards.crystalGenerator());
    }

    @Test
    public void testCrystalGeneratorSecondTime()
    {
        Awards awards=new Awards();
        awards.crystalGenerator();
        Assert.assertEquals("Wrong count crystals",22,awards.crystalGenerator());
    }
}
