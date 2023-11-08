import java.nio.ByteBuffer;
import java.util.Arrays;

public class SHA1 {
    private static final int[] h = new int[]{
            0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476, 0xC3D2E1F0
    };

    private static byte[] bytes;

    public static void setBytes(Object data) {
        bytes = data.toString().getBytes();
    }

    public static String hashSHA1(Object data) {
        setBytes(data);
        long ml = (long) bytes.length * 8;
        bytes = appendPadding(bytes, ml);
        System.out.println(Arrays.toString(bytes));
        for (int i = 0; i < bytes.length; i += 64) {
            // Break chunk into sixteen 32-bit big-endian words
            int[] w = breakChunk(bytes, i);

            // Message schedule: extend the words to 80
            extendMessageSchedule(w);

            // Initialize hash values
            int a = h[0];
            int b = h[1];
            int c = h[2];
            int d = h[3];
            int e = h[4];

            // Main loop
            for (int j = 0; j < 80; j++) {
                int f, k;
                if (j < 20) {
                    f = (b & c) | ((~b) & d);
                    k = 0x5A827999;
                } else if (j < 40) {
                    f = b ^ c ^ d;
                    k = 0x6ED9EBA1;
                } else if (j < 60) {
                    f = (b & c) | (b & d) | (c & d);
                    k = 0x8F1BBCDC;
                } else {
                    f = b ^ c ^ d;
                    k = 0xCA62C1D6;
                }

                int temp = Integer.rotateLeft(a, 5) + f + e + k + w[j];
                e = d;
                d = c;
                c = Integer.rotateLeft(b, 30);
                b = a;
                a = temp;
            }

            // Update hash values
            h[0] += a;
            h[1] += b;
            h[2] += c;
            h[3] += d;
            h[4] += e;
        }

        // Produce the final hash value (big-endian)
        byte[] result = new byte[20];
        ByteBuffer buffer = ByteBuffer.wrap(result);
        buffer.putInt(h[0]);
        buffer.putInt(h[1]);
        buffer.putInt(h[2]);
        buffer.putInt(h[3]);
        buffer.putInt(h[4]);

        return bytesToHex(result);
    }

    private static void extendMessageSchedule(int[] w) {
        for (int i = 16; i < 80; i++) {
            w[i] = Integer.rotateLeft(w[i - 3] ^ w[i - 8] ^ w[i - 14] ^ w[i - 16], 1);
        }
    }

    private static int[] breakChunk(byte[] bytes, int i) {
        int[] w = new int[80];
        int chunkSize = bytes.length - i; // Calculate the remaining chunk size

        for (int j = 0; j < 16; j++) {
            if (j * 4 + 4 <= chunkSize) {
                int from = i + j * 4;
                int to = from + 4;
                w[j] = ByteBuffer.wrap(Arrays.copyOfRange(bytes, from, to)).getInt();
            }
        }
        return w;
    }

    private static byte[] appendPadding(byte[] bytes, long ml) {
        int paddingLength = (int) ((64 - ((ml + 8) % 64)) % 64);
        byte[] padding = new byte[paddingLength + 8];
        padding[0] = (byte) 0x80;

        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(ml);
        byte[] mlBytes = buffer.array();

        byte[] result = new byte[bytes.length + padding.length + mlBytes.length];
        System.arraycopy(bytes, 0, result, 0, bytes.length);
        System.arraycopy(padding, 0, result, bytes.length, padding.length);
        System.arraycopy(mlBytes, 0, result, bytes.length + padding.length, mlBytes.length);

        return result;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

}
