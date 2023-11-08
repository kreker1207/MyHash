import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        String test1 = "wqeerttyuuio dklkwoeom, f2@,fk][ ddfd";
        int test2 = 1234376578;
        BigInteger test3 = new BigInteger("890732545675444229043201");
        User test4 = new User(1,"Kiril",20,false);
        System.out.println(SHA1.hashSHA1(test1));
        System.out.println(SHA1.hashSHA1(test2));
        System.out.println(SHA1.hashSHA1(test3));
        System.out.println(SHA1.hashSHA1(test4));

    }
}