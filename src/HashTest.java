import org.testng.annotations.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.testng.AssertJUnit.assertEquals;

public class HashTest {
    private MessageDigest sha1Real = MessageDigest.getInstance("SHA-1");

    public HashTest() throws NoSuchAlgorithmException {
    }
    @Test
    public void TestString(){

        assertEquals(0,0);
    }
}
