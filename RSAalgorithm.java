public class RSAalgorithm {
    
    public static long gcd(long a, long h) {
        if (h == 0) return a;
        else return gcd(h, a%h);
    }

    public static long modInverse(long a, long m) {
        if (a == 0) return -1;
        if (a < 0)
            a += m;
        long m0 = m;
        long y = 0, x = 1;
        if (m == 1)
            return 0;

        while (a > 1) {
            if (m == 0)
                return -1;
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }
    
    public static void main(String[] args) {
        long p = 3;
        long q = 7;
        long msg = 11;
        long n = p*q;
        long e = 2;
        long phi = (p-1) * (q-1);
        while(e < phi) {
            if (gcd(e, phi) == 1) {
                break;
            }
            else e++;
        }
        long d = modInverse(e, phi);
        long enc = (long) Math.pow(msg, e);
        enc = enc % n;
        long dec = (long) Math.pow(enc, d);
        dec = dec % n;
        System.out.println("Original Message: " + msg);
        System.out.println("Encrypted Message: " + enc);
        System.out.println("Decrypted Message: " + dec);
    }
}
