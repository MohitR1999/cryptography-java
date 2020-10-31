public class DiffieHellman {
    public static void main(String[] args) {
        Integer x = 8;
        Integer y = 10;
        Integer n = 47;
        Integer g = 3;
        Long r1 = Math.round(Math.pow(g, x)) % n;
        Long r2 = Math.round(Math.pow(g, y)) % n;
        Long f1 = Math.round(Math.pow(r1, y)) % n;
        Long f2 = Math.round(Math.pow(r2, x)) % n;
        System.out.println(f1);
        System.out.println(f2);
    }
}
