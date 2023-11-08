import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String test1 = "wqeerttyuuio dklkwoeom, f2@,fk][ ddfd";
        Integer test2 = 1234376578;
        BigInteger test3 = new BigInteger("890732545675444229043201");
        System.out.println(SHA1.hashSHA1(test1));
        SHA1.hashSHA1(test2);
        SHA1.hashSHA1(test3);

    }
}