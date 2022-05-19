import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
public class rangerInputTest {
    @Test
    public void checkRangerInput(){
        ranger testRanger = new ranger("TestCase");
        assertEquals(testRanger.getName(),"TestCase123");// Will Fail
    }
}
