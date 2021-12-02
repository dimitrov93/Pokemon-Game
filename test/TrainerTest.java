import com.company.Trainer;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TrainerTest {
    @Test
    public void testTrainerName(){
        Trainer trainer=new Trainer();
        String input="trainer";
        InputStream in=new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assert.assertEquals("Error","trainer",trainer.trainerName());
    }
}
