package exercises;

public class Exercise7 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = 0;
        c = b;
        b = a;
        a = c;
        System.out.printf("A = %d, B = %d, C = %d\n", a, b, c);
    }
}
