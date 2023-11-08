# MyHash
## SHA-1

SHA-1 (Secure Hash Algorithm 1) is a cryptographic hashing algorithm used to generate a unique hash code of input data. It accepts messages of any length as input and generates a fixed hash code of 160 bits (20 bytes).

## Install

1. Clone the project:
```bash
git clone https://github.com/kreker1207/MyHash.git
```
2. Navigate to the project directory
3. Compile the Java code: javac Main.java
4. Run the application: ```ava Main ```

## Hash match test with library implementation
My hash test implementation could be found in HashTest.Java. It compare results from my algorithm and external method from ``MessageDigest.class``. Unfortunately my hash value differs from the expected result.
The resource for creating my algorithm was [SHA-1 on Wikipedia](https://en.wikipedia.org/wiki/SHA-1)

## Comparison of the performance of my own implementation with the library implementation
![memEx](https://github.com/kreker1207/MyHash/assets/93523707/f33ce70f-fa39-413f-9981-b9522ed19daa)
<br>
![memMy](https://github.com/kreker1207/MyHash/assets/93523707/c03c40d5-3c63-4367-9a65-12bfbd52a14e)
 <br>
My realisation trying to make everything as fast as it can like using ``StringBuilder`` to not clog a heap, also i was using static methods because of fast perfomance. As a consequence- my realisation perfomance is approximaetly equal to external one but due to the ``bytesToHex`` method - it takes much longer to perfom converion to Hex represintation. The problem of measuring is that in external implementation - it returns a byte array but my code returns Hex representation in String which taces much time to compute.<br>
<br>
![perfMy](https://github.com/kreker1207/MyHash/assets/93523707/58899d74-e1dc-48e5-a19d-32a3dfcef5d7)
<br>
![perfEx](https://github.com/kreker1207/MyHash/assets/93523707/4a6cd274-08e0-4e2d-93c3-5fd47561e466)
