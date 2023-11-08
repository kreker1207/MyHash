import org.testng.annotations.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.testng.AssertJUnit.assertEquals;
// My realisation hashing but not
public class HashTest {
    private final MessageDigest sha1Real = MessageDigest.getInstance("SHA-1");

    public HashTest() throws NoSuchAlgorithmException {
    }
    @Test
    public void TestString1(){
        String value = "3213211aasdw";
        assertEquals(bytesToHex(sha1Real.digest(value.getBytes())),SHA1.hashSHA1(value));
    }
    @Test
    public void TestString2(){
        String value = "esa;kw[]p=130dsad,20i12k312 3219s[a.,,sa;kdk2op130-][sadeoiwqoipdlknfieofivnfdjnrjewio 21032ods";
        assertEquals(bytesToHex(sha1Real.digest(value.getBytes())),SHA1.hashSHA1(value));
    }
    @Test
    public void TestString3(){
        String value = "e";
        assertEquals(bytesToHex(sha1Real.digest(value.getBytes())),SHA1.hashSHA1(value));
    }
    @Test
    public void TestInteger1(){
        Integer vale = 38901834;
        assertEquals(bytesToHex(sha1Real.digest(vale.toString().getBytes())),SHA1.hashSHA1(vale));
    }
    @Test
    public void TestInteger2() {
        Integer vale = 1;
        assertEquals(bytesToHex(sha1Real.digest(vale.toString().getBytes())), SHA1.hashSHA1(vale));
    }
    @Test
    public void TestInteger3(){
        Integer vale = 120720;
        assertEquals(bytesToHex(sha1Real.digest(vale.toString().getBytes())),SHA1.hashSHA1(vale));
       }
    @Test
    public void TestObject1(){
        User value = new User(1,"Ivan", 20,false);
       assertEquals(bytesToHex(sha1Real.digest(value.toString().getBytes())),SHA1.hashSHA1(value));
    }
    @Test
    public void TestObject2(){
        User value = new User(13,"Vladislav", 10,true);
        assertEquals(bytesToHex(sha1Real.digest(value.toString().getBytes())),SHA1.hashSHA1(value));
    }
    @Test
    public void TestObject3(){
        User value = new User(4,"Ivan", 20,false);
        assertEquals(bytesToHex(sha1Real.digest(value.toString().getBytes())),SHA1.hashSHA1(value));
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
