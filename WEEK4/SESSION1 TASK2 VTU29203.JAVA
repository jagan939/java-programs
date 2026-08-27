import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            String left, right;

            if (n % 2 == 0) {
                left = s.substring(0, n / 2);
                right = s.substring(n / 2);
            } else {
                left = s.substring(0, n / 2);
                right = s.substring(n / 2 + 1);
            }

            char[] a = left.toCharArray();
            char[] b = right.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

OUTPUT:
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
OUTPUT
YES
NO
YES
YES
NO
NO
